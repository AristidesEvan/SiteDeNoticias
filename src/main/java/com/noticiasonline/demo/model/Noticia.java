package com.noticiasonline.demo.model;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Noticia {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String titulo;

    @Column(nullable = false, length = 2000)
    private String conteudo;

    @Column(nullable = false)
    private LocalDate dataDePublicacao;

    @ManyToOne
    @JoinColumn(name = "usuario_id", nullable = false)
    private Usuario autor;

    @ManyToOne
    @JoinColumn(name = "categoria_id", nullable = false)
    private Categoria categoria;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getTitulo() { return titulo; }

    public void setTitulo(String titulo) { this.titulo = titulo; }

    public String getConteudo() { return conteudo; }

    public void setConteudo(String conteudo) { this.conteudo = conteudo; }

    public LocalDate getDataDePublicacao() { return dataDePublicacao; }

    public void setDataDePublicacao(LocalDate dataDePublicacao) { this.dataDePublicacao = dataDePublicacao; }

    public Usuario getAutor() { return autor; }

    public void setAutor(Usuario autor) { this.autor = autor; }

    public Categoria getCategoria() { return categoria; }

    public void setCategoria(Categoria categoria) { this.categoria = categoria; }
    
}
