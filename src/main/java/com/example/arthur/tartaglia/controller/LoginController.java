package com.example.arthur.tartaglia.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {


    @PostMapping("/logar")
    public String executarLogin(@RequestParam(name="fmail") String email, @RequestParam(name="fsenha") String password) {

        return "success";
    }
}
