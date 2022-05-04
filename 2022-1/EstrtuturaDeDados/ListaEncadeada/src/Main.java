import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Lista numeros = new Lista();
        int op = 0;
        Scanner tc = new Scanner(System.in);
        do {
            System.out.println("\n1. para adicionar no inicio:");
            System.out.println("2. para adicionar no fim");
            System.out.println("3. para exibir a lista");
            System.out.println("4. para exibir o primeiro elemento da lista");
            System.out.println("5. para exibir o ultimo elemento da lista");
            System.out.println("99. para  sair\n");
            op = tc.nextInt();
            switch (op) {
                case 1: {
                    System.out.println("Digite o valor:\n");
                    int value = tc.nextInt();
                    Elemento e = new Elemento(value);
                    numeros.addInicio(e);
                    break;
                }
                case 2: {
                    System.out.println("Digite o valor:\n");
                    int value = tc.nextInt();
                    Elemento e = new Elemento(value);
                    numeros.addFim(e);
                    break;
                }
                case 3: {
                    numeros.mostrarLista();
                    break;
                }
                case 4: {
                    numeros.mostrarPrimeiro();
                    break;
                }
                case 5: {
                    numeros.mostrarUltimo();
                    break;
                }
            }

        } while (op != 99);

    }
}
