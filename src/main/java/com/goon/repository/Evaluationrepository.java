package com.goon.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.goon.domain.Evaluation;

public interface Evaluationrepository extends JpaRepository<Evaluation, Long> {

}
