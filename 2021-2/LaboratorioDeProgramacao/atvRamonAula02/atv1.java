import java.util.Scanner;

public class atv1 {

    public static void main(String[] args) {

        double conta = 0;

        Scanner produtos = new Scanner(System.in);
        System.out.println("Digite o valor do produto: ");
        double prod = produtos.nextInt();

        Scanner porcentagem = new Scanner(System.in);
        System.out.println("Digite o valor do desconto: ");
        double porc = porcentagem.nextInt();

        conta = prod * porc / 100;

        System.out.println("O valor do produto foi de: "+ prod);
        System.out.println("A porcentagem do desconto foi: "+ porc );
        System.out.println("O valor final foi de: "+ (prod - conta));

    }
}

