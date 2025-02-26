package com.gerenciamento.aulas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento.aulas.entity.dto.professores.DadosAtualizarProfessores;
import com.gerenciamento.aulas.entity.dto.professores.DadosCadastroProfessores;
import com.gerenciamento.aulas.entity.dto.professores.DadosExibicaoProfessores;
import com.gerenciamento.aulas.service.ProfessorService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping(value = "/api/professor")
@AllArgsConstructor
public class ProfessorController {

    private ProfessorService service;

    @GetMapping("/todos-professores")
    public ResponseEntity<List<DadosExibicaoProfessores>> listarTodosProfesores() {
        List<DadosExibicaoProfessores> professores = service.listarTodosProfessores();
        return (professores != null) ? ResponseEntity.ok().body(professores) : ResponseEntity.notFound().build();
    }

    @PostMapping("/cadastro")
    public ResponseEntity<DadosExibicaoProfessores> cadastrarAlunos(
            @RequestBody DadosCadastroProfessores dadosCadastroProfessores) {
        DadosExibicaoProfessores professores = service.cadastroProfessor(dadosCadastroProfessores);
        return (professores != null) ? ResponseEntity.status(HttpStatus.CREATED).body(professores)
                : ResponseEntity.badRequest().build();
    }

    @PutMapping("/atualizar/{idProfessor}")
    public ResponseEntity<DadosExibicaoProfessores> atualizarCadastroAlunos(@PathVariable Long idProfessor,
            @RequestBody DadosAtualizarProfessores dadosAtualizaProfessores) {

        DadosExibicaoProfessores alunos = service.atualizarCadastroProfessor(idProfessor, dadosAtualizaProfessores);
        return (alunos != null) ? ResponseEntity.ok().body(alunos) : ResponseEntity.notFound().build();
    }

}
