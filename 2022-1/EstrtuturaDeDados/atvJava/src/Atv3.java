public class Atv3 {
    public static void main(String[] args) throws Exception {

        int vetor[] = new int[10];
        vetor = new int[] { 42, 24, 65, 4, 26, 24, 7, 98, 9, 27 };
        var have = false;

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] > 50) {
                have = true;
                System.out.println(vetor[i]);
            }

        }
        if(!have){
            System.out.println("nulo ou menor");
        }

    }
}