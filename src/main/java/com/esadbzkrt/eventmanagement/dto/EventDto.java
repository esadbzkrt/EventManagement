package com.esadbzkrt.eventmanagement.dto;

import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EventDto {

        private Long id;
        private String eventName;
        private String eventStartDate;
        private String eventEndDate;
        private Integer eventCapacity;
        private Integer participantsCount;

}
