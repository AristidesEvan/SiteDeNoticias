package com.noticiasonline.demo.data;

import org.springframework.data.repository.CrudRepository;

import com.noticiasonline.demo.model.Noticia;

public interface NoticiaData extends CrudRepository<Noticia, Long>{

}
