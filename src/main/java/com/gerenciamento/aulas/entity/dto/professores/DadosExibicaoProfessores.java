package com.gerenciamento.aulas.entity.dto.professores;

import com.gerenciamento.aulas.entity.Professores;

public record DadosExibicaoProfessores(Long idProfessores,
                                       String nomeProfessores,
                                       String email,
                                       String telefone,
                                       String especialidade) {
    public DadosExibicaoProfessores(Professores professores){
        this(professores.getIdProfessores(),
                professores.getNomeProfessores(),
                professores.getEmail(),
                professores.getTelefone(),
                professores.getEspecialidade()
        );
    }
}
