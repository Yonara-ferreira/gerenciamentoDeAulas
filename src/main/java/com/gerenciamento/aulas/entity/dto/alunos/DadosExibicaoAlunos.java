package com.gerenciamento.aulas.entity.dto.alunos;

import java.time.LocalDate;

import com.gerenciamento.aulas.entity.Alunos;

public record DadosExibicaoAlunos(Long idAlunos,
        String nomeAlunos,
        String email,
        String telefone,
        String escola,
        String serie,
        LocalDate dataCadastro) {
    public DadosExibicaoAlunos(Alunos alunos) {
        this(alunos.getIdAlunos(),
                alunos.getNomeAlunos(),
                alunos.getEmail(),
                alunos.getTelefone(),
                alunos.getEscola(),
                alunos.getSerie(),
                alunos.getDataCadastro());
    }


}
