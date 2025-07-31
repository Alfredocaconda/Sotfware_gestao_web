package com.example.Software_Faturacao.Controller;

import java.util.List;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.Software_Faturacao.Model.Produto;
import com.example.Software_Faturacao.Service.Produto_Servico;

@RestController
@RequestMapping("/api/produtos")
public class Produto_Controller {
    private final Produto_Servico servico;
    public Produto_Controller(Produto_Servico servico){
        this.servico=servico;
    }
    @PostMapping
    public void salvar(@RequestBody Produto produtos){
        servico.salvar_produto(produtos);
    }
    @GetMapping
    public List<Produto> listar(){
        return servico.listar_todos();
    }
    @GetMapping("/pesquisar")
    public ResponseEntity<Produto> pesquisar(@RequestParam String nome){
        return servico.pesquisar(nome).map(ResponseEntity::ok)
        .orElse(ResponseEntity.notFound().build());
    }
    @PutMapping("/{id}")
    public ResponseEntity<Produto> actualizar(@PathVariable Long id, @RequestBody Produto produtos){
        return servico.buscar_id(id).map(
            ProdutoExistente->{
            ProdutoExistente.setNome(produtos.getNome());
            ProdutoExistente.setCategoria(produtos.getCategoria());
            ProdutoExistente.setDescricao(produtos.getDescricao());
            ProdutoExistente.setFuncionario(produtos.getFuncionario());
            Produto actualizado=servico.salvar_produto(ProdutoExistente);
            return ResponseEntity.ok(actualizado);
        }).orElse(ResponseEntity.notFound().build());
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> apagar(@PathVariable Long id){
        if(servico.buscar_id(id).isPresent()){
            servico.apagar(id);
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
