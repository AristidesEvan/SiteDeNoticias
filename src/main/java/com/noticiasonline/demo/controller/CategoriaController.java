package com.noticiasonline.demo.controller;
import com.noticiasonline.demo.model.Categoria;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.noticiasonline.demo.service.CategoriaService;

@RestController
@RequestMapping("/categorias")
public class CategoriaController {
    
    private CategoriaService categoriaService;

    @GetMapping("/")
    public List<Categoria> pegarTodasAsCategorias() {
        return categoriaService.pegarTodasAsCategorias();
    }

    @PostMapping("/")
    public Categoria salvarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.salvarCategoria(categoria);
    }

    @PutMapping("/")
    public Categoria atualizarCategoria(@RequestBody Categoria categoria) {
        return categoriaService.atualizarCategoria(categoria);
    }

    @DeleteMapping("/{categoriaId}")
    public void deletarCategoria(@PathVariable Long categoriaId) {
        categoriaService.deletarCategoria(categoriaId);
    }

}
