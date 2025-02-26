package com.gerenciamento.aulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamento.aulas.entity.Professores;

@Repository
public interface ProfessorRepository extends JpaRepository<Professores, Long> {

}
