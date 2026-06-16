package com.pluralsight.northwind_traders_spring.controller;

import com.pluralsight.northwind_traders_spring.model.Session;
import com.pluralsight.northwind_traders_spring.service.SessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/sessions")
public class SessionController {

    private final SessionService sessionService;

    public SessionController(SessionService sessionService){
        this.sessionService = sessionService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<Session> getSessionById(@PathVariable Long id) {
        return sessionService.getSessionById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

   @GetMapping
   public List<Session> searchSessions(
           @RequestParam(required = false) String speaker,
           @RequestParam(required = false) String title,
           @RequestParam(required = false) String room,
           @RequestParam(required = false) String track){
        return sessionService.searchSessions(speaker, title, room, track);
   }

    @PostMapping
    public Session creatSession(@RequestBody Session session) {
        return sessionService.createSession(session);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSession(@PathVariable Long id) {
        sessionService.deleteSession(id);
        return ResponseEntity.noContent().build();
    }
}
