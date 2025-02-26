package com.gerenciamento.aulas.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.gerenciamento.aulas.entity.Alunos;

@Repository
public interface AlunoRepository extends JpaRepository<Alunos, Long> {
    boolean existsByEmail(String email);

}
