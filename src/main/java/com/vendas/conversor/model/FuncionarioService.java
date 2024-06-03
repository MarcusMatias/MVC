package com.vendas.conversor.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class FuncionarioService {
    
    @Autowired FuncionarioDAO fdao;

    public String inserirFuncionario(Funcionario fun){
       return fdao.inserirFuncionario(fun);
    }

    public List<Map<String, Object>> listarFuncionario(){
        return fdao.listarFuncionario();
    }

    public void atualizarCliente(int id, Funcionario fun){
		fdao.atualizarCliente(id, fun);
	}

    public List<Map<String, Object>> obterCliente(int id){
		return fdao.obterCliente(id);
	}

}