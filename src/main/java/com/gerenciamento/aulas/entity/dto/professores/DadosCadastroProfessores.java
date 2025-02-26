package com.gerenciamento.aulas.entity.dto.professores;

import com.gerenciamento.aulas.entity.Professores;

public record DadosCadastroProfessores(String nomeProfessores,
        String email,
        String telefone,
        String especialidade) {
    public DadosCadastroProfessores(Professores professores) {
        this(
                professores.getNomeProfessores(),
                professores.getEmail(),
                professores.getTelefone(),
                professores.getEspecialidade());
    }
}
