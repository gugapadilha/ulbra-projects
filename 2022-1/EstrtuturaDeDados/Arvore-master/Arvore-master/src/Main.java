import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Arvore arvore = new Arvore();
        int opcao;
        long x;
        System.out.println("Programa Arvore binaria de long");
        do {
            System.out.println("-------------------");
            System.out.println("Digite uma das opções:");
            System.out.println("1: Inserir");
            System.out.println("2: Excluir");
            System.out.println("3: Pesquisar");
            System.out.println("4: Exibir");
            System.out.println("5: Sair do programa");
            System.out.println("-------------------");
            System.out.println("-> ");
            opcao = teclado.nextInt();
            switch(opcao) {
                case 1: {
                    System.out.print("\n Informe o valor (long) -> ");
                    x = teclado.nextLong();
                    arvore.inserir(x);
                    break;
                }
                case 2: {
                    System.out.println(" Informe o valor (long) -> ");
                    x = teclado.nextLong();
                    if ( !arvore.remover(x) )
                        System.out.println(" Valor nao encontrado!");;
                    break;
                }
                case 3: {
                    System.out.println(" Informe o valor (long) -> ");
                    x = teclado.nextLong();
                    if( arvore.buscar(x) != null )
                        System.out.println(" Valor Encontrado");
                    else
                        System.out.println("Valor nao encontrado!");
                    break;
                }
                case 4: {
                    arvore.exibirArvore();
                    break;
                }
            } // fim switch
        } while(opcao != 5);
    }
}
