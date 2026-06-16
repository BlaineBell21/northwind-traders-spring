package com.pluralsight.northwind_traders_spring.repositories;

import com.pluralsight.northwind_traders_spring.model.Session;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SessionRepository extends
        JpaRepository<Session, Long>,
        JpaSpecificationExecutor<Session> {
}
