//Pacote
package com.example.arthur.tartaglia.controller;

//Importações
import com.example.arthur.tartaglia.repository.ClienteServiceImp;
import com.example.arthur.tartaglia.model.Cliente;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Objects;

//Controller
@RestController
public class HelloController {

    @Autowired
    private ClienteServiceImp clienteService;

    //Função que faz a busca por um cliente na database
    @GetMapping("/helloBuscar")
    public String buscar(@RequestParam(name = "fname") String nome) {

        //Verifica se o input está vazio
        if (Objects.equals(nome,"")) {
            return "field";
        }

        //Declaração do JSON que será retornado ao front
        JSONObject clienteJson = null;

        //Verifica se foi encontrado mais de um cliente
        if (clienteService.getClienteByNome(nome).size() > 1 || clienteService.getClienteByEmail(nome).size() > 1) {
            return "multiple";
        }

        //Declaração da lista de clientes encontrados na database, inicialmente buscando pelo nome
        List<Cliente> clientesEncontrados = clienteService.getClienteByNome(nome);

        //Caso não seja encontrado o cliente, tenta buscar pelo e-mail
        if (clientesEncontrados.isEmpty()) {
            clientesEncontrados = clienteService.getClienteByEmail(nome);

            //Caso seja encontrado por e-mail, seleciona o cliente
            if (!clientesEncontrados.isEmpty()) {
                clienteJson = new JSONObject(clientesEncontrados.get(0));
            }
        } else { //Caso seja encontrado o cliente pelo nome, o seleciona
            clienteJson = new JSONObject(clientesEncontrados.get(0));
        }

        //Caso a lista de clientes encontrados não esteja vazia, retorna o JSON do cliente
        return !clientesEncontrados.isEmpty() ? clienteJson.toString() : "null";
    }

    //Função que faz o cadastro de um cliente na database
    @GetMapping("/helloCadastrar")
    public String cadastrar(@RequestParam String fname,
                            @RequestParam String fmail) {

        //Verifica se os campos a serem cadastrados estão vazios
        if (Objects.equals(fname, "") || Objects.equals(fmail,"")) {
            return "field";
        }

        //Declaração do objeto Cliente a ser cadastrado
        Cliente clienteCadastro = new Cliente(fname,fmail);

        //Verifica se o nome ou e-mail do cliente a ser cadastrado já existe na database
        if (clienteService.getClienteByNome(clienteCadastro.getNome()).size() >= 1) {
            return "foundName";
        } else if (clienteService.getClienteByEmail(clienteCadastro.getEmail()).size() >= 1) {
            return "foundMail";
        }

        //Cadastra o cliente na database
        clienteService.cadastraCliente(clienteCadastro);
        return "sucess";
    }

    //Função que remove um cliente da database
    @GetMapping("/helloRemover")
    public String remover(@RequestParam String fname) {

        //Verifica se todos os campos foram preenchidos
        if (Objects.equals(fname, "")) {
            return "field";
        }

        //Verifica se o nome do cliente está na database
        if (!clienteService.getClienteByNome(fname).isEmpty()) {

            //Remove o cliente da database
            clienteService.removeCliente(fname);
            return "success";
        }

        //Caso o cliente não esteja na database, retorna a mensagem
        return "notFound";
    }

    //Função que altera o e-mail de um cliente com base no seu nome
    @GetMapping("/helloAlterar")
    public String altera(@RequestParam String fname,
                         @RequestParam String fmail) {

        //Verifica se todos os campos foram preenchidos
        if (Objects.equals(fname, "") || Objects.equals(fmail, "")) {
            return "field";
        }

        //Verifica se o nome do cliente a ser alterado existe na database
        if (!clienteService.getClienteByNome(fname).isEmpty()){

            //Altera o e-mail do cliente
            return clienteService.alteraEmailCliente(fmail,fname);
        }

        //Caso o cliente não seja encontrado na database, retorna a mensagem
        return "notFound";
    }
}
