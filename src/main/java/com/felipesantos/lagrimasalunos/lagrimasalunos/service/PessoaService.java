package com.felipesantos.lagrimasalunos.lagrimasalunos.service;

import com.felipesantos.lagrimasalunos.lagrimasalunos.dto.PessoaDTO;
import com.felipesantos.lagrimasalunos.lagrimasalunos.mapper.PessoaMapper;
import com.felipesantos.lagrimasalunos.lagrimasalunos.mapper.TrabalhoMapper;
import com.felipesantos.lagrimasalunos.lagrimasalunos.model.Pessoa;
import com.felipesantos.lagrimasalunos.lagrimasalunos.model.Trabalho;
import com.felipesantos.lagrimasalunos.lagrimasalunos.repository.PessoaRepository;
import com.felipesantos.lagrimasalunos.lagrimasalunos.repository.TrabalhoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.security.InvalidParameterException;
import java.util.List;

@Service
public class PessoaService{

    @Autowired
    private PessoaRepository pessoaRepository;
    @Autowired
    private PessoaMapper pessoaMapper;
    @Autowired
    private TrabalhoMapper trabalhoMapper;
    @Autowired
    private TrabalhoRepository trabalhoRepository;

    public List<PessoaDTO> findAll(){
        return pessoaMapper.toPessoaDTOList(pessoaRepository.findAll());
    }

    public PessoaDTO findById(Long id){
        Pessoa entity = pessoaRepository.findById(id).orElseThrow(InvalidParameterException::new);
        PessoaDTO dto = pessoaMapper.toPessoaDTO(entity);
        dto.setTrabalhos(trabalhoMapper.toTrabalhoDTOList(entity.getTrabalhos()));
        return dto;
    }

    public PessoaDTO create(PessoaDTO dto){
        Pessoa entity = pessoaMapper.toPessoa(dto);
        return  pessoaMapper.toPessoaDTO(pessoaRepository.save(entity));
    }

    public PessoaDTO update(Long id, PessoaDTO dto){
        Pessoa entity = pessoaRepository.findById(id).orElseThrow(InvalidParameterException::new);
        entity.setNome(dto.getNome());
        entity.setIdade(dto.getIdade());
        entity.setSalario(dto.getSalario());

        return pessoaMapper.toPessoaDTO(pessoaRepository.save(entity));
    }

    public PessoaDTO addTrabalho(Long idp, Long idt){
        Trabalho entityT = trabalhoRepository.findById(idt).orElseThrow(InvalidParameterException::new);
        Pessoa entityP = pessoaRepository.findById(idp).orElseThrow(InvalidParameterException::new);

        entityP.addTrabalhos(entityT);
        pessoaRepository.save(entityP);
        return findById(entityP.getId());
    }

    public void delete(Long id){
        pessoaRepository.deleteById(findById(id).getId());
    }

}
