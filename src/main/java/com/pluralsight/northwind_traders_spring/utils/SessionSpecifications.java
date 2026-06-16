package com.pluralsight.northwind_traders_spring.utils;

import com.pluralsight.northwind_traders_spring.model.Session;
import org.springframework.data.jpa.domain.Specification;

public class SessionSpecifications {

    public static Specification<Session> speakerContains(String speaker) {
        return (table, query, criteria) ->
                criteria.like(criteria.lower(table.get(speaker)),
                        "%" + speaker.toLowerCase() + "%");
    }

    public static Specification<Session> titleContains(String title) {
        return (table, query, criteria) ->
                criteria.like(criteria.lower(table.get(title)),
                        "%" + title.toLowerCase() + "%");
    }

    public static Specification<Session> trackContains(String track) {
        return (table, query, criteria) ->
                criteria.like(criteria.lower(table.get(track)),
                        "%" + track.toLowerCase() + "%");
    }

    public static Specification<Session> roomContains(String room) {
        return (table, query, criteria) ->
                criteria.like(criteria.lower(table.get(room)),
                        "%" + room.toLowerCase() + "%");
    }
}
