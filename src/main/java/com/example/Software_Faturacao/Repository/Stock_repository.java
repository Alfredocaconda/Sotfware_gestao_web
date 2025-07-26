package com.example.Software_Faturacao.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

import com.example.Software_Faturacao.Model.Stock;

public interface Stock_repository extends JpaRepository<Stock, Long> {
    Optional<Stock> findByProduto_Nome(String nome);
}
