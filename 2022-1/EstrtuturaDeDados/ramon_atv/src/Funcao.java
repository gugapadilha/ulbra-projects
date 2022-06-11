public class Funcao {

    static int somaFunction(int arraySoma[], int posicao) {
        if (posicao <= 0) {
            return 0;
        }
        return (somaFunction(arraySoma, posicao - 1) + arraySoma[posicao - 1]);
    }

    static int mostrarMaiorNumeroArray(int arrayMaior, int posicao[]) {
        if (arrayMaior == 1)
            return posicao[0];
        if (mostrarMaiorNumeroArray(arrayMaior - 1, posicao) < posicao[arrayMaior - 1])
            return posicao[arrayMaior - 1];
        else
            return mostrarMaiorNumeroArray(arrayMaior - 1, posicao);
    }
}
