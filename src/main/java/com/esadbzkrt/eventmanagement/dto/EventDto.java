package com.esadbzkrt.eventmanagement.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;

@Data
@AllArgsConstructor
@RequiredArgsConstructor
@NoArgsConstructor
public class EventDto {

        private Long id;
        private String EventName;
        private String EventStartDate;
        private String EventEndDate;
        private Short EventCapacity;
        private Short ParticipantsCount;

}
