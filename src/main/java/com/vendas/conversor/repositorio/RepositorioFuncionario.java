package com.vendas.conversor.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.vendas.conversor.model.Funcionario;

@Repository
public interface RepositorioFuncionario extends CrudRepository<Funcionario, Long> {
}
