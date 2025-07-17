package com.example.Software_Faturacao.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Software_Faturacao.Model.Produto;

public interface Produto_Repository extends JpaRepository<Produto, Long> {
    
    Optional<Produto> findByNome(String nome);
}
