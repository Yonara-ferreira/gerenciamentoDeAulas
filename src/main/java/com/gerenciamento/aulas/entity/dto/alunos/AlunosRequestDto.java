package com.gerenciamento.aulas.entity.dto.alunos;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class AlunosRequestDto {

    public String nomeAlunos;

    public String email;

    public String telefone;

    public String escola;

    public String serie;

    public LocalDate dataCadastro;

}
