package com.gerenciamento.aulas.entity.dto.alunos;

import com.gerenciamento.aulas.entity.Alunos;

import java.time.LocalDate;

public record DadosCadastroAlunos( String nomeAlunos,
                                   String email,
                                   String telefone,
                                   String escola,
                                   String serie,
                                   LocalDate dataCadastro) {
    public DadosCadastroAlunos(Alunos alunos){
        this(
                alunos.getNomeAlunos(),
                alunos.getEmail(),
                alunos.getTelefone(),
                alunos.getEscola(),
                alunos.getSerie(),
                alunos.getDataCadastro()
        );
    }
}
