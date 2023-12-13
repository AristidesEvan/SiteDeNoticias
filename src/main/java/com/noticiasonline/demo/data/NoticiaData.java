package com.noticiasonline.demo.data;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import com.noticiasonline.demo.model.Categoria;
import com.noticiasonline.demo.model.Noticia;
import java.util.List;


public interface NoticiaData extends CrudRepository<Noticia, Long>{

    @Query("SELECT n FROM Noticia n WHERE LOWER(n.titulo) LIKE LOWER(CONCAT('%', :parteTitulo, '%'))")
    List<Noticia> findByParteTitulo(String parteTitulo);

    @Query("SELECT n FROM Noticia n WHERE LOWER(n.categoria) LIKE LOWER(CONCAT('%', :parteCategoria, '%'))")
    List<Noticia> findByParteCategoria(String parteCategoria);

    @Query("SELECT n FROM Noticia n WHERE LOWER(n.conteudo) LIKE LOWER(CONCAT('%', :parteConteudo, '%'))")
    List<Noticia> findByParteConteudo(String parteConteudo);

    List<Noticia> findByCategoria(Categoria categoria);

}
