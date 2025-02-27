package com.gerenciamento.aulas.service;


import com.gerenciamento.aulas.entity.Alunos;
import com.gerenciamento.aulas.entity.dto.alunos.AlunosRequestDto;
import com.gerenciamento.aulas.entity.dto.alunos.AlunosResponseDto;
import com.gerenciamento.aulas.mapper.AlunoMapper;
import jakarta.transaction.Transactional;
import org.springframework.stereotype.Service;

import com.gerenciamento.aulas.repository.AlunoRepository;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlunoService {

    private AlunoRepository repository;

//    @Transactional
//    public List<DadosExibicaoAlunos> listarTodosOsAlunos() {
//        List<Alunos> todosAlunos = repository.findAll();
//        return todosAlunos.stream().map(DadosExibicaoAlunos::new).toList();
//    }
//
    @Transactional
    public AlunosResponseDto cadastrarAlunos(AlunosRequestDto alunosRequestDto) {
        Alunos novoAluno = AlunoMapper.INSTANCE.convertDtoToAlunos(alunosRequestDto);
        repository.save(novoAluno);
        return AlunoMapper.INSTANCE.converteEntityToDto(novoAluno);
    }
//
//    @Transactional
//    public DadosExibicaoAlunos atualizarCadastroAlunos(Long idAlunos, DadosAtualizaAluno dadosAtualizaAluno) {
//        try {
//            Optional<Alunos> alunoEncontrado = repository.findById(idAlunos);
//            if (alunoEncontrado.isEmpty()) {
//                throw new SolicitacaoNaoEncontrada("Aluno não encontrado");
//            }
//
//            Alunos alunoAtualizado = new Alunos(alunoEncontrado.get(), dadosAtualizaAluno);
//            repository.save(alunoAtualizado);
//            return new DadosExibicaoAlunos(alunoAtualizado);
//        } catch (DataIntegrityViolationException e) {
//            throw new IllegalArgumentException("Email já cadastrado");
//        }
//    }
//
//    public void deletarCadastroDoAluno(Long idAlunos) {
//        Optional<Alunos> alunoEncontrado = repository.findById(idAlunos);
//        if (alunoEncontrado.isEmpty()) {
//            throw new SolicitacaoNaoEncontrada("Aluno não encontrado");
//        }
//        repository.deleteById(idAlunos);
//    }

}
