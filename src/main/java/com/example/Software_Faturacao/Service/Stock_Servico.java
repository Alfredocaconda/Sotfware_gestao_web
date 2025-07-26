package com.example.Software_Faturacao.Service;

import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import com.example.Software_Faturacao.Model.Stock;
import com.example.Software_Faturacao.Repository.Stock_repository;

@Service
public class Stock_Servico {
    private final Stock_repository repositorio;

    public Stock_Servico(Stock_repository repositorio){
        this.repositorio=repositorio;
    }
    public Stock salvar(Stock stock){
       return repositorio.save(stock);
    }
    public List<Stock> pesquisar(){
        return repositorio.findAll();
    }
    public Optional<Stock> pesquisar_nomes(String nome){
        return repositorio.findByProduto_Nome(nome);
    }
    public Optional<Stock> pesquisar_id(Long id){
        return repositorio.findById(id);
    }
    public void deletar(Long id){
        repositorio.deleteById(id);
    }
}
