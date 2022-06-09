package com.example.arthur.tartaglia.controller;

import com.example.arthur.tartaglia.model.Administrador;
import com.example.arthur.tartaglia.service.AdministradorServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Objects;

@Controller
public class LoginController {

    @Autowired
    private AdministradorServiceImp administradorService;

    @PostMapping("/logar")
    public String executarLogin(@RequestParam(name="fmail") String email, @RequestParam(name="fsenha") String password) {
        List<Administrador> admins = administradorService.getAllAdministrador();

        for (Administrador adm : admins) {
            if (Objects.equals(adm.getEmail(), email) && Objects.equals(adm.getPassword(), password)) {
                return "success";
            }
        }

        return "fail";
    }
}
