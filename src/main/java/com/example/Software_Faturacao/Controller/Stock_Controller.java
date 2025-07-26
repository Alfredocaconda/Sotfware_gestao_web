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

import com.example.Software_Faturacao.Model.Stock;
import com.example.Software_Faturacao.Service.Stock_Servico;

@RestController
@RequestMapping("/api/stock")
public class Stock_Controller {
    private final Stock_Servico servico;
    public Stock_Controller(Stock_Servico servico){
        this. servico=servico;
    }
    @PostMapping
    public void salvar(@RequestBody Stock model){
        servico.salvar(model);
    }
    @GetMapping
    public List<Stock> listar_todos(){
        return servico.pesquisar();
    }
    @PutMapping("/{id}")
    public ResponseEntity<Stock> actualizar(@PathVariable Long id, @RequestBody Stock model){
        return servico.pesquisar_id(id).map(
                Stock_Existente->{
                Stock_Existente.setId_funcionario(model.getId_funcionario());
                Stock_Existente.setId_produto(model.getId_produto());
                Stock_Existente.setCaducidade(model.getCaducidade());
                Stock_Existente.setData_entrada(model.getData_entrada());
                Stock_Existente.setQuantidade(model.getQuantidade());
                Stock actualizado=servico.salvar(Stock_Existente);
                return ResponseEntity.ok(actualizado);
            }
        ).orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/pesquisar")
    public ResponseEntity<Stock> pesquisar_nome(String nome){
        return servico.pesquisar_nomes(nome).map(ResponseEntity::ok).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(Long id){
        if(servico.pesquisar_id(id).isPresent()){
            servico.deletar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
    
}
