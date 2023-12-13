package com.noticiasonline.demo.controller;
import com.noticiasonline.demo.model.Categoria;
import com.noticiasonline.demo.model.Noticia;

import java.time.LocalDate;
import java.util.List;
import java.util.ArrayList;

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

import com.noticiasonline.demo.service.CategoriaService;
import com.noticiasonline.demo.service.NoticiaService;


@RestController
@CrossOrigin("*")
@RequestMapping("/noticias")
public class NoticiaController {
    
    @Autowired
    private NoticiaService noticiaService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/")
    public List<Noticia> pegarTodasAsNoticias() {
        return noticiaService.pegarTodasAsNoticias();
    }

    @GetMapping("/{categoriaNome}")
    public List<Noticia> pegarPorNomeCategoria(@PathVariable String categoriaNome) {
        List<Categoria> listaCategoria = categoriaService.pegarPorCategoria(categoriaNome);
        Categoria categoria = listaCategoria.get(0);

        return noticiaService.pegarNoticiasPorCategoria(categoria);
    }
    
    @GetMapping("/porTitulo/{noticiaNome}")
    public List<Noticia> pegarPorTitulo(@PathVariable String noticiaNome) {
        List<Noticia> listaNoticia = noticiaService.pegaPorTitulo(noticiaNome);
        if (listaNoticia.size() > 0) {
            List<Noticia> noticias = listaNoticia;
            return noticias;
        } else {
            return null;
        }
    }

    @GetMapping("/porCategoria/{noticiaNome}")
    public List<Noticia> pegarPorCategoria(@PathVariable String noticiaNome) {
        List<Categoria> listaCategoria = categoriaService.pegaPorNome(noticiaNome);

        List<Noticia> listaNoticia = new ArrayList<>();
        List<Noticia> aux;

        for (Categoria categoria : listaCategoria) {
            aux = noticiaService.pegarNoticiasPorCategoria(categoria);

            for (Noticia noticia : aux) {
                listaNoticia.add(noticia);
            }

        }

        if (listaNoticia.size() > 0) {
            List<Noticia> noticias = listaNoticia;
            return noticias;
        } else {
            return null;
        }
    }

    @GetMapping("/porConteudo/{noticiaNome}")
    public List<Noticia> pegarPorConteudo(@PathVariable String noticiaNome) {
        List<Noticia> listaNoticia = noticiaService.pegaPorConteudo(noticiaNome);
        if (listaNoticia.size() > 0) {
            List<Noticia> noticias = listaNoticia;
            return noticias;
        } else {
            return null;
        }
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
