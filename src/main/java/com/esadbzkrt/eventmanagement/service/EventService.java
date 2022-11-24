package com.esadbzkrt.eventmanagement.service;

import com.esadbzkrt.eventmanagement.exception.EventNotFoundException;
import com.esadbzkrt.eventmanagement.model.Event;
import com.esadbzkrt.eventmanagement.repository.EventRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EventService {

    private final EventRepository eventRepository;

    public EventService(EventRepository eventRepository) {
        this.eventRepository = eventRepository;
    }


    public List<Event> getAllEvents() {
        return eventRepository.findAll();
    }

    public Event getEventById(Long id) {
        return eventRepository.findById(id)
                .orElseThrow(
                        () -> new EventNotFoundException("Event not found with id: " + id));
    }

    public Event createEvent(Event event) {
        return eventRepository.save(event);
    }

    public Event updateEvent(Long id, Event event) {
        Event eventToUpdate = eventRepository.findById(id).orElseThrow();
        eventToUpdate.setEventName(event.getEventName());
        eventToUpdate.setEventStartDate(event.getEventStartDate());
        eventToUpdate.setEventEndDate(event.getEventEndDate());
        eventToUpdate.setEventCapacity(event.getEventCapacity());
        eventToUpdate.setParticipantsCount(event.getParticipantsCount());
        return eventRepository.save(eventToUpdate);
    }

    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }
}
