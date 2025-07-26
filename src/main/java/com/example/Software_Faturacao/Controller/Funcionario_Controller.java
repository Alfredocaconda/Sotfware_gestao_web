package com.example.Software_Faturacao.Controller;

import java.util.List;
import java.util.Optional;

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

import com.example.Software_Faturacao.Model.Funcionario;
import com.example.Software_Faturacao.Service.Funcionario_Servico;

@RestController
@RequestMapping("/api/funcionario")
public class Funcionario_Controller {
    
    private final Funcionario_Servico servico;
    public Funcionario_Controller(Funcionario_Servico servico){
        this.servico=servico;
    }
    @PostMapping
    public void salvar(@RequestBody Funcionario modal){
        servico.salvar(modal);
    }
    @GetMapping
    public List<Funcionario> listar(){
        return servico.listar_todos();
    }
    @GetMapping("/pesquisar")
    public ResponseEntity<Funcionario> pesquisar(@RequestParam String nome){
        return servico.pesquisar(nome).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Funcionario> actualizar(@PathVariable Long id, @RequestBody Funcionario model){
        return servico.pesquisar_id(id).map(
            FuncionarioExistente->{
            FuncionarioExistente.setNome(model.getNome());
            FuncionarioExistente.setEmail(model.getEmail());
            FuncionarioExistente.setBilhete(model.getBilhete());
            FuncionarioExistente.setGenero(model.getGenero());
            FuncionarioExistente.setTelefone(model.getTelefone());
            FuncionarioExistente.setNascimento(model.getNascimento());
            FuncionarioExistente.setEndereco(model.getEndereco());
            Funcionario actualizado=servico.salvar(FuncionarioExistente);
            return ResponseEntity.ok(actualizado);
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id){
        if(servico.pesquisar_id(id).isPresent()){
            servico.apagar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
