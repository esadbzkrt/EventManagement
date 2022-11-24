package com.esadbzkrt.eventmanagement.service;

import com.esadbzkrt.eventmanagement.dto.EventDto;
import com.esadbzkrt.eventmanagement.exception.EventNotFoundException;
import com.esadbzkrt.eventmanagement.model.Event;
import com.esadbzkrt.eventmanagement.repository.EventRepository;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventService {

    private final EventRepository eventRepository;
    private final ModelMapper modelMapper;

    public EventService(EventRepository eventRepository, ModelMapper modelMapper) {
        this.eventRepository = eventRepository;
        this.modelMapper = modelMapper;
    }

    public List<EventDto> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(event -> modelMapper.map(event, EventDto.class))
                .collect(Collectors.toList());
    }

    public EventDto getEventById(Long id) {
        return eventRepository.findById(id)
                .map(event -> modelMapper.map(event, EventDto.class))
                .orElseThrow(() -> new EventNotFoundException("Event not found with id: " + id));
    }

    public EventDto createEvent(EventDto eventDto) {
        Event event = modelMapper.map(eventDto, Event.class);
        return modelMapper.map(eventRepository.save(event), EventDto.class);
    }

    public EventDto updateEvent(Long id, EventDto eventDto) {
        Event eventToUpdate = eventRepository.findById(id).orElseThrow(()->
                new EventNotFoundException("Event not found with id: " + id));
        eventToUpdate.setEventName(eventDto.getEventName());
        eventToUpdate.setEventStartDate(eventDto.getEventStartDate());
        eventToUpdate.setEventEndDate(eventDto.getEventEndDate());
        eventToUpdate.setEventCapacity(eventDto.getEventCapacity());
        eventToUpdate.setParticipantsCount(eventDto.getParticipantsCount());
        return modelMapper.map(eventRepository.save(eventToUpdate), EventDto.class);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
