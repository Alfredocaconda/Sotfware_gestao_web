package com.example.Software_Faturacao.Service;

import java.util.List;
import java.util.Optional;

import com.example.Software_Faturacao.Model.Venda;
import com.example.Software_Faturacao.Repository.Venda_Repository;

public class Venda_Service {
    private final Venda_Repository repositorio;

    public Venda_Service(Venda_Repository repositorio){
        this.repositorio=repositorio;
    }

    public Venda salvar(Venda model){
        return repositorio.save(model);
    }
    public List<Venda> listar_todos(){
        return repositorio.findAll();
    }
    public Optional<Venda> listar_Id(Long id){
        return repositorio.findById(id);
    }
    public void Apagar(Long id){
        repositorio.deleteById(id);
    }
}
