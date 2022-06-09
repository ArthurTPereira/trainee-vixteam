package com.example.arthur.tartaglia.service;

import com.example.arthur.tartaglia.model.Cliente;
import com.example.arthur.tartaglia.repository.ClienteRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ClienteServiceImp implements ClienteService {

    @Autowired
    private ClienteRepositorio clienteRepositorio;

    @Override
    public List<Cliente> getAllCliente() {
        return clienteRepositorio.findAll();
    }

    @Override
    public List<Cliente> getClienteByNome(String nome) {
        return clienteRepositorio.findByNome(nome);
    }

    @Override
    public List<Cliente> getClienteByEmail(String email) {
        return clienteRepositorio.findByEmail(email);
    }

    @Override
    public void cadastraCliente(Cliente cliente) {
        clienteRepositorio.save(cliente);
    }

    @Override
    public void removeCliente(String nome) {
        clienteRepositorio.delete(clienteRepositorio.findByNome(nome).get(0));
    }

    @Override
    public String alteraEmailCliente(String mail, String nome) {
        return  (clienteRepositorio.updateEmailByNome(mail,nome)+" resultado alterado.");
    }

}
