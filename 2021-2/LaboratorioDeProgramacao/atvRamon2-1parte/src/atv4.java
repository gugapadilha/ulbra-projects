import javax.swing.*;

public class atv4 {
    public static void main(String[] args) {
        double soma = 0;

        Float idade;
        idade = Float.parseFloat(JOptionPane.showInputDialog("Digite sua idade: "));

        Object[] itens = {"Homem", "Mulher"};
        Object selectedValue = JOptionPane.showInputDialog(null, "escolha um item", "opção",
                JOptionPane.INFORMATION_MESSAGE, null, itens, itens [0]);

        Float contribuicao;
        contribuicao = Float.parseFloat(JOptionPane.showInputDialog("Digite quantos anos você contribuiu: "));

        if (selectedValue == itens[0]) {
            if (contribuicao > 30) {
                JOptionPane.showMessageDialog(null, "Você ja tem direito a essa contribuição");
            }
            if (idade >= 60) {
                JOptionPane.showMessageDialog(null, "Você ja tem direito a essa contribuição");
            } else {
                JOptionPane.showMessageDialog(null, "Você não tem direito a essa contribuição");
            }
        } else {
            if (contribuicao > 35) {
                JOptionPane.showMessageDialog(null, "Você ja tem direito a essa contribuição");
            }
            if (idade >= 65) {
                JOptionPane.showMessageDialog(null, "Você ja tem direito a essa contribuição");
            } else {
                JOptionPane.showMessageDialog(null, "Você não tem direito a essa contribuição");
            }
        }
    }
}
