package com.gerenciamento.aulas.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento.aulas.entity.dto.alunos.DadosAtualizaAluno;
import com.gerenciamento.aulas.entity.dto.alunos.DadosCadastroAlunos;
import com.gerenciamento.aulas.entity.dto.alunos.DadosExibicaoAlunos;
import com.gerenciamento.aulas.service.AlunoService;

import lombok.AllArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/aluno")
@AllArgsConstructor
public class AlunoController {

    private AlunoService alunoService;

    @PostMapping("/cadastro")
    public ResponseEntity<DadosExibicaoAlunos> cadastrarAlunos(@RequestBody DadosCadastroAlunos dadosCadastroAlunos) {
        DadosExibicaoAlunos alunosResponse = alunoService.cadastrarAlunos(dadosCadastroAlunos);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idAlunos}")
                .buildAndExpand(alunosResponse.idAlunos())
                .toUri()).body(alunosResponse);
    }

    @GetMapping("/todos-alunos")
    public ResponseEntity<List<DadosExibicaoAlunos>> listarTodosOsAlunos() {
        List<DadosExibicaoAlunos> alunos = alunoService.listarTodosOsAlunos();
        return (alunos != null) ? ResponseEntity.ok().body(alunos) : ResponseEntity.notFound().build();
    }

    @PutMapping("/atualizar/{idAlunos}")
    public ResponseEntity<DadosExibicaoAlunos> atualizarCadastroAlunos(@PathVariable Long idAlunos,
            @RequestBody DadosAtualizaAluno dadosAtualizaAluno) {
        DadosExibicaoAlunos alunos = alunoService.atualizarCadastroAlunos(idAlunos, dadosAtualizaAluno);
        return (alunos != null) ? ResponseEntity.ok().body(alunos) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("{idAlunos}")
    public ResponseEntity<?> deletarCadastroAluno(@PathVariable Long idAlunos) {
        alunoService.deletarCadastroDoAluno(idAlunos);
        return ResponseEntity.noContent().build();
    }

}
