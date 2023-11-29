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

    public List<Usuario> getAllUsuarios() {
        return (List<Usuario>) usuarioData.findAll();
    }

    public Usuario insertUsuario(Usuario usuario) {
        return usuarioData.save(usuario);
    }

    public Usuario updateUsuario(Usuario usuario) {
        return usuarioData.save(usuario);
    }

}
