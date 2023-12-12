package com.noticiasonline.demo.controller;
import com.noticiasonline.demo.model.Noticia;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noticiasonline.demo.service.NoticiaService;

@RestController
@CrossOrigin("*")
@RequestMapping("/noticias")
public class NoticiaController {
    
    @Autowired
    private NoticiaService noticiaService;

    @GetMapping("/")
    public List<Noticia> pegarTodasAsNoticias() {
        return noticiaService.pegarTodasAsNoticias();
    }

    @PostMapping("/")
    public Noticia salvarNoticia(@RequestBody Noticia noticia) {
        noticia.setDataDePublicacao(LocalDate.now());
        return noticiaService.salvarNoticia(noticia);
    }

    @PutMapping("/")
    public Noticia atualizarNoticia(@RequestBody Noticia noticia) {
        return noticiaService.atualizarNoticia(noticia);
    }

    @DeleteMapping("/{noticiaId}")
    public void deletarNoticia(@PathVariable Long noticiaId) {
        noticiaService.deletarNoticia(noticiaId);
    }

}
