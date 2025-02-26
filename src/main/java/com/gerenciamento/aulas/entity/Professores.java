package com.gerenciamento.aulas.entity;

import com.gerenciamento.aulas.entity.dto.professores.DadosAtualizarProfessores;
import com.gerenciamento.aulas.entity.dto.professores.DadosCadastroProfessores;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
    // @JoinColumn(name = "professores")
    // @JsonBackReference
    // private Alunos alunos;

    public Professores(DadosCadastroProfessores dadosCadastroAlunos) {
        this.nomeProfessores = dadosCadastroAlunos.nomeProfessores();
        this.email = dadosCadastroAlunos.email();
        this.telefone = dadosCadastroAlunos.telefone();
        this.especialidade = dadosCadastroAlunos.especialidade();
    }

    public Professores(Professores professores, DadosAtualizarProfessores dadosAtualizarProfessores) {
        this.idProfessores = professores.getIdProfessores();
        this.nomeProfessores = dadosAtualizarProfessores.nomeProfessores() != null
                ? dadosAtualizarProfessores.nomeProfessores()
                : professores.getNomeProfessores();
        this.email = dadosAtualizarProfessores.email() != null ? dadosAtualizarProfessores.email()
                : professores.getEmail();
        this.telefone = dadosAtualizarProfessores.telefone() != null ? dadosAtualizarProfessores.telefone()
                : professores.getTelefone();
        this.especialidade = dadosAtualizarProfessores.especialidade() != null
                ? dadosAtualizarProfessores.especialidade()
                : professores.getEspecialidade();
    }

}
