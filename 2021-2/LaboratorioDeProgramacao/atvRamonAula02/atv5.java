import javax.swing.*;

public class atv5 {
    public static void main(String[] args) {
        double soma = 0;
        double somaTotal = 0;

        String produto;
        produto = new String(JOptionPane.showInputDialog("Digite o nome do produto: "));

        Float valor;
        valor = Float.parseFloat(JOptionPane.showInputDialog("Digite o valor do produto: "));

        if (200 > valor && valor >= 50) {
            soma = (valor * 0.05);
            somaTotal = (valor - soma);
        } else if (500 > valor && valor >= 200) {
            soma = (valor * 0.06);
            somaTotal = (valor - soma);
        } else if (1000 > valor && valor >= 500) {
            soma = (valor * 0.07);
            somaTotal = (valor - soma);
        } else {
            soma = (valor * 0.08);
            somaTotal = (valor - soma);
        }

        JOptionPane.showMessageDialog(null, "O valor de "+ produto+ " é de: "+ somaTotal+ "R$");
    }
}
