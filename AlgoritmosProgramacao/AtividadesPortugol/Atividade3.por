
programa
{
    inteiro numeroFuncionario
    real horasTrabalhada, valorHora, salario
    funcao inicio()
    {
        escreva("Qual o número do funcionário?\n")
        leia(numeroFuncionario)
        escreva("Quantas horas ele trabalhou?\n")
        leia(horasTrabalhada)
        escreva("Qual o valor da hora dele?\n")
        leia(valorHora)
        salario = horasTrabalhada * valorHora
        escreva("O salário do funcionário ", numeroFuncionario, " é R$", salario)
    }
}




/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 0; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */