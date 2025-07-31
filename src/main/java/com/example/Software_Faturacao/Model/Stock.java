package com.example.Software_Faturacao.Model;

import java.sql.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table
public class Stock {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Produto produto;
    //relacionando a tabela funcionario com a tabela stock
    @ManyToOne
    private Funcionario funcionario;
    private int quantidade;
    private Date caducidade;
    private Date data_entrada;
    
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public int getQuantidade() {
        return quantidade;
    }
    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }
    public void setData_entrada(Date data_entrada) {
        this.data_entrada = data_entrada;
    }
    public Date getData_entrada() {
        return data_entrada;
    }
    public Date getCaducidade() {
        return caducidade;
    }
    public void setCaducidade(Date caducidade) {
        this.caducidade = caducidade;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    
    
}
