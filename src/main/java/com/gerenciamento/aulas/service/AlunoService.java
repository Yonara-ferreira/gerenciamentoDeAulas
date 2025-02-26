package com.gerenciamento.aulas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gerenciamento.aulas.entity.Alunos;
import com.gerenciamento.aulas.entity.dto.alunos.DadosAtualizaAluno;
import com.gerenciamento.aulas.entity.dto.alunos.DadosCadastroAlunos;
import com.gerenciamento.aulas.entity.dto.alunos.DadosExibicaoAlunos;
import com.gerenciamento.aulas.exception.SolicitacaoNaoEncontrada;
import com.gerenciamento.aulas.repository.AlunoRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class AlunoService {

    private AlunoRepository repository;

    @Transactional
    public List<DadosExibicaoAlunos> listarTodosOsAlunos() {
        List<Alunos> todosAlunos = repository.findAll();
        return todosAlunos.stream().map(DadosExibicaoAlunos::new).toList();
    }

    @Transactional
    public DadosExibicaoAlunos cadastrarAlunos(DadosCadastroAlunos dadosCadastroAlunos) {
        Alunos novoAluno = new Alunos(dadosCadastroAlunos);
        repository.save(novoAluno);
        return new DadosExibicaoAlunos(novoAluno);
    }

    @Transactional
    public DadosExibicaoAlunos atualizarCadastroAlunos(Long idAlunos, DadosAtualizaAluno dadosAtualizaAluno) {
        try {
            Optional<Alunos> alunoEncontrado = repository.findById(idAlunos);
            if (alunoEncontrado.isEmpty()) {
                throw new SolicitacaoNaoEncontrada("Aluno não encontrado");
            }

            Alunos alunoAtualizado = new Alunos(alunoEncontrado.get(), dadosAtualizaAluno);
            repository.save(alunoAtualizado);
            return new DadosExibicaoAlunos(alunoAtualizado);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
    }

    public void deletarCadastroDoAluno(Long idAlunos) {
        Optional<Alunos> alunoEncontrado = repository.findById(idAlunos);
        if (alunoEncontrado.isEmpty()) {
            throw new SolicitacaoNaoEncontrada("Aluno não encontrado");
        }
        repository.deleteById(idAlunos);
    }

}
