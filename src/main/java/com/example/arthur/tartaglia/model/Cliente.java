package com.example.arthur.tartaglia.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="cliente")
public class Cliente {
    @Id
    @Column(name = "cliente_ID", nullable = false)
    private long id;

    @Column(name = "cliente_nome",nullable = false)
    private String nome;

    @Column(name = "cliente_mail", nullable = false)
    private String email;

    public Cliente() {

    }

    public Cliente(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return this.nome;
    }
}
