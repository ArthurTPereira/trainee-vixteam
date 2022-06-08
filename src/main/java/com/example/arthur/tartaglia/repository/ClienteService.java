package com.example.arthur.tartaglia.repository;

import com.example.arthur.tartaglia.model.Cliente;
import org.springframework.http.ResponseEntity;

import java.util.List;

public interface ClienteService {
    List<Cliente> getAllCliente();
    List<Cliente> getClienteByNome(String nome);
    List<Cliente> getClienteByEmail(String email);
    void cadastraCliente(Cliente cliente);
    void removeCliente(String nome);
    String alteraEmailCliente(String mail, String nome);
}
