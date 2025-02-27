package com.gerenciamento.aulas.mapper;


import com.gerenciamento.aulas.entity.Alunos;
import com.gerenciamento.aulas.entity.dto.alunos.AlunosRequestDto;
import com.gerenciamento.aulas.entity.dto.alunos.AlunosResponseDto;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface AlunoMapper {

    // Implementar os métodos de mapeamento de Aluno para AlunoDTO

        AlunoMapper INSTANCE = Mappers.getMapper(AlunoMapper.class);

        Alunos convertDtoToAlunos(AlunosRequestDto alunosRequestDto);

        AlunosResponseDto converteEntityToDto(Alunos alunos);


}
