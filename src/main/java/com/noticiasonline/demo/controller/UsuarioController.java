package com.noticiasonline.demo.controller;
import com.noticiasonline.demo.model.Usuario;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public List<Usuario> getAllUsuarios() {
        return usuarioService.getAllUsuarios();
    }

    @PostMapping("/")
    public Usuario insertUsuario(@RequestBody Usuario usuario) {
        
        return usuarioService.insertUsuario(usuario);
    }
    
    @PutMapping("/")
    public Usuario updateUsuario(@RequestBody Usuario usuario) {

        return usuarioService.updateUsuario(usuario);
    }

    @DeleteMapping("/{id}")
    public void deleteUsuario(@PathVariable Long id) {
        usuarioService.deleteUsuario(id);
    }

    @PostMapping("/{idSeguidor}/seguir/{idSeguindo}")
    public ResponseEntity<String> seguirUsuario(@PathVariable Long idSeguidor, @PathVariable Long idSeguindo) {
        String response = usuarioService.seguirUsuario(idSeguidor, idSeguindo);
        return ResponseEntity.ok(response);
    }

    @PostMapping("/{idSeguidor}/deixarDeSeguir/{idSeguindo}")
    public ResponseEntity<String> deixarDeSeguirUsuario(@PathVariable Long idSeguidor, @PathVariable Long idSeguindo) {
        String response = usuarioService.deixarDeSeguirUsuario(idSeguidor, idSeguindo);
        return ResponseEntity.ok(response);
    }

}
