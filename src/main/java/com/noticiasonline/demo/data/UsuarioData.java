package com.noticiasonline.demo.data;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.noticiasonline.demo.model.Usuario;

public interface UsuarioData extends CrudRepository<Usuario, Long> {
    Usuario findByEmailAndSenha(String email, String senha);

    Usuario findByEmail(String email);
    
    
    @Query("SELECT u FROM Usuario u WHERE LOWER(u.nome) LIKE LOWER(CONCAT('%', :parteNome, '%'))")
    List<Usuario> findByParteNome(String parteNome);
}

