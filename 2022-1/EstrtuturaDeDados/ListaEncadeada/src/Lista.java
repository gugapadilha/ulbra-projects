public class Lista {
    // descritor --descreve a lista
    Elemento inicio;
    int quantidade;
    Elemento fim;
    Elemento dados = inicio;
    
    public void esvaziar() {
        inicio = null;
        quantidade = 0;
        fim = null;
    }

    public void addInicio(Elemento e) {
        if (inicio == null) {
            inicio = e;
            quantidade++;
            fim = e;
        } else {
            e.prox = inicio;
            inicio = e;
            quantidade++;

        }
    }

    public void addFim(Elemento e) {
        if (inicio == null) {
            inicio = e;
            quantidade++;
            fim = e;
        } else {
            fim.prox = e;
            fim = e;
            quantidade++;

        }
    }

    public void mostrarLista() {
        
     for (Elemento e = inicio; e != null; e = e.prox) {
            System.out.println(e.dado);
        }
        
    }

    public void mostrarPrimeiro() {
        System.out.println(inicio.dado);
    }

    public void mostrarUltimo() {
        System.out.println(fim.dado);
    }

}
