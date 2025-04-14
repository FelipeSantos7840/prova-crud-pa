package com.felipesantos.lagrimasalunos.lagrimasalunos.controller;

import com.felipesantos.lagrimasalunos.lagrimasalunos.dto.TrabalhoDTO;
import com.felipesantos.lagrimasalunos.lagrimasalunos.service.TrabalhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping("trabalho")
public class TrabalhoController {
    @Autowired
    private TrabalhoService trabalhoService;

    @GetMapping()
    public ResponseEntity<List<TrabalhoDTO>> findAll(){
        return ResponseEntity.ok(trabalhoService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrabalhoDTO> findById(@PathVariable Long id){
        return ResponseEntity.ok(trabalhoService.findById(id));
    }

    @PostMapping
    public ResponseEntity<TrabalhoDTO> create(@RequestBody TrabalhoDTO dto){
        URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(dto.getId()).toUri();
        return ResponseEntity.created(uri).body(trabalhoService.create(dto));
    }

    @PutMapping("/{id}")
    public ResponseEntity<TrabalhoDTO> update(@PathVariable Long id, @RequestBody TrabalhoDTO dto){
        return ResponseEntity.ok(trabalhoService.update(id,dto));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<TrabalhoDTO> delete(@PathVariable Long id){
        trabalhoService.delete(id);
        return ResponseEntity.noContent().build();
    }
}
