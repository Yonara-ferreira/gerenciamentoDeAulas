package com.gerenciamento.aulas.entity;

import java.time.LocalDateTime;

import com.gerenciamento.aulas.entity.enums.StatusAgendamento;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.PrePersist;
import jakarta.persistence.PreUpdate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Agendamento {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idAgendamento;

    private Alunos alunos;

    private Professores professores;

    private Materias materias;

    @Enumerated(EnumType.STRING)
    private StatusAgendamento statusAgendamento;

    @Column(nullable = false)
    private LocalDateTime data;

    @Column(nullable = false)
    private LocalDateTime horaInicio;

    @Column(nullable = false)
    private LocalDateTime horaFim;
    @Column
    private String observacoes;

    @Column(nullable = false, updatable = false)
    private LocalDateTime dataCadastro;

    @Column
    private LocalDateTime dataAlteracao;

    @PrePersist
    public void PrePersist() {
        this.dataCadastro = LocalDateTime.now();
    }

    @PreUpdate
    public void PreUpdate() {
        this.dataAlteracao = LocalDateTime.now();
    }

}
