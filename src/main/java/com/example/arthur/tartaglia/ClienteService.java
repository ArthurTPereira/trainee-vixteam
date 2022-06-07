package com.example.arthur.tartaglia;

import java.util.List;

public interface ClienteService {
    List<Cliente> getAllCliente();
    List<Cliente> getClienteByNome(String nome);
}
