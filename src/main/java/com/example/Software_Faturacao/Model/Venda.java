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
public class Venda {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    private Produto produto;
    @ManyToOne
    private Funcionario funcionario;
    @ManyToOne
    private Stock stock;
    private Date data_venda;
    private Integer qtd_requerida;
    private String fatura;

    public String getFatura() {
        return fatura;
    }
    public void setFatura(String fatura) {
        this.fatura = fatura;
    }
    public Integer getQtd_requerida() {
        return qtd_requerida;
    }
    public void setQtd_requerida(Integer qtd_requerida) {
        this.qtd_requerida = qtd_requerida;
    }
    public Date getData_venda() {
        return data_venda;
    }
    public void setData_venda(Date data_venda) {
        this.data_venda = data_venda;
    }
    public Stock getStock() {
        return stock;
    }
    public void setStock(Stock stock) {
        this.stock = stock;
    }
    public Funcionario getFuncionario() {
        return funcionario;
    }
    public void setFuncionario(Funcionario funcionario) {
        this.funcionario = funcionario;
    }
    public Produto getProduto() {
        return produto;
    }
    public void setProduto(Produto produto) {
        this.produto = produto;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public Long getId() {
        return id;
    }

    
    
}
