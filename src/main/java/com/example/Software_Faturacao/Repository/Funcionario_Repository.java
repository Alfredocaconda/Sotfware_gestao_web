package com.example.Software_Faturacao.Repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Software_Faturacao.Model.Funcionario;

public interface Funcionario_Repository extends JpaRepository<Funcionario,Long> {
    Optional<Funcionario> findByNome(String nome);
    Optional<Funcionario> findByEmail(String email);    
}
