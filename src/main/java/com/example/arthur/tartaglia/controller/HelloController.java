package com.example.arthur.tartaglia.controller;

import com.example.arthur.tartaglia.repository.ClienteServiceImp;
import com.example.arthur.tartaglia.model.Cliente;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class HelloController {

    @Autowired
    private ClienteServiceImp clienteService;

    @GetMapping("/helloBuscar")
    public String buscar(@RequestParam(name = "fname") String nome) {


        boolean retorno = false;

        List<Cliente> clientesEncontrados = clienteService.getClienteByNome(nome);

        JSONObject clienteJson = null;

        if (!clientesEncontrados.isEmpty()) {
            clienteJson = new JSONObject(clientesEncontrados.get(0)); // Exemplo
        }

        return !clientesEncontrados.isEmpty() ? clienteJson.toString() : "null";
    }
}
