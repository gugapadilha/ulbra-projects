import java.util.Scanner;

public class atv8 {
    public static void main(String[] args) {

        int soma = 0;

        Scanner input = new Scanner(System.in);
        System.out.print("Digite o primeiro multiplicador: ");
        int primeiro = input.nextInt();


        for (int i = 0; i <= 10; i++) {

            soma = i * primeiro;

            System.out.println("A multiplicação do numero: " + primeiro + "  x  " + i + " = " + soma );
        }
    }
}