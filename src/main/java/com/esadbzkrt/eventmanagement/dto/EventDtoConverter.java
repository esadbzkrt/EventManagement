package com.esadbzkrt.eventmanagement.dto;

import com.esadbzkrt.eventmanagement.model.Event;
import org.springframework.stereotype.Component;

@Component
public class EventDtoConverter {

public EventDto convert(Event from) {
        return new EventDto(
                from.getId(),
                from.getEventName(),
                from.getEventStartDate(),
                from.getEventEndDate(),
                from.getEventCapacity(),
                from.getParticipantsCount()
        );
    }
}
