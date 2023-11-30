package com.noticiasonline.demo.model;

import java.time.LocalDate;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 100)
    private String email;

    @Column(nullable = false, length = 255)
    private String senha;

    @Column(nullable = false)
    private LocalDate dataDeRegistro;

    @Column(nullable = false)
    private String tipo;

    @OneToMany(mappedBy = "autor", cascade = CascadeType.ALL) // Muitas notícias podem pertencer a um usuário
    private List<Noticia> noticias;

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public String getEmail() { return email; }

    public void setEmail(String email) { this.email = email; }

    public String getSenha() { return senha; }

    public void setSenha(String senha) { this.senha = senha; }

    public LocalDate getDataDeRegistro() { return dataDeRegistro; }

    public void setDataDeRegistro(LocalDate dataDeRegistro) { this.dataDeRegistro = dataDeRegistro; }

    public String getTipo() { return tipo; }

    public void setTipo(String tipo) { this.tipo = tipo; }

    public List<Noticia> getNoticias() { return noticias; }

    public void setNoticias(List<Noticia> noticias) { this.noticias = noticias; }

    

}
