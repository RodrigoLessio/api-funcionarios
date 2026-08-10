package com.rodrigolessio.api_funcionarios.service;

import com.rodrigolessio.api_funcionarios.model.Funcionario;
import com.rodrigolessio.api_funcionarios.repository.FuncionarioRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public FuncionarioService(FuncionarioRepository funcionarioRepository) {
        this.funcionarioRepository = funcionarioRepository;
    }

    public List<Funcionario> listarFuncionarios() {
        return funcionarioRepository.findAll();
    }

    public Funcionario salvarFuncionario(Funcionario funcionario) {
        return funcionarioRepository.save(funcionario);
    }

    public Optional<Funcionario> buscarFuncionario(Long id) {
        return funcionarioRepository.findById(id);
    }

    public void removerFuncionario(Long id) {
        funcionarioRepository.deleteById(id);
    }

    public Funcionario atualizarFuncionario(Long id, Funcionario funcionario) {

        Funcionario funcionarioExistente = buscarFuncionario(id).orElse(null);
        if (funcionarioExistente == null) {
            return null;
        }

        funcionarioExistente.setNome(funcionario.getNome());
        funcionarioExistente.setCargo(funcionario.getCargo());
        funcionarioExistente.setSalario(funcionario.getSalario());

        return funcionarioRepository.save(funcionarioExistente);
    }
}
