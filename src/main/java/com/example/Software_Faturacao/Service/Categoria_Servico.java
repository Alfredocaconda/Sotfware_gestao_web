package com.example.Software_Faturacao.Service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.example.Software_Faturacao.Model.Categoria;
import com.example.Software_Faturacao.Repository.Categoria_Repository;

@Service
public class Categoria_Servico {

    private final Categoria_Repository repositorio;

    public Categoria_Servico(Categoria_Repository repositorio){
        this.repositorio=repositorio;
    }
    public Categoria Salvar(Categoria model){
     return repositorio.save(model);
    }
    public List<Categoria> listar(){
        return repositorio.findAll();
    }
    public Optional<Categoria> pequisar_nome(String nome){
        return repositorio.findByNome(nome);
    }
    public Optional<Categoria> listar_id(Long id){
        return repositorio.findById(id);
    }
    public void apagar(Long id){
        repositorio.deleteById(id);
    }
}
