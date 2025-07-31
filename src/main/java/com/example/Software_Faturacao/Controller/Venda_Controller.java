package com.example.Software_Faturacao.Controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Software_Faturacao.Model.Venda;
import com.example.Software_Faturacao.Service.Venda_Service;

@RestController
@RequestMapping("/api/venda")

public class Venda_Controller {
    private final Venda_Service servico;

    public Venda_Controller(Venda_Service servico){
        this.servico=servico;
    }

    @PostMapping
    public void guardar(@RequestBody Venda model){
        servico.salvar(model);
    }
}
