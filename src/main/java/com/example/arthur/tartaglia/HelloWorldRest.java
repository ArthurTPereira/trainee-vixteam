package com.example.arthur.tartaglia;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@RestController
public class HelloWorldRest {
    @GetMapping("/helloBuscar")
    public String buscar(@RequestParam(name = "fname") String nome) {


        boolean retorno = false;

        String sql = "SELECT cliente_nome from CLIENTE";
        String url = "jdbc:mysql://localhost:3306/treinamento";
        String user = "root";
        String pwd = "123789cfm";

        try (
            Connection conn = DriverManager.getConnection(url,user,pwd);
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(sql);
        ) {
            while (rs.next()) {
                if (rs.getString("cliente_nome").equalsIgnoreCase(nome)) {
                    retorno = true;
                    break;
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return retorno? "Cliente encontrado!" : "Cliente NÃO encontrado!";
    }
}
