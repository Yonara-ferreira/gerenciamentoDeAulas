package com.gerenciamento.aulas.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Professores {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idProfessores;
    private String nomeProfessores;
    private String email;
    private String telefone;
    private String especialidade;
    @OneToOne(cascade = CascadeType.PERSIST)
    private Alunos aluno;


}
