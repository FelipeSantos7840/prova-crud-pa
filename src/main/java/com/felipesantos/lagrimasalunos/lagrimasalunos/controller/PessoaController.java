package com.felipesantos.lagrimasalunos.lagrimasalunos.controller;

import com.felipesantos.lagrimasalunos.lagrimasalunos.dto.PessoaDTO;
import com.felipesantos.lagrimasalunos.lagrimasalunos.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.function.EntityResponse;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("/pessoa")
public class PessoaController {
    @Autowired
    private PessoaService pessoaService;

    @GetMapping()
    public ResponseEntity<List<PessoaDTO>> findAll(){
        return ResponseEntity.ok(pessoaService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<PessoaDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(pessoaService.findById(id));
    }

    @PostMapping()
    public ResponseEntity<PessoaDTO> create(@RequestBody PessoaDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();

        return ResponseEntity.created(uri).body(pessoaService.create(dto));
    }

    @PostMapping("/{idp}/trabalho/{idt}")
    public ResponseEntity<PessoaDTO> addTrabalho(@PathVariable Long idp, @PathVariable Long idt){
        return ResponseEntity.ok(pessoaService.addTrabalho(idp,idt));
    }

    @PutMapping("/{id}")
    public ResponseEntity<PessoaDTO> update(@PathVariable Long id, @RequestBody PessoaDTO dto){
        return ResponseEntity.ok(pessoaService.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<PessoaDTO> delete(@PathVariable Long id){
        pessoaService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
