package com.example.arthur.tartaglia.controller;

import com.example.arthur.tartaglia.repository.ClienteServiceImp;
import com.example.arthur.tartaglia.model.Cliente;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

@RestController
public class HelloController {

    @Autowired
    private ClienteServiceImp clienteService;

    @GetMapping("/helloBuscar")
    public String buscar(@RequestParam(name = "fname") String nome) {

        if (Objects.equals(nome,"")) {
            return "Preencha todos os campos.";
        }

        JSONObject clienteJson = null;

        if (clienteService.getClienteByNome(nome).size() > 1 || clienteService.getClienteByEmail(nome).size() > 1) {
            return "Mais de um cliente encontrado. Faça uma busca diferente.";
        }

        List<Cliente> clientesEncontrados = clienteService.getClienteByNome(nome);
        if (clientesEncontrados.isEmpty()) {
            clientesEncontrados = clienteService.getClienteByEmail(nome);
            if (!clientesEncontrados.isEmpty()) {
                clienteJson = new JSONObject(clientesEncontrados.get(0));
            }
        } else {
            clienteJson = new JSONObject(clientesEncontrados.get(0));
        }

        return !clientesEncontrados.isEmpty() ? clienteJson.toString() : "null";
    }

    @GetMapping("/helloCadastrar")
    public String cadastrar(@RequestParam String fname,
                            @RequestParam String fmail) {
        if (Objects.equals(fname, "") || Objects.equals(fmail,"")) {
            return "Preencha todos os campos.";
        }

        Cliente clienteCadastro = new Cliente(fname,fmail);

        if (clienteService.getClienteByNome(clienteCadastro.getNome()).size() >= 1) {
            return "Nome já cadastrado.";
        } else if (clienteService.getClienteByEmail(clienteCadastro.getEmail()).size() >= 1) {
            return "E-mail já cadastrado.";
        }
        clienteService.cadastraCliente(clienteCadastro);
        return "Cliente cadastrado com sucesso!";
    }
}
