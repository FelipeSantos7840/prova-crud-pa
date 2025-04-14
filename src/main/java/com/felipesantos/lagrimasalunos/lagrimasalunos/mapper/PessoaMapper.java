package com.felipesantos.lagrimasalunos.lagrimasalunos.mapper;

import com.felipesantos.lagrimasalunos.lagrimasalunos.dto.PessoaDTO;
import com.felipesantos.lagrimasalunos.lagrimasalunos.model.Pessoa;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface PessoaMapper {
    Pessoa toPessoa(PessoaDTO dto);
    PessoaDTO toPessoaDTO(Pessoa entity);
    List<Pessoa> toPessoaList(List<PessoaDTO> dtos);
    List<PessoaDTO> toPessoaDTOList(List<Pessoa> entites);
}
