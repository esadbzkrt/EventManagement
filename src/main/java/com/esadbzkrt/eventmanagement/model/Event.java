package com.esadbzkrt.eventmanagement.model;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "events")
@Getter
@Setter
@AllArgsConstructor
@RequiredArgsConstructor
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(unique = true, nullable = false)
    private String EventName;

    @Column(nullable = false)
    private String EventStartDate;

    @Column(nullable = false)
    private String EventEndDate;

    @Column(nullable = false)
    private Short EventCapacity;

    @Column(nullable = false)
    private Short ParticipantsCount;


}
