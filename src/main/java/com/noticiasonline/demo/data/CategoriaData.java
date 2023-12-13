package com.noticiasonline.demo.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.noticiasonline.demo.model.Categoria;
import java.util.List;


public interface CategoriaData extends CrudRepository<Categoria, Long>{

    @Query("SELECT c FROM Categoria c WHERE LOWER(c.categoria) LIKE LOWER(CONCAT('%', :parteCategoria, '%'))")
    List<Categoria> findByParteCategoria(String parteCategoria);
    

    List<Categoria> findByCategoria(String categoria);
}
