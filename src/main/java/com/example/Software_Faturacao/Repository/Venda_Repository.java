package com.example.Software_Faturacao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.Software_Faturacao.Model.Venda;

public interface Venda_Repository extends JpaRepository<Venda ,Long> {
    
}
