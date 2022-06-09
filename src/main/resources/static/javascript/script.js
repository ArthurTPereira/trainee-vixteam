function buscarCliente() {
    var nome = document.getElementById("fnameId").value

    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        if(this.responseText == "null") {
            document.getElementById("resposta_span_id").textContent = "Cliente n\u00e3o encontrado.";
        } else if (this.responseText == "field") {
            document.getElementById("resposta_span_id").textContent = "Preencha todos os campos.";
        } else if (this.responseText == "multiple") {
            document.getElementById("resposta_span_id").textContent = "Mais de um cliente encontrado. Faça uma busca diferente.";
        } else {
            document.getElementById("resposta_span_id").textContent = this.responseText;
        }
    }

    xhttp.open("GET", "/helloBuscar?fname="+nome);
    xhttp.send();
}

function cadastrarCliente() {
    var nome = document.getElementById("fnameIdCadastro").value
    var mail = document.getElementById("fmailId").value

    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        if (this.responseText == "field") {
            document.getElementById("resposta_span_id2").textContent = "Preencha todos os campos.";
        } else if (this.responseText == "foundName") {
            document.getElementById("resposta_span_id2").textContent = "Cliente j\u00e1 cadastrado.";
        } else if (this.responseText == "foundMail") {
            document.getElementById("resposta_span_id2").textContent = "E-mail j\u00e1 cadastrado.";
        } else {
            document.getElementById("resposta_span_id2").textContent = "Cliente cadastrado com sucesso.";
        }
    }

    xhttp.open("GET", "/helloCadastrar?fname="+nome+"&fmail="+mail);
    xhttp.send();
    
}

function removerCliente() {
    var nome = document.getElementById("fnameIdRemover").value

    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        if (this.responseText == "success") {
            document.getElementById("resposta_span_id3").textContent = "Cliente removido com sucesso.";
        } else if (this.responseText == "field") {
            document.getElementById("resposta_span_id3").textContent = "Preencha todos os campos.";
        } else {
            document.getElementById("resposta_span_id3").textContent = "Cliente n\u00e3o encontrado.";
        }
    }

    xhttp.open("GET", "/helloRemover?fname="+nome);
    xhttp.send();
}

function alterarCliente() {
    var nome = document.getElementById("fnameIdAlterar").value
    var mail = document.getElementById("fmailIdAlterar").value

    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        if (this.responseText == "notFound") {
            document.getElementById("resposta_span_id4").textContent = "Cliente n\u00e3o encontrado.";
        } else if (this.responseText == "field") {
            document.getElementById("resposta_span_id4").textContent = "Preencha todos os campos.";
        } else {
            document.getElementById("resposta_span_id4").textContent = this.responseText;
        }

    }

    xhttp.open("GET", "/helloAlterar?fname="+nome+"&fmail="+mail);
    xhttp.send();
}

function logar() {
    var email = document.getElementById("fmailId").value
    var senha = document.getElementById("fsenhaId").value

    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        if (this.responseText == "fail") {
            document.getElementById("resposta_span_id5").textContent = "Usuário ou senha incorretos.";
        }
    }

    xhttp.open("POST", "/logar?fmail="+email+"&fsenha="+senha);
    xhttp.send();

}