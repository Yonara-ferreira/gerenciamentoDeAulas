package com.gerenciamento.aulas.service;

import java.util.List;
import java.util.Optional;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.gerenciamento.aulas.entity.Professores;
import com.gerenciamento.aulas.entity.dto.professores.DadosAtualizarProfessores;
import com.gerenciamento.aulas.entity.dto.professores.DadosCadastroProfessores;
import com.gerenciamento.aulas.entity.dto.professores.DadosExibicaoProfessores;
import com.gerenciamento.aulas.exception.SolicitacaoNaoEncontrada;
import com.gerenciamento.aulas.repository.ProfessorRepository;

import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class ProfessorService {

    private ProfessorRepository repository;

    @Transactional
    public List<DadosExibicaoProfessores> listarTodosProfessores() {
        List<Professores> professores = repository.findAll();
        return professores.stream().map(DadosExibicaoProfessores::new).toList();
    }

    @Transactional
    public DadosExibicaoProfessores cadastroProfessor(DadosCadastroProfessores dadosCadastroProfessores) {
        Professores professores = new Professores(dadosCadastroProfessores);
        repository.save(professores);
        return new DadosExibicaoProfessores(professores);

    }

    @Transactional
    public DadosExibicaoProfessores atualizarCadastroProfessor(Long idProfessor,
            DadosAtualizarProfessores dadosAtualizarProfessores) {
        try {
            Optional<Professores> professorEncontrado = repository.findById(idProfessor);
            if (professorEncontrado.isEmpty()) {
                throw new SolicitacaoNaoEncontrada("Professor(a) não encontrado(a)");
            }

            Professores cadastroProfAtualizado = new Professores(professorEncontrado.get(), dadosAtualizarProfessores);
            repository.save(cadastroProfAtualizado);
            return new DadosExibicaoProfessores(cadastroProfAtualizado);
        } catch (DataIntegrityViolationException e) {
            throw new IllegalArgumentException("Email já cadastrado");
        }
    }

}
