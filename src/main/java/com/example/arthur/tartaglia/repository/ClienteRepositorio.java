package com.example.arthur.tartaglia.repository;

import com.example.arthur.tartaglia.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String nome);
}
