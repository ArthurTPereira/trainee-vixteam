package com.example.arthur.tartaglia;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloWorldRest {
    @GetMapping("/helloBuscar")
    public String buscar(@RequestParam(name = "fname") String nome) {

        //IMPLEMENTAR AJAX PARA NAO TROCAR DE PAGINA AO CLICAR EM SUBMIT
        //Tabela de clientes
        String[] bancoClientes = {"Jose", "RodolFo", "LUIZ"};

        for (String cliente : bancoClientes) {
            if (cliente.equalsIgnoreCase(nome)) {
                return "Ok";
            }
        }
        return "Não";
    }
}
