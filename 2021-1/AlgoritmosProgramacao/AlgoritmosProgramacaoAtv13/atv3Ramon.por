programa{
funcao inicio(){
	
        real vetor[5]
        inteiro newCod

        para ( inteiro i = 0; i < 5; i++ ) {
            escreva("Digite um número: ")
            leia(vetor[i])
        }

        faca {
            escreva("\nDigite '0' para cancelar o programa")
            escreva("\nDigite '1' para ordem digitada")
            escreva("\nDigite '2' para ordem ao contrário: ")
            leia(newCod)

            se ( newCod == 1 ) {
                para( inteiro i = 0; i < 5; i++ ) {
                    escreva(vetor[i] + " | ")
                }
            } senao se ( newCod == 2 ) {
                para( inteiro i = 4; i >= 0; i-- ) {
                    escreva(vetor[i] + " | ")
                }
            }senao se ( newCod != 0 ) {
                escreva("Entrada inválida. Tente novamente")
                escreva("\n")
            }

        } enquanto ( newCod != 0 )
    }
}
/* $$$ Portugol Studio $$$ 
 * 
 * Esta seção do arquivo guarda informações do Portugol Studio.
 * Você pode apagá-la se estiver utilizando outro editor.
 * 
 * @POSICAO-CURSOR = 28; 
 * @PONTOS-DE-PARADA = ;
 * @SIMBOLOS-INSPECIONADOS = ;
 * @FILTRO-ARVORE-TIPOS-DE-DADO = inteiro, real, logico, cadeia, caracter, vazio;
 * @FILTRO-ARVORE-TIPOS-DE-SIMBOLO = variavel, vetor, matriz, funcao;
 */