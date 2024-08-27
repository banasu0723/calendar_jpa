package com.sparta.calendar_jpa.repository;

import com.sparta.calendar_jpa.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EventRepository extends JpaRepository<Events, Long> {}
