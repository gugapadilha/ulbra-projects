import java.util.Scanner;

public class atv7 {
    public static void main(String[] args){

        boolean confirmador = false;
        int tentativa = 0;

        do {
            Scanner scan = new Scanner(System.in);
            System.out.print("Digite o seu email: ");
            String email = scan.nextLine();

            System.out.print("Digite a sua senha: ");
            String senha = scan.nextLine();

            if (email.equals("java8") && senha.equals("java8")) {
                System.out.println("Você se conectou na sua conta do JAVA! e foram um total de: " +tentativa +" tentativas" );
                confirmador = true;
            }else{
                System.out.println("Senha incorreta.3 tentativas restante e a quantidade de tentativas são:" + tentativa);
                tentativa++;
            }

        } while (confirmador == false && tentativa < 3);
    }
}