package com.example.Software_Faturacao.Service;

import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

import com.example.Software_Faturacao.Model.Funcionario;
import com.example.Software_Faturacao.Repository.Funcionario_Repository;

@Service
public class Funcionario_Servico {
    private final Funcionario_Repository funcionario_repositorio;

    public Funcionario_Servico(Funcionario_Repository funcionario_repositorio){
        this.funcionario_repositorio = funcionario_repositorio;
    }
    
    public Funcionario salvar(Funcionario modal ){
        return funcionario_repositorio.save(modal);
    }
    public List<Funcionario> listar_todos(){
        return funcionario_repositorio.findAll();
    }
    public Optional<Funcionario> pesquisar(String nome){
        return funcionario_repositorio.findByNome(nome);
    }
    public Optional<Funcionario> pesquisar_id(Long id){
        return funcionario_repositorio.findById(id);
    }
    public void apagar(Long id){
        funcionario_repositorio.deleteById(id);
    }
 
}
