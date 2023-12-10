package com.noticiasonline.demo.model;

import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Categoria {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String categoria;

    @OneToMany(mappedBy = "categoria", cascade = CascadeType.ALL)
    private List<Noticia> noticias;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getCategoria() { return categoria; }

    public void setCategoria(String categoria) { this.categoria = categoria; }

    public List<Noticia> getNoticias() { return noticias; }

    public void setNoticias(List<Noticia> noticias) { this.noticias = noticias; }

    
}
