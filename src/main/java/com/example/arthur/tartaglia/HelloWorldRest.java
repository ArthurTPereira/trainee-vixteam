package com.example.arthur.tartaglia;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class HelloWorldRest {
    @GetMapping("/helloBuscar")
    public String buscar(@RequestParam(name = "fname") String nome) {

        //Simulando uma busca dos dados de um cliente em um banco de dados
        List<Cliente> clientes = new ArrayList<>();
        clientes.add(new Cliente("Jose"));
        clientes.add(new Cliente("RodolFo"));
        clientes.add(new Cliente("LUIZ"));

        boolean retorno = false;
        for (Cliente c : clientes) {
            if (c.getNome().equalsIgnoreCase(nome)) {
                retorno = true;
                break;
            }
        }

        return retorno? "Cliente encontrado!" : "Cliente NÃO encontrado!";
    }
}
