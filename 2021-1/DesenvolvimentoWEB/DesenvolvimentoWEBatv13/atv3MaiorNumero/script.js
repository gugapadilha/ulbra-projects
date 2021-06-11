function verificarNumero(){
  var maiorNumero = 0;
  var digitado = document.getElementById('digitado').value;

  var numeros =  digitado.split(",")

  for(i = 0; i < numeros.length; i++){
    var numero = parseInt(numeros[i])
    if(numero > maiorNumero){ 
      maiorNumero = numero 
    }
  }
  document.getElementById("maior").value = maiorNumero;
}
//3,14,2,7