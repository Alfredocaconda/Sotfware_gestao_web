package com.example.Software_Faturacao.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Software_Faturacao.Model.Categoria;

public interface Categoria_Repository extends JpaRepository<Categoria, Long> {
    Optional<Categoria> findByNome(String nome);
    
}
