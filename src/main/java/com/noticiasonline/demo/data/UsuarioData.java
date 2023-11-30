package com.noticiasonline.demo.data;

import org.springframework.data.repository.CrudRepository;

import com.noticiasonline.demo.model.Usuario;

public interface UsuarioData extends CrudRepository<Usuario, Long> {
    Usuario findByEmailAndSenha(String email, String senha);
}

