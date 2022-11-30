package com.esadbzkrt.eventmanagement.model;

import lombok.*;

import javax.persistence.*;

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
    private String eventName;

    @Column(nullable = false)
    private String eventStartDate;

    @Column(nullable = false)
    private String eventEndDate;

    @Column(nullable = false)
    private Integer eventCapacity;

    @Column(nullable = false)
    private Integer participantsCount;


}
