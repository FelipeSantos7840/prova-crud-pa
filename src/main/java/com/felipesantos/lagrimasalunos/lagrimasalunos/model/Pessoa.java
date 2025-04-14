package com.felipesantos.lagrimasalunos.lagrimasalunos.model;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "pessoas_tb")
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;

    private Integer idade;

    private Double salario;


    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pessoa_id")
    private List<Trabalho> trabalhos;
    public Pessoa() {
    }

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

    public Integer getIdade() {
        return idade;
    }

    public void setIdade(Integer idade) {
        this.idade = idade;
    }

    public Double getSalario() {
        return salario;
    }

    public void setSalario(Double salario) {
        this.salario = salario;
    }

    public List<Trabalho> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(List<Trabalho> trabalhos) {
        this.trabalhos = trabalhos;
    }

    public void addTrabalhos(Trabalho trabalho){
        this.trabalhos.add(trabalho);
    }

    public void removeTrabalhos(Trabalho trabalho){
        this.trabalhos.remove(trabalho);
    }
}
