package com.noticiasonline.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noticiasonline.demo.data.NoticiaData;
import com.noticiasonline.demo.model.Categoria;
import com.noticiasonline.demo.model.Noticia;

@Component
public class NoticiaService {
    
    @Autowired
    private NoticiaData noticiaData;

    public List<Noticia> pegarTodasAsNoticias() {
        return (List<Noticia>) noticiaData.findAll();
    }

    public Noticia salvarNoticia(Noticia noticia) {
        return noticiaData.save(noticia);
    }

    public Noticia atualizarNoticia(Noticia noticia) {
        return noticiaData.save(noticia);
    }

    public void deletarNoticia(Long noticiaId) {
        noticiaData.deleteById(noticiaId);
    }

    public List<Noticia> pegaPorTitulo(String nome) {
        return noticiaData.findByParteTitulo(nome);
    }

        public List<Noticia> pegaPorCategoria(String nome) {
        return noticiaData.findByParteCategoria(nome);
    }

        public List<Noticia> pegaPorConteudo(String nome) {
        return noticiaData.findByParteConteudo(nome);
    }

    public List<Noticia> pegarNoticiasPorCategoria(Categoria categoria) {
        return (List<Noticia>) noticiaData.findByCategoria(categoria);
    }

}
