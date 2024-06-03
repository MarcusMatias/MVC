package com.vendas.conversor.model;

import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import jakarta.annotation.PostConstruct;

@Repository
public class FuncionarioDAO {
    @Autowired DataSource dataSource;
	
	JdbcTemplate jdbc;
	
	@PostConstruct
	private void initialize() {
		jdbc = new JdbcTemplate(dataSource);
	}

    public String inserirFuncionario(Funcionario fun){
        try{
            String sql = "INSERT INTO funcionario(nome,senha) VALUES (?,?)";
            Object[] obj = new Object[2];
            obj[0] = fun.getNome();
            obj[1] = fun.getSenha();
            jdbc.update(sql, obj);
            return "cadastroRealizado";  
        } catch (DataIntegrityViolationException e) {
            return "cadastroInvalido";
        }
    }

    public List<Map<String, Object>> listarFuncionario() {
    	String sql = "SELECT * FROM funcionario";
    	return jdbc.queryForList(sql);
    }

    public List<Map<String,Object>> obterCliente(int id){
		String sql = "SELECT * FROM cliente WHERE id = ? ";
		Object[] obj = new Object[1];
		obj[0] = id;
		return jdbc.queryForList(sql, obj); 
	}

    public void atualizarCliente(int id, Funcionario fun){
		String sql = "UPDATE cliente SET senha = ? WHERE id = ?";
		Object[] obj = new Object[3];
		obj[0] = fun.getNome();
		obj[1] = fun.getSenha();
		obj[2] = id;
		jdbc.update(sql, obj);
	}


}
