package com.example.Software_Faturacao.Model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Categoria {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id;
    private String nome;
    @ManyToOne
    private Funcionario id_funcionario;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    public Funcionario getId_funcionario() {
        return id_funcionario;
    }
    public void setId_funcionario(Funcionario id_funcionario) {
        this.id_funcionario = id_funcionario;
    }
    
}
