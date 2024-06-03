package com.vendas.conversor.model;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UsuarioService {
    
    @Autowired UsuarioDAO fdao;

    public String inserirUsuario(Usuario user){
       return fdao.inserirUsuario(user);
    }

    public List<Map<String, Object>> listarUsuario(){
        return fdao.listarUsuario();
    }

    public void atualizarUsuario(int id, Usuario user){
		    fdao.atualizarUsuario(id, user);
	}

    public List<Map<String, Object>> obterUsuario(int id){
		    return fdao.obterUsuario(id);
	}

    public String autenticarUsuario(Usuario user){
            return fdao.autenticarUsuario(user);
    }

}