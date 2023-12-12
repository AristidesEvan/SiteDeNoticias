package com.noticiasonline.demo.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.noticiasonline.demo.data.CategoriaData;
import com.noticiasonline.demo.model.Categoria;

@Component
public class CategoriaService {
    
    @Autowired
    private CategoriaData categoriaData;

    public List<Categoria> pegarTodasAsCategorias() {
        return (List<Categoria>) categoriaData.findAll();
    }

    public Categoria salvarCategoria(Categoria categoria) {
        return categoriaData.save(categoria);
    }

    public Categoria atualizarCategoria(Categoria categoria) {
        return categoriaData.save(categoria);
    }

    public void deletarCategoria(Long categoriaId) {
        categoriaData.deleteById(categoriaId);
    }

}
