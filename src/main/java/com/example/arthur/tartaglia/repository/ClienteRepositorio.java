package com.example.arthur.tartaglia.repository;

import com.example.arthur.tartaglia.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import javax.transaction.Transactional;
import java.util.List;

public interface ClienteRepositorio extends JpaRepository<Cliente, Long> {
    List<Cliente> findByNome(String nome);
    List<Cliente> findByEmail(String email);

    @Transactional
    @Modifying
    @Query("UPDATE Cliente SET cliente_mail = :mail WHERE cliente_nome = :nome")
    Integer updateEmailByNome(String mail, String nome);
}
