package com.esadbzkrt.eventmanagement;

import com.esadbzkrt.eventmanagement.model.Event;
import com.esadbzkrt.eventmanagement.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class EventManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EventRepository eventRepository) {
        return args -> {
            eventRepository.save(new Event(1L,"Java User Group", "2021-01-01", "2021-01-02", (short) 100, (short) 0));
            eventRepository.save(new Event(2L,"Spring User Group", "2021-01-01", "2021-01-02", (short) 100, (short) 0));
            eventRepository.save(new Event(3L,"Hibernate User Group", "2021-01-01", "2021-01-02", (short) 100, (short) 0));
        };
    }
}
