package com.example.arthur.tartaglia.service;

import com.example.arthur.tartaglia.model.Administrador;
import com.example.arthur.tartaglia.repository.AdministradorRepositorio;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdministradorServiceImp implements AdministradorService {

    @Autowired
    private AdministradorRepositorio administradorRepositorio;

    @Override
    public List<Administrador> getAllAdministrador() {
        return administradorRepositorio.findAll();
    }
}
