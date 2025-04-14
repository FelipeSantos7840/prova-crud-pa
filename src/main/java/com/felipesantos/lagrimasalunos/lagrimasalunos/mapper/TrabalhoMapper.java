package com.felipesantos.lagrimasalunos.lagrimasalunos.mapper;

import com.felipesantos.lagrimasalunos.lagrimasalunos.dto.TrabalhoDTO;
import com.felipesantos.lagrimasalunos.lagrimasalunos.model.Trabalho;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface TrabalhoMapper {
    Trabalho toTrabalho(TrabalhoDTO dto);
    TrabalhoDTO toTrabalhoDTO(Trabalho entity);
    List<Trabalho> toTrabalhoList(List<TrabalhoDTO> dtos);
    List<TrabalhoDTO> toTrabalhoDTOList(List<Trabalho> entites);
}
