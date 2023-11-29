package com.noticiasonline.demo.data;

import org.springframework.data.repository.CrudRepository;

import com.noticiasonline.demo.model.Categoria;

public interface CategoriaData extends CrudRepository<Categoria, Long>{

}
