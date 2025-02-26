package com.gerenciamento.aulas.entity;

import java.time.LocalDateTime;

import com.gerenciamento.aulas.entity.enums.StatusAula;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Aulas {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAula;

    @ManyToOne
    @JoinColumn(name = "idAluno", nullable = false)
    private Alunos aluno;

    @ManyToOne
    @JoinColumn(name = "idProfessor", nullable = false)
    private Professores professor;

    @ManyToOne
    @JoinColumn(name = "idMateria", nullable = false)
    private Materias materia;

    private LocalDateTime data;

    private LocalDateTime horaInicio;

    private LocalDateTime horaFim;

    private String observacoes;

    private String conteudos;

    @Enumerated(EnumType.STRING)
    private StatusAula statusAula;

    private Boolean alunoPresente;

    private LocalDateTime dataCadastro;

    private LocalDateTime dataAlteracao;

}
