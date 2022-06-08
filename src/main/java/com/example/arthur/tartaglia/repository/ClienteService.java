package com.example.arthur.tartaglia.repository;

import com.example.arthur.tartaglia.model.Cliente;

import java.util.List;

public interface ClienteService {
    List<Cliente> getAllCliente();
    List<Cliente> getClienteByNome(String nome);
    List<Cliente> getClienteByEmail(String email);
    void cadastraCliente(Cliente cliente);
}
