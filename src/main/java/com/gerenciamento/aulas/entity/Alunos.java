package com.gerenciamento.aulas.entity;

import java.time.LocalDate;

import com.gerenciamento.aulas.entity.dto.alunos.DadosAtualizaAluno;
import com.gerenciamento.aulas.entity.dto.alunos.DadosCadastroAlunos;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Alunos {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idAlunos;
    public String nomeAlunos;
    // @Column(nullable = false, unique = true)
    public String email;
    public String telefone;
    public String escola;
    public String serie;
    public LocalDate dataCadastro;

    public Alunos(DadosCadastroAlunos alunos) {
        this.nomeAlunos = alunos.nomeAlunos();
        this.email = alunos.email();
        this.telefone = alunos.telefone();
        this.escola = alunos.escola();
        this.serie = alunos.serie();
        this.dataCadastro = LocalDate.now();
    }

    public Alunos(Alunos alunos, DadosAtualizaAluno dadosAtualizaAluno) {
        this.idAlunos = alunos.getIdAlunos();
        this.nomeAlunos = dadosAtualizaAluno.nomeAlunos() != null ? dadosAtualizaAluno.nomeAlunos()
                : alunos.getNomeAlunos();
        this.email = dadosAtualizaAluno.email() != null ? dadosAtualizaAluno.email() : alunos.getEmail();
        this.telefone = dadosAtualizaAluno.telefone() != null ? dadosAtualizaAluno.telefone() : alunos.getTelefone();
        this.escola = dadosAtualizaAluno.escola() != null ? dadosAtualizaAluno.escola() : alunos.getEscola();
        this.serie = dadosAtualizaAluno.serie() != null ? dadosAtualizaAluno.serie() : alunos.getSerie();
    }

}
