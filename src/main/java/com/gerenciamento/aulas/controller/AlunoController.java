package com.gerenciamento.aulas.controller;

import com.gerenciamento.aulas.entity.dto.alunos.AlunosRequestDto;
import com.gerenciamento.aulas.entity.dto.alunos.AlunosResponseDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gerenciamento.aulas.service.AlunoService;

import lombok.AllArgsConstructor;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping(value = "/api/aluno")
@AllArgsConstructor
public class AlunoController {

    private AlunoService alunoService;

    @PostMapping("/cadastro")
    public ResponseEntity<AlunosResponseDto> cadastrarAlunos(@RequestBody AlunosRequestDto resquestDto) {
        AlunosResponseDto alunosResponse = alunoService.cadastrarAlunos(resquestDto);
        return ResponseEntity.created(ServletUriComponentsBuilder.fromCurrentRequest()
                .path("/{idAlunos}")
                .buildAndExpand(alunosResponse.idAlunos)
                .toUri()).body(alunosResponse);
    }
//
//    @GetMapping("/todos-alunos")
//    public ResponseEntity<List<DadosExibicaoAlunos>> listarTodosOsAlunos() {
//        List<DadosExibicaoAlunos> alunos = alunoService.listarTodosOsAlunos();
//        return (alunos != null) ? ResponseEntity.ok().body(alunos) : ResponseEntity.notFound().build();
//    }
//
//    @PutMapping("/atualizar/{idAlunos}")
//    public ResponseEntity<DadosExibicaoAlunos> atualizarCadastroAlunos(@PathVariable Long idAlunos,
//            @RequestBody DadosAtualizaAluno dadosAtualizaAluno) {
//        DadosExibicaoAlunos alunos = alunoService.atualizarCadastroAlunos(idAlunos, dadosAtualizaAluno);
//        return (alunos != null) ? ResponseEntity.ok().body(alunos) : ResponseEntity.notFound().build();
//    }
//
//    @DeleteMapping("{idAlunos}")
//    public ResponseEntity<?> deletarCadastroAluno(@PathVariable Long idAlunos) {
//        alunoService.deletarCadastroDoAluno(idAlunos);
//        return ResponseEntity.noContent().build();
//    }

}
