package com.noticiasonline.demo.controller;
import com.noticiasonline.demo.model.Usuario;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin("*")
@RequestMapping("/usuarios")
public class UsuarioController {
    
    @Autowired
    private UsuarioService usuarioService;

    @GetMapping("/")
    public List<Usuario> pegarTodosOsUsuarios() {
        return usuarioService.pegarTodosOsUsuarios();
    }

    @PostMapping("/cadastro")
    public ResponseEntity<Usuario> cadastarUsuario(@RequestBody Usuario usuario) {
        if (usuarioService.pegarPeloEmail(usuario.getEmail()) == null) {
            usuario.setDataDeRegistro(LocalDate.now());
            Usuario usuarioSalvo = usuarioService.salvarUsuario(usuario);
            return ResponseEntity.ok(usuarioSalvo);
        } else {
            usuario.setEmail("null");
            usuario.setNome("null");
            usuario.setDataDeRegistro(null);
            return ResponseEntity.ok(usuario);
        }
    }
    
    @PostMapping("/validar")
    public ResponseEntity<Usuario> validarEmailESenha(@RequestBody Usuario usuario) {
        Usuario usuarioValidado = usuarioService.validarEmailESenha(usuario.getEmail(), usuario.getSenha());
        if (usuarioValidado != null) {
            return ResponseEntity.ok(usuarioValidado);
        } else {
            return ResponseEntity.status(401).body(null);
        }
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
