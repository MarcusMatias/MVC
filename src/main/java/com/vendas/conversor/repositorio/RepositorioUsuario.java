package com.vendas.conversor.repositorio;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import com.vendas.conversor.model.Usuario;

@Repository
public interface RepositorioUsuario extends CrudRepository<Usuario, Long> {
}
