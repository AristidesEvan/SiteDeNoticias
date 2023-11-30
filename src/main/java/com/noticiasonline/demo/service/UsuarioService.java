package com.noticiasonline.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import com.noticiasonline.demo.data.UsuarioData;
import com.noticiasonline.demo.model.Usuario;

@Component
public class UsuarioService {

    @Autowired
    private UsuarioData usuarioData;

    public List<Usuario> pegarTodosOsUsuarios() {
        return (List<Usuario>) usuarioData.findAll();
    }

    public Usuario salvarUsuario(Usuario usuario) {
        return usuarioData.save(usuario);
    }

    public Usuario atualizarUsuario(Usuario usuario) {
        return usuarioData.save(usuario);
    }

    public void deletarUsuario(Long usuarioId) {
        usuarioData.deleteById(usuarioId);
    }

    // public Usuario validarEmailESenha(String email, String senha) {
    // return usuarioData.findByEmailAndSenha(email, senha);
    // }

    // @PostMapping("/validar")
    // public ResponseEntity<Usuario> validarEmailESenha(@RequestBody Usuario usuario) {
    //     Usuario usuarioValidado = usuarioService.validarEmailESenha(usuario.getEmail(), usuario.getSenha());
    //     if (usuarioValidado != null) {
    //         return ResponseEntity.ok(usuarioValidado);
    //     } else {
    //         return ResponseEntity.status(401).body(null);
    //     }
    // }

}
