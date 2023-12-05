package com.example.demo.entities;

import javax.persistence.*;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.OneToMany;

import java.util.List;

@Entity
public class Curriculum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    @OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL)
    private List<ExperienciaProfissional> experienciasProfissionais;

    @OneToMany(mappedBy = "curriculum", cascade = CascadeType.ALL)
    private List<FormacaoAcademica> formacoesAcademicas;

    // Getters e setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<ExperienciaProfissional> getExperienciasProfissionais() {
        return experienciasProfissionais;
    }

    public void setExperienciasProfissionais(List<ExperienciaProfissional> experienciasProfissionais) {
        this.experienciasProfissionais = experienciasProfissionais;
    }

    public List<FormacaoAcademica> getFormacoesAcademicas() {
        return formacoesAcademicas;
    }

    public void setFormacoesAcademicas(List<FormacaoAcademica> formacoesAcademicas) {
        this.formacoesAcademicas = formacoesAcademicas;
    }

}

