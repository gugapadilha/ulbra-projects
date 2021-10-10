import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Pokemon.captrar();

        Pokemon snorlax = new Pokemon(); //instanciando um objeto -pegou todas prop e metodos

        System.out.println(snorlax); //ja que nao setei nada, ele starta o objeto como null
        snorlax.nome = "Snorlax";
        snorlax.peso = 460;
        snorlax.descricao = "Pokemon do tipo normal";
        snorlax.tipo = "normal";
        snorlax.nivel = 10;
        snorlax.hit = 10;
        snorlax.vida = 100;
        System.out.println(snorlax);
        snorlax.atacar();
        snorlax.defender();
        System.out.println(snorlax);
        snorlax.atacar("Especial ataque");
        System.out.println(snorlax);

        Data hoje = new Data();
        hoje.dia = 5;
        hoje.mes = 10;
        hoje.ano = 2021;
        Data.separador="-"; //mudei o "/" pra "-"

        Data amanha = new Data();
        amanha.dia = 6;
        amanha.mes = 10;
        amanha.ano = 2021;

        hoje.mostrar();
        amanha.mostrar();

        Scanner tc = new Scanner(System.in);
    }
}
