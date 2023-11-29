package com.noticiasonline.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noticiasonline.demo.data.NoticiaData;
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

}
