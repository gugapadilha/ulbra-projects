$(document).ready(function(){

    $("#botao").click(function(){
        alert("Ola")
        $("titulo1").html("Mudei o titulo")
    })
});

function funcaoDoBotao(){
    document.getElementById("titulo1").innerHTML = "mudei o titulo"
}




/*$("#titulo1")

$(".titulo")*/