function verificarIdade(){
  var qtdMaiorIdade = 0;
  var qtdMenorIdade = 0;
  var digitado = document.getElementById('digitado').value;

  var numeros =  digitado.split(",")

  for(i = 0; i < numeros.length; i++){
    var numero = parseInt(numeros[i])
    if(numero >= 18){ 
      qtdMaiorIdade++
    }else{
      qtdMenorIdade++
    }
  }
  document.getElementById("qtdMaior").value = qtdMaiorIdade;
  document.getElementById("qtdMenor").value = qtdMenorIdade;
}
