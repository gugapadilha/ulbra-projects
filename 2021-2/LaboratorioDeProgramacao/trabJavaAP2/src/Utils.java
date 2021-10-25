import javax.swing.*;
import java.util.Scanner;

public class Utils {

    // SCANNER
    Scanner input = new Scanner(System.in);

    // LER SCANNER
    public void lerStringScanner() {
        System.out.println("Digite a String: ");
        System.out.println(input.next());
    }

    public void lerFloatScanner() {
        System.out.println("Digite o Float: ");
        System.out.println(input.nextFloat());
    }

    public void lerDoubleScanner() {
        System.out.println("Digite o Double: ");
        System.out.println(input.nextDouble());
    }

    public void lerIntScanner() {
        System.out.println("Digite o Int: ");
        System.out.println(input.nextInt());
    }

    public void lerCharScanner() {
        System.out.println("Digite o Char: ");
        System.out.println(input.next().charAt(0));
    }

    // LER JOPTIONPANE
    public void lerStringJoption() {
        var inputJo = JOptionPane.showInputDialog(null, "Digite a String: ");
        System.out.println(inputJo);
    }

    public void lerFloatJoption() {
        var inputJo = Float.parseFloat(JOptionPane.showInputDialog(null, "Digite o Float: "));
        System.out.println(inputJo);
    }

    public void lerDoubleJoption() {
        var inputJo = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o Double: "));
        System.out.println(inputJo);
    }

    public void lerIntJoption() {
        var inputJo = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o Int: "));
        System.out.println(inputJo);
    }

    public void lerCharJoption() {
        var inputJo = Character.charCount(JOptionPane.showConfirmDialog(null, "Digite o Char: "));
        System.out.println(inputJo);
    }

    // LER STRING FORMATADA DO EMAIL
    public Boolean lerStringFormatadaEmail() {

        System.out.println("Digite a String: ");

        var lerEmail = input.next();
        if (lerEmail.contains("@")) {
            System.out.println("Seu email é: " + lerEmail);
            return true;
        } else {
            return null;
        }
    }

    // LER O NUMERO DE TELEFONE FORMATADO
    public void lerNumeroTelefone() {
        StringBuilder numero = new StringBuilder();
        System.out.println("Escreva seu numero: ");

        var num = input.next();

        if (num.length() == 11) {
            var DDD = "(" + num.charAt(0) + num.charAt(1) + ")";
            for (int i = 2; i < num.length(); i++) {

                char n = num.charAt(i);
                numero.append(n);
            }
            System.out.println(DDD + numero);
        }
    }

    // LER A DATA FORMATADA
    public Boolean lerStringData() {

        System.out.println("Digite a data: ");
        var data = input.next();

        if (data.length() <= 10 && data.length() >= 8) {
            if (data.length() == 10) {
                System.out.println(data);
            } else {
                String dia = "" + data.charAt(0) + data.charAt(1);
                String mes = "" + data.charAt(2) + data.charAt(3);
                String ano = "" + data.charAt(4) + data.charAt(5) + data.charAt(6) + data.charAt(7);
                System.out.println(dia + "/" + mes + "/" + ano);
            }
            return true;
        } else {
            return null;
        }

    }

    // LER A DATA CONVERTIDA
    public Boolean lerStringDataConvertido() {

        System.out.println("Inverte data: ");
        var data = input.next();

        if (data.length() <= 10 && data.length() >= 8) {

            if (data.length() == 10) {
                var dc = data.replace("/", "");

                String dia = "" + dc.charAt(2) + dc.charAt(3);
                String mes = "" + dc.charAt(0) + dc.charAt(1);
                String ano = "" + dc.charAt(4) + dc.charAt(5) + dc.charAt(6) + dc.charAt(7);
                System.out.println(dia + "/" + mes + "/" + ano);

            } else {
                String dia = "" + data.charAt(2) + data.charAt(3);
                String mes = "" + data.charAt(0) + data.charAt(1);
                String ano = "" + data.charAt(4) + data.charAt(5) + data.charAt(6) + data.charAt(7);
                System.out.println(dia + "/" + mes + "/" + ano);

            }
            return true;
        } else {
            return null;
        }
    }

    // LER O NUMERO DIGITADO
    public Boolean lerDigitoNumerico() {

        System.out.println("Digite um valor númerico: ");
        var tipo = input.next();

        try {
            Integer.parseInt(tipo);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    //LER PARAMETRO
    public void chamadaMetodo(String parametro) {
        System.out.println(parametro);
    }

    public void lerUmDado() {
        System.out.println("#################################");
        System.out.println("Digite o numero de acordo com as atividades desejada!");
        System.out.println(" [1] LER EMAIL | [2] LER NUMERO DE TELEFONE | [3] LER A DATA FORMATADA " +
                            "[4] LER A DATA CONVERTIDA | [5] LER O NUMERO DIGITADO");

        var valor = input.nextInt();

        if (valor == 1) {
            lerStringFormatadaEmail();
        } if (valor == 2){
            lerNumeroTelefone();
        } if (valor == 3){
            lerStringData();
        } if (valor == 4) {
            lerStringDataConvertido();
        } if (valor == 5) {
            lerDigitoNumerico();
        }
    }

    public void lerUmTipo() {
        System.out.println("#################################");
        System.out.println("Digite o numero de acordo com a leitura digitada desejada( OU '0' PARA SAIR!) ");
        System.out.println(" [1] String | [2] Float | [3] Double | [4] Int | [5] Char ");

        var valorTipo = input.nextInt();

        if (valorTipo == 1){
            lerStringScanner();
        }else if (valorTipo == 2) {
            lerFloatScanner();
        }else if (valorTipo == 3){
            lerDoubleScanner();
        }else if (valorTipo == 4){
            lerIntScanner();
        }else if (valorTipo == 5){
            lerCharScanner();
        }else if (valorTipo == 0){
            System.out.println("Programa finalizado com sucesso! ");
        }
    }
}
