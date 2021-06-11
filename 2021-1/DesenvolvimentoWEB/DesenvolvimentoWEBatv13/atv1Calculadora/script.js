function calcular(operacao) {
var valor1 = document.calcform.valor1.value;
var valor2 = document.calcform.valor2.value;

if (operacao == "somar") {
    var res = parseInt(valor1) + parseInt(valor2); /*se nao colocar o parse ELE QUEBRA*/ 
} else {
if (operacao == "subtrair") {
    var res = valor1 - valor2;
} else {
    if (operacao == "multiplicar") {
        var res = valor1 * valor2;
    } else {
        var res = valor1 / valor2;
    }
}
}
    document.calcform.res.value = res;
}
