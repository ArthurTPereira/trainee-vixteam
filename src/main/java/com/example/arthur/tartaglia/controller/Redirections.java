//Pacote
package com.example.arthur.tartaglia.controller;

//Importações
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class Redirections implements WebMvcConfigurer {

    public void addViewControllers(ViewControllerRegistry registry) {

        //Redireciona a página /hello para o hello.html
        registry.addViewController("/hello").setViewName("forward:/html/hello.html");
        registry.addViewController("/login").setViewName("forward:/html/login.html");
    }
}