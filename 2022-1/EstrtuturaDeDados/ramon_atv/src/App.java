public class App {
    static int array[] = {20, 3, 7, 9};

    public static void main(String[] args) throws Exception {
        Funcao funcao = new Funcao();
        System.out.println("Soma: " + funcao.somaFunction(array, array.length));
        System.out.println("Maior: " + funcao.mostrarMaiorNumeroArray(array.length, array));
    }
}
