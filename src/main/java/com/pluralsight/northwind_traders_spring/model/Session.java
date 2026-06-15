package com.pluralsight.northwind_traders_spring.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
@Entity
@Table(name = "sessions")
public class Session {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String speaker;
    private LocalDateTime startTime;
    private LocalDateTime endTime;
    private String room;
    private String track;
    // Getters and setters omitted

}