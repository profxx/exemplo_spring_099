const url = "../recados";

function cadastrarRecado(){
    const mensagem = document.getElementById("mensagem").value;
    fetch(url, {
        method:"POST",
        headers:{"Content-Type":"application/json"},
        body: JSON.stringify(
            {
                "mensagem": mensagem
            }
        )
        })
        .then(() => {
            document.getElementById("mensagem").value = ""; // Limpar o campo de entrada
            mostrarRecados()})
}
function mostrarRecados(){

    const tabelaLidos = document.getElementById("tabelaLidos");
    const tabelaNaoLidos = document.getElementById("tabelaNaoLidos");

    fetch(url)
        .then((response)=> response.json())
        .then((jsonResponse) => {
            tabelaNaoLidos.innerHTML = jsonResponse
            .filter(recado => !recado.lido)
            .map(convertRecadoToTr).join("");

            tabelaLidos.innerHTML = jsonResponse
            .filter(recado => recado.lido)
            .map(convertRecadoToTr).join("");
        })
        .catch((error) => "mostrarRecados: " + error);

}
function convertRecadoToTr(recado){
    return `
        <tr>
            <td>${recado.mensagem}</td>
            <td>${recado.lido}</td>
            <td class="opcoes">
                ${recado.lido? "" : `<button class="btn btn-warning btn-sm lido" onclick="marcarComoLido(${recado.id}, ${JSON.stringify(recado.mensagem)})">Marcar como lido</button>`}
                <button class="btn btn-danger btn-sm" onclick="apagarRecado(${recado.id})">Deletar</button>
            </td>
        </tr>
    `
}
function apagarRecado(id) {
    fetch(`${url}/${id}`, {
        method: "DELETE"
    })
        .then(() => mostrarRecados())
        .catch((error) => "apagarRecado: " + error);
}
function marcarComoLido(id, mensagem){
    console.log(mensagem);
    fetch(`${url}/${id}`, {
        method: "PUT",
        headers: {"Content-Type":"application/json"},
        body: JSON.stringify(
            {
            "mensagem": mensagem,
            "lido": true
            })
    })
    .then(() => mostrarRecados())
    .catch((error) => "marcarComoLido: " + error);
}

mostrarRecados();

