function buscarCliente() {
    var nome = document.getElementById("fnameId").value

    var xhttp = new XMLHttpRequest();
    xhttp.onload = function() {
        document.getElementById("resposta_span_id").textContent = this.responseText;
    }
    xhttp.open("GET", "/helloBuscar?fname="+nome);
    xhttp.send();
}