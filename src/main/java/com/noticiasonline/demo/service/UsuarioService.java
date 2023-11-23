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

    // public void deleteUsuario(Long id) {
    //     usuarioData.deleteById(id);
    // }

    public void deleteUsuario(Long idUsuario) {
        Usuario usuario = usuarioData.findById(idUsuario).orElseThrow();

        // Remova as relações de seguimento
        for (Usuario seguindo : usuario.getSeguindo()) {
            seguindo.getSeguidores().remove(usuario);
        }

        // Remova as relações de seguidores
        for (Usuario seguidor : usuario.getSeguidores()) {
            seguidor.getSeguindo().remove(usuario);
        }

        // Exclua o usuário
        usuarioData.delete(usuario);
    }

    public String seguirUsuario(Long idSeguidor, Long idSeguindo) {
        Usuario seguidor = usuarioData.findById(idSeguidor).orElseThrow();
        Usuario seguindo = usuarioData.findById(idSeguindo).orElseThrow();

        if (!seguidor.getSeguindo().contains(seguindo)) {
            
            seguidor.getSeguindo().add(seguindo);
            seguindo.getSeguidores().add(seguidor);
    
            usuarioData.save(seguidor);
            usuarioData.save(seguindo);

            return "Usuario seguiu com sucesso!";

        }

        return "Usuario ja esta seguindo este usuario!";

    }

    public String deixarDeSeguirUsuario(Long idSeguidor, Long idSeguindo) {
        Usuario seguidor = usuarioData.findById(idSeguidor).orElseThrow();
        Usuario seguindo = usuarioData.findById(idSeguindo).orElseThrow();

        if (seguidor.getSeguindo().contains(seguindo)) {

            seguidor.getSeguindo().remove(seguindo);
            seguindo.getSeguidores().remove(seguidor);
    
            usuarioData.save(seguidor);
            usuarioData.save(seguindo);

            return "Usuario deixou de seguir com sucesso!";

        }

        return "Usuario ja nao segue este usuario!";

    }

}
