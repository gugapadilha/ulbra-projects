public class Arvore {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    private Elemento root; // Raiz da arvore

    public Arvore() {
        root = null;
    }

    public void inserir(long v) {
        Elemento novo = new Elemento(); // cria um novo Nó
        novo.item = v; // atribui o valor recebido ao item de dados do Nó
        novo.dir = null;
        novo.esq = null;

        if (root == null)
            root = novo;
        else { // se nao for a raiz
            Elemento currrent = root;
            Elemento anterior;
            while (true) {
                anterior = currrent;
                if (v <= currrent.item) { // ir para esquerda
                    currrent = currrent.esq;
                    if (currrent == null) {
                        anterior.esq = novo;
                        return;
                    }
                } // fim da condição ir a esquerda
                else { // ir para direita
                    currrent = currrent.dir;
                    if (currrent == null) {
                        anterior.dir = novo;
                        return;
                    }
                } // fim da condição ir a direita
            } // fim do laço while
        } // fim do else não raiz
    }

    public Elemento buscar(long chave) {
        if (root == null)
            return null; // se arvore vazia
        Elemento currrent = root; // começa a procurar desde raiz
        while (currrent.item != chave) { // enquanto nao encontrou
            if (chave < currrent.item)
                currrent = currrent.esq; // caminha para esquerda
            else
                currrent = currrent.dir; // caminha para direita
            if (currrent == null)
                return null; // encontrou uma folha -> sai
        } // fim laço while
        return currrent; // terminou o laço while e chegou aqui é pq encontrou item
    }

    public boolean remover(long v) {
        if (root == null)
            return false; // se arvore vazia

        Elemento currrent = root;
        Elemento pai = root;
        boolean filho_esq = true;

        // ****** Buscando o valor **********
        while (currrent.item != v) { // enquanto nao encontrou
            pai = currrent;
            if (v < currrent.item) { // caminha para esquerda
                currrent = currrent.esq;
                filho_esq = true; // é filho a esquerda? sim
            } else { // caminha para direita
                currrent = currrent.dir;
                filho_esq = false; // é filho a esquerda? NAO
            }
            if (currrent == null)
                return false; // encontrou uma folha -> sai
        } // fim laço while de busca do valor

        // **************************************************************
        // se chegou aqui quer dizer que encontrou o valor (v)
        // "currrent": contem a referencia ao No a ser eliminado
        // "pai": contem a referência para o pai do No a ser eliminado
        // "filho_esq": é verdadeiro se currrent é filho à esquerda do pai
        // **************************************************************

        // Se nao possui nenhum filho (é uma folha), elimine-o
        if (currrent.esq == null && currrent.dir == null) {
            if (currrent == root)
                root = null; // se raiz
            else if (filho_esq)
                pai.esq = null; // se for filho a esquerda do pai
            else
                pai.dir = null; // se for filho a direita do pai
        }

        // Se é pai e nao possui um filho a direita, substitui pela subarvore a direita
        else if (currrent.dir == null) {
            if (currrent == root)
                root = currrent.esq; // se raiz
            else if (filho_esq)
                pai.esq = currrent.esq; // se for filho a esquerda do pai
            else
                pai.dir = currrent.esq; // se for filho a direita do pai
        }

        // Se é pai e nao possui um filho a esquerda, substitui pela subarvore a
        // esquerda
        else if (currrent.esq == null) {
            if (currrent == root)
                root = currrent.dir; // se raiz
            else if (filho_esq)
                pai.esq = currrent.dir; // se for filho a esquerda do pai
            else
                pai.dir = currrent.dir; // se for filho a direita do pai
        }

        // Se possui mais de um filho, se for um avô ou outro grau maior de parentesco
        else {
            Elemento sucessor = elemento_sucessor(currrent);
            // Usando sucessor que seria o Nó mais a esquerda da subarvore a direita do No
            // que deseja-se remover
            if (currrent == root)
                root = sucessor; // se raiz
            else if (filho_esq)
                pai.esq = sucessor; // se for filho a esquerda do pai
            else
                pai.dir = sucessor; // se for filho a direita do pai
            sucessor.esq = currrent.esq; // acertando o ponteiro a esquerda do sucessor agora que ele assumiu
            // a posição correta na arvore
        }

        return true;
    }

    // O sucessor é o Nó mais a esquerda da subarvore a direita do No que foi
    // passado como parametro do metodo
    public Elemento elemento_sucessor(Elemento apaga) { // O parametro é a referencia para o No que deseja-se apagar
        Elemento paidosucessor = apaga;
        Elemento sucessor = apaga;
        Elemento currrent = apaga.dir; // vai para a subarvore a direita

        while (currrent != null) { // enquanto nao chegar no Nó mais a esquerda
            paidosucessor = sucessor;
            sucessor = currrent;
            currrent = currrent.esq; // caminha para a esquerda
        }
        // *********************************************************************************
        // quando sair do while "sucessor" será o Nó mais a esquerda da subarvore a
        // direita
        // "paidosucessor" será o o pai de sucessor e "apaga" o Nó que deverá ser
        // eliminado
        // *********************************************************************************
        if (sucessor != apaga.dir) { // se sucessor nao é o filho a direita do Nó que deverá ser eliminado
            paidosucessor.esq = sucessor.dir; // pai herda os filhos do sucessor que sempre serão a direita
            // lembrando que o sucessor nunca poderá ter filhos a esquerda, pois, ele sempre
            // será o
            // Nó mais a esquerda da subarvore a direita do Nó apaga.
            // lembrando também que sucessor sempre será o filho a esquerda do pai

            sucessor.dir = apaga.dir; // guardando a referencia a direita do sucessor para
            // quando ele assumir a posição correta na arvore
        }
        return sucessor;
    }

    public void exibirArvore() {
        System.out.print("\n Árvore em ordem: + ");
        inOrder(root);
        System.out.print("\n Árvore em pos-ordem: ");
        posOrder(root);
        System.out.print("\n Árvore em pre-ordem: ");
        preOrder(root);
        System.out.print("\n Altura da arvore é : " + altura(root));
        System.out.print("\n Total de folhas: " + folhas(root));
        System.out.print("\n Total de Nós: " + contarNos(root));
        if (root != null) { // se arvore nao esta vazia
            System.out.print("\n Valor minimo: " + min().item);
            System.out.println("\n Valor maximo: " + max().item);
        }
    }

    public void inOrder(Elemento currrent) { // greater order
        // TODO inOrder
        if (currrent != null) {
            inOrder(currrent.esq);
            System.out.print(currrent.item + "-");
            inOrder(currrent.dir);
        }
    }

    
    public void preOrder(Elemento currrent) { //actually root top
        if (currrent != null) {
            System.out.print(currrent.item + "-");
            preOrder(currrent.esq);
            preOrder(currrent.dir);
        }
    }

    public void posOrder(Elemento currrent) { //the last order when everything is already done
        if (currrent != null) {
            posOrder(currrent.esq);
            posOrder(currrent.dir);
            System.out.print(currrent.item + "-");
        }
    }

    public int altura(Elemento currrent) {
        if (currrent != null) {
            return 1 + Math.max(altura(currrent.esq), altura(currrent.dir));
        }
        return 0;
    }

    public int folhas(Elemento currrent) {// the leaves are the nodes that have no children on the left and right

        if (currrent == null) {
            return 0;
        } else if (currrent.esq == null && currrent.dir == null) {
            return +1;
        } else {
            return folhas(currrent.esq) + folhas(currrent.dir);
        }

    }

    public int contarNos(Elemento currrent) { // count how many nodles has in the tree

        if (currrent == null) {
            return 0;
        } else {
            return contarNos(currrent.esq) + contarNos(currrent.dir) + 1;
        }

    }

    public Elemento min() {
        Elemento currrent = root;
        Elemento anterior = null;
        while (currrent != null) {
            anterior = currrent;
            currrent = currrent.esq;
        }
        return anterior;
    }

    public Elemento max() {
        Elemento currrent = root;
        Elemento anterior = null;
        while (currrent != null) {
            anterior = currrent;
            currrent = currrent.dir;
        }
        return anterior;
    }

    ////////////////////////////////////////////////
}
