package com.noticiasonline.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

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

    public Usuario pegarPeloEmail(String email) {
        return usuarioData.findByEmail(email);
    }

    public List<Usuario> pegarPeloNome(String nome) {
        return usuarioData.findByParteNome(nome);
    }

    public Usuario validarEmailESenha(String email, String senha) {
        return usuarioData.findByEmailAndSenha(email, senha);
    }

}
