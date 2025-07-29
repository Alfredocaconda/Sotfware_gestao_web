package com.example.Software_Faturacao.Controller;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Software_Faturacao.Model.Categoria;
import com.example.Software_Faturacao.Service.Categoria_Servico;

@RestController
@RequestMapping("/api/categoria")
public class Categoria_Controller {
    private final Categoria_Servico servico;
    public Categoria_Controller(Categoria_Servico servico){
        this.servico=servico;
    }
    @PostMapping
    public void salvar(@RequestBody Categoria model){
        servico.Salvar(model);
    }
    @GetMapping
    public List<Categoria> listar_todos(){
        return servico.listar();
    }
    @GetMapping("/pesquisar")
    public ResponseEntity<Categoria> pesquisar_nome(@RequestParam String nome){
        return servico.pequisar_nome(nome).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id){
        if(servico.listar_id(id).isPresent()){
            servico.apagar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Categoria> actualizar(@PathVariable Long id,@RequestBody Categoria model){
        return servico.listar_id(id).map(Categoria_Existente->{
            Categoria_Existente.setNome(model.getNome());
            Categoria_Existente.setId_funcionario(model.getId_funcionario());
            Categoria actualizado=servico.Salvar(Categoria_Existente);
            return ResponseEntity.ok(actualizado);
        }).orElse(ResponseEntity.notFound().build());
    }
    
}
