package com.gerenciamento.aulas.repository;


import com.gerenciamento.aulas.entity.Alunos;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AlunoRepository extends JpaRepository<Alunos, Long> {
    boolean existsByEmail(String email);

}
