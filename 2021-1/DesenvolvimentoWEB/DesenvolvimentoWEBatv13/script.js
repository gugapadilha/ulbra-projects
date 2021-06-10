
function aloMundo(){
    alert('oi');
}

function clickBotao(){

    var nome = document.getElementById('nome').value;
    var sobreNome = document.getElementById('sobreNome').value


    var divNome = document.getElementById('divNome').innerHTML = nome +  ' ' + sobreNome

    //document.getElementById('divNome').innerHTML = divNome + ' ' + nome + ' ' + sobreNome
}

function emCima(){
    alert('sobre do link!')
}

function fora(){
    alert('fora do link')
}