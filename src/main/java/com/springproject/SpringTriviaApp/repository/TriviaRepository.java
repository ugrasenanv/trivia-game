package com.springproject.SpringTriviaApp.repository;
import com.springproject.SpringTriviaApp.entity.Trivia;

import org.springframework.data.jpa.repository.JpaRepository;

public interface TriviaRepository extends JpaRepository<Trivia, Long> {
}
