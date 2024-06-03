package com.vendas.conversor.controller;

import java.util.List;
import java.util.Map;

import com.vendas.conversor.service.ConversaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.vendas.conversor.model.Usuario;
import com.vendas.conversor.model.UsuarioService;

@Controller
@ComponentScan("com.vendas.conversor.controller")
public class IndexController {
    
    @Autowired private ApplicationContext context;
    @Autowired private ConversaoService conversaoService;

    @GetMapping("/")
    public String index(){
        return "index";
    }


    @GetMapping("/cadastrar")
    public String cadastrar(Model model){
        model.addAttribute("usuario", new Usuario());
        return "cadastro";
    }

    @PostMapping("/cadastrar")
    public String cadastrar(Model model, @ModelAttribute Usuario user) {
    UsuarioService us = context.getBean(UsuarioService.class);
    String resultado = us.inserirUsuario(user);
        if ("cadastroInvalido".equals(resultado)) {
            model.addAttribute("error", "Usuario já existe");
            return "cadastroInvalido"; 
            } else{
            return "cadastroRealizado";
            }
        }

    @GetMapping("/listar")
    public String listar(Model model){
        UsuarioService us = context.getBean(UsuarioService.class);
        List<Map<String,Object>> lista = us.listarUsuario();
        model.addAttribute("lista", lista);
        return "lista";
    }

    @PostMapping("/converter")
    public String converterMoeda(
        @RequestParam double valor,
        @RequestParam String moedaOrigem,
        @RequestParam String moedaDestino,
        Model model
        ) {
        double resultado = conversaoService.converter(valor, moedaOrigem, moedaDestino);
        model.addAttribute("resultado", resultado);
        return "index";
    }

        @GetMapping("/atualizar/{id}")
    public String atualizar(@PathVariable ("id") int id, Model model){
        UsuarioService us = context.getBean(UsuarioService.class);
        Map<String,Object> usuario = us.obterUsuario(id).get(0);
        String nome = (String) usuario.get("nome");
        String senha = (String) usuario.get("senha");
        model.addAttribute("nome", nome);
        model.addAttribute("senha", senha);
        model.addAttribute("usuario", new Usuario(nome, senha));
        return "atualizar";
    }

    @PostMapping("/atualizar/{id}")
    public String atualizar(@PathVariable ("id") int id, Model model, @ModelAttribute Usuario user){
        UsuarioService us = context.getBean(UsuarioService.class);
        us.atualizarUsuario(id, user);
        return "redirect:/listar";
    }

    @GetMapping("/entrar")
    public String mostrarLogin(Model model) {
        model.addAttribute("login");
        return "entrar";
    }

    @PostMapping("/login")
    public String processarLogin(@RequestParam String nome, @RequestParam String senha, Model model) {
        UsuarioService us = context.getBean(UsuarioService.class);
        Usuario objUser = new Usuario();
		objUser.setNome(nome);
		objUser.setSenha(senha);
        String usuarioEncontrado = us.autenticarUsuario(objUser);
        if (usuarioEncontrado == objUser.getNome() && usuarioEncontrado == objUser.getSenha()) {
            model.addAttribute("usuarioEncontrado", usuarioEncontrado);
            return "index";
        } else {
            model.addAttribute("error", "Nome ou senha incorretos");
            return "loginIncorreto";
        }
    }
}