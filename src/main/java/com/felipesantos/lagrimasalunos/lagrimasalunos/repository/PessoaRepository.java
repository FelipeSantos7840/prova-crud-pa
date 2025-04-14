package com.felipesantos.lagrimasalunos.lagrimasalunos.repository;

import com.felipesantos.lagrimasalunos.lagrimasalunos.model.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
}
