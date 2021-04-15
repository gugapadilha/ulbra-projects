programa{
	real codPeca1, codPeca2
	real  qntVendasPeca1, valorUntdPeca1
	real  qntVendasPeca2, valorUntdPeca2 
	real	 totalValor1, totalValor2, totalTot	
	
	funcao inicio() {
		escreva("Digite o codigo da Primeira Peça: \n")
		leia(codPeca1)
		escreva("Digite a quantidade da Primeira Peça: \n")
		leia(qntVendasPeca1)
		escreva("Digite o valor unitário da Primeira peça: \n")
		leia(valorUntdPeca1)
		totalValor1 = (qntVendasPeca1 * valorUntdPeca1)

		escreva("Digite o codigo da Segunda Peça: \n")
		leia(codPeca2)
		escreva("Digite a quantidade da Segunda Peça: \n")
		leia(qntVendasPeca2)
		escreva("Digite o valor unitário da Segunda peça: \n")
		leia(valorUntdPeca2)
		totalValor2 = (qntVendasPeca2 * valorUntdPeca2)

		totalTot = totalValor1 + totalValor2
		escreva("O valor total a ser pago é de \n:" + totalTot) // TEM Q USAR O "+"
		
	} 
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 570; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */