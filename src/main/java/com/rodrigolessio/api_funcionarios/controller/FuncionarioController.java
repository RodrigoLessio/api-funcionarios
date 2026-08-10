package com.rodrigolessio.api_funcionarios.controller;

import com.rodrigolessio.api_funcionarios.model.Funcionario;
import com.rodrigolessio.api_funcionarios.service.FuncionarioService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class FuncionarioController {
    private final FuncionarioService funcionarioService;

    @GetMapping("/funcionarios")
    public List<Funcionario> listarFuncionarios() {
        return funcionarioService.listarFuncionarios();
    }

    public FuncionarioController(FuncionarioService funcionarioService) {
        this.funcionarioService = funcionarioService;
    }

    @PostMapping("/funcionarios")
    public ResponseEntity<Funcionario> cadastrarFuncionarios(@RequestBody Funcionario funcionario) {
        Funcionario funcionarioSalvo = funcionarioService.salvarFuncionario(funcionario);

        return ResponseEntity.status(HttpStatus.CREATED).body(funcionarioSalvo);
    }

    @GetMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> buscarFuncionario(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.buscarFuncionario(id);

        if (funcionario.isPresent()) {
            return ResponseEntity.ok(funcionario.get());
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/funcionarios/{id}")
    public ResponseEntity<Void> removerFuncionario(@PathVariable Long id) {
        Optional<Funcionario> funcionario = funcionarioService.buscarFuncionario(id);

        if (funcionario.isPresent()) {
            funcionarioService.removerFuncionario(id);
            return ResponseEntity.noContent().build();
        }

        return ResponseEntity.notFound().build();
    }

    @PutMapping("/funcionarios/{id}")
    public ResponseEntity<Funcionario> autalizarFuncionario(
            @PathVariable Long id,
            @RequestBody Funcionario funcionario) {
        Funcionario funcionarioAtualizado = funcionarioService.atualizarFuncionario(id, funcionario);

        if (funcionarioAtualizado == null) {
            return ResponseEntity.notFound().build();
        }

        return ResponseEntity.ok(funcionarioAtualizado);
    }
}
