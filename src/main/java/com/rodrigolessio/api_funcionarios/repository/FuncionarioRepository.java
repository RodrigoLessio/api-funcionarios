package com.rodrigolessio.api_funcionarios.repository;

import com.rodrigolessio.api_funcionarios.model.Funcionario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FuncionarioRepository extends JpaRepository<Funcionario, Long> {

}
