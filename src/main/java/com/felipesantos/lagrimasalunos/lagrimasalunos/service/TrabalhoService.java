package com.felipesantos.lagrimasalunos.lagrimasalunos.service;

import com.felipesantos.lagrimasalunos.lagrimasalunos.dto.TrabalhoDTO;
import com.felipesantos.lagrimasalunos.lagrimasalunos.mapper.TrabalhoMapper;
import com.felipesantos.lagrimasalunos.lagrimasalunos.model.Pessoa;
import com.felipesantos.lagrimasalunos.lagrimasalunos.model.Trabalho;
import com.felipesantos.lagrimasalunos.lagrimasalunos.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class TrabalhoService {
    @Autowired
    private TrabalhoRepository trabalhoRepository;

    @Autowired
    private TrabalhoMapper trabalhoMapper;

    public List<TrabalhoDTO> findAll(){
        return trabalhoMapper.toTrabalhoDTOList(trabalhoRepository.findAll());
    }

    public TrabalhoDTO findById(Long id){
        return trabalhoMapper.toTrabalhoDTO(trabalhoRepository.findById(id).orElseThrow(InvalidParameterException::new));
    }

    public TrabalhoDTO create(TrabalhoDTO dto){
        Trabalho entity = trabalhoMapper.toTrabalho(dto);
        return trabalhoMapper.toTrabalhoDTO(trabalhoRepository.save(entity));
    }

    public TrabalhoDTO update(Long id,TrabalhoDTO dto){
        Trabalho entity = trabalhoRepository.findById(id).orElseThrow(InvalidParameterException::new);

        entity.setRazaoSocial(dto.getRazaoSocial());
        entity.setNomeFantasia(dto.getNomeFantasia());
        entity.setCnpj(dto.getCnpj());

        return trabalhoMapper.toTrabalhoDTO(trabalhoRepository.save(entity));
    }

    public void delete(Long id){
        trabalhoRepository.deleteById(findById(id).getId());
    }
}
