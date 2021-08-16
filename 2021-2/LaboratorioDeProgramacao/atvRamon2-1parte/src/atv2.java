import javax.swing.JOptionPane;

public class atv2 {

    public static void main(String[] args) {

        double valor = 0;
        double imposto = 0;
        double soma = 0;

        int cont = 0;
        int cont2 = 0;

        Float imovel;
        imovel = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor da primeira transação: "));

        Float venal;
        venal = Float.parseFloat(JOptionPane.showInputDialog("O valor venal é: "));

        Float imovel2;
        imovel2 = Float.parseFloat(JOptionPane.showInputDialog("Qual o valor da segunda transação: "));

        Float venal2;
        venal2 = Float.parseFloat(JOptionPane.showInputDialog("O valor venal é: "));

        if (imovel > imovel2){
            imposto = (imovel * venal / 100);
            soma = imovel + imposto;
            cont++;
        }else {
            imposto = (imovel2 * venal2 / 100);
            soma = imovel2 + imposto;
            cont2++;
        }

        if(cont > cont2){
            valor = imovel;
        }else {
            valor = imovel2;
        }

        JOptionPane.showMessageDialog(null, "O maior valor ficou: "+ valor);
        JOptionPane.showMessageDialog(null, "Juntamente com o imposto, ficou: "+ soma);

    }
}
