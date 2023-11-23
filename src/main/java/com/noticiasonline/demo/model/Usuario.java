package com.noticiasonline.demo.model;

import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;

@Entity
public class Usuario {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @JsonIgnoreProperties({"seguindo", "seguidores"})
    @ManyToMany
    @JoinTable(
        name = "seguidores_seguindo",
        joinColumns = @JoinColumn(name = "seguido_id"),
        inverseJoinColumns = @JoinColumn(name = "seguidor_id")
    )
    private List<Usuario> seguidores; // Lista de quem segue este usuário

    @JsonIgnoreProperties({"seguidores", "seguindo"})
    @ManyToMany(mappedBy = "seguidores")
    private List<Usuario> seguindo; // Lista de quem este usuário segue

    // Construtores, getters e setters

    public Long getId() { return id; }

    public void setId(Long id) { this.id = id; }

    public String getNome() { return nome; }

    public void setNome(String nome) { this.nome = nome; }

    public List<Usuario> getSeguidores() { return seguidores; }

    public void setSeguidores(List<Usuario> seguidores) { this.seguidores = seguidores; }

    public List<Usuario> getSeguindo() { return seguindo; }

    public void setSeguindo(List<Usuario> seguindo) { this.seguindo = seguindo; }

}
