package com.example.Software_Faturacao.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;
import com.example.Software_Faturacao.Model.Produto;
import com.example.Software_Faturacao.Repository.Produto_Repository;

@Service
public class Produto_Servico {
    private final Produto_Repository repositorio;

    public Produto_Servico(Produto_Repository repositorio){
        this.repositorio=repositorio;
    }
    public Produto salvar_produto(Produto produtos){
      return repositorio.save(produtos);
    }
    public List<Produto> listar_todos(){
        return repositorio.findAll();
    }
    public Optional<Produto> pesquisar(String nome){
        return repositorio.findByNome(nome);
    }
    public Optional<Produto> buscar_id(Long id){
        return repositorio.findById(id);
    }
    public void apagar(Long id){
        repositorio.deleteById(id);
    }
}
