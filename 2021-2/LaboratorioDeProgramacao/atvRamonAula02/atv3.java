import javax.swing.*;

public class atv3 {
    public static void main(String[] args) {
        double media = 0;
        var resultado = "";

        Float prova1;
        prova1 = Float.parseFloat(JOptionPane.showInputDialog("Digite a primeira nota: "));

        Float prova2;
        prova2 = Float.parseFloat(JOptionPane.showInputDialog("Digite a segunda nota: "));

        Float trabalho;
        trabalho = Float.parseFloat(JOptionPane.showInputDialog("Digite a terceira nota: "));


        media = ((prova1 + prova2 + trabalho) / 3);

        if (media >= 6) {
            resultado = "Aprovado";
        } else {
            resultado = "Reprovado";
        }
        JOptionPane.showMessageDialog(null, "A média ficou: "+ media+ " E você foi: "+ resultado);
    }
}
