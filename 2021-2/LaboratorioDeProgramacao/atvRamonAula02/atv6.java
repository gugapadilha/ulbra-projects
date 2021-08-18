import java.util.Scanner;

public class atv6 {
    public static void main(String[] args) {

        int[] resist = new int[4];
        var soma = 0;
        int valorMenor = Integer.MAX_VALUE;
        int valorMaior = 0;

        resist = new int[4];

        for (int i = 0; i < 4; i++) {
            Scanner a = new Scanner(System.in);
            System.out.print("Valores da resistencia: ");
            int input = a.nextInt();
            resist[i] = input;
        }

        soma = (resist[0] + resist[1] + resist[2] + resist[3]);

        for (int i = 0; i < resist.length; i++) {
            if(resist[i] > valorMaior){
                valorMaior = resist[i];
            }
            if(resist[i] < valorMenor){
                valorMenor = resist[i];
            }


        }
        System.out.println("A resistencia equivalente é de: " + soma + " Já a maior resistencia é a: " + valorMaior + " E a resistencia menor é a: " + valorMenor);
    }
}