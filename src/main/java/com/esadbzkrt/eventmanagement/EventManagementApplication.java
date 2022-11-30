package com.esadbzkrt.eventmanagement;

import com.esadbzkrt.eventmanagement.model.Event;
import com.esadbzkrt.eventmanagement.repository.EventRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;


@SpringBootApplication
public class EventManagementApplication {

    public static void main(String[] args) {
        SpringApplication.run(EventManagementApplication.class, args);
    }

    @Bean
    CommandLineRunner runner(EventRepository eventRepository) {
        return args -> {
            eventRepository.save(new Event(1L, "Java User Group", "02.12.2022", "11.12.2022", 50, 30));
            eventRepository.save(new Event(2L, "Spring User Group", "22.12.2022", "24.12.2022", 65, 20));
            eventRepository.save(new Event(3L, "Hibernate User Group", "05.12.2022", "08.12.2022", 100, 14));
        };
    }
}
