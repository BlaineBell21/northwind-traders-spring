package com.pluralsight.northwind_traders_spring.service;

import com.pluralsight.northwind_traders_spring.model.Session;
import com.pluralsight.northwind_traders_spring.repositories.SessionRepository;
import com.pluralsight.northwind_traders_spring.utils.SessionSpecifications;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SessionService {

    private final SessionRepository sessionRepository;

    public SessionService(SessionRepository sessionRepository) {
        this.sessionRepository = sessionRepository;
    }

    public List<Session> searchSessions(
            String speaker,
            String title,
            String room,
            String track){

        Specification<Session> spec = Specification.allOf();

        if(speaker != null) {
            spec = spec.and(SessionSpecifications.speakerContains(speaker));
        }

        if(title != null) {
            spec = spec.and(SessionSpecifications.titleContains(title));
        }

        if(room != null) {
            spec = spec.and(SessionSpecifications.roomContains(room));
        }

        if(track != null) {
            spec = spec.and(SessionSpecifications.trackContains(track));
        }

        return sessionRepository.findAll(spec);
    }

   public Optional<Session> getSessionById(Long id) {
        return sessionRepository.findById(id);
   }

    public Session createSession(Session session) {
        return sessionRepository.save(session);
    }

    public void deleteSession(Long id) {
        sessionRepository.deleteById(id);
    }
}
