package com.felipesantos.lagrimasalunos.lagrimasalunos.dto;

import java.io.Serializable;
import java.util.List;

public class PessoaDTO implements Serializable {

    private Long id;

    private String nome;

    private Integer idade;

    private Double salario;

    private List<TrabalhoDTO> trabalhos;

    public PessoaDTO() {
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

    public List<TrabalhoDTO> getTrabalhos() {
        return trabalhos;
    }

    public void setTrabalhos(List<TrabalhoDTO> trabalhos) {
        this.trabalhos = trabalhos;
    }
}
