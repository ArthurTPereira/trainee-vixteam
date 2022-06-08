function buscarCliente() {
    var nome = document.getElementById("fnameId").value

    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("resposta_span_id").textContent = this.responseText;
    }

    if (this.responseText == "null") {

    } else {

    }

    xhttp.open("GET", "/helloBuscar?fname="+nome);
    xhttp.send();
}

function cadastrarCliente() {
    var nome = document.getElementById("fnameIdCadastro").value
    var mail = document.getElementById("fmailId").value

    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("resposta_span_id2").textContent = this.responseText;
    }

    xhttp.open("GET", "/helloCadastrar?fname="+nome+"&fmail="+mail);
    xhttp.send();
    
}