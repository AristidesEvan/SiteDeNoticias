package com.noticiasonline.demo.controller;
import com.noticiasonline.demo.model.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noticiasonline.demo.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public List<Usuario> pegarTodosOsUsuarios() {
        return usuarioService.pegarTodosOsUsuarios();
    }

    @PostMapping("/")
    public Usuario salvarUsuario(@RequestBody Usuario usuario) {
        
        return usuarioService.salvarUsuario(usuario);
    }
    
    @PutMapping("/")
    public Usuario atualizarUsuario(@RequestBody Usuario usuario) {

        return usuarioService.atualizarUsuario(usuario);
    }

    @DeleteMapping("/{usuarioId}")
    public void deletarUsuario(@PathVariable Long usuarioId) {
        usuarioService.deletarUsuario(usuarioId);
    }

}
