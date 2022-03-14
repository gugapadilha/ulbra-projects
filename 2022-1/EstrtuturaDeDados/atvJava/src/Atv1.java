import java.util.HashMap;
import java.util.Map;

public class Atv1 {
    public static void main(String[] args) throws Exception {

        Map<Integer, String> tempSemana = new HashMap<>();
        tempSemana.put(32, "Domingo");
        tempSemana.put(5, "Segunda");
        tempSemana.put(20, "Terça");
        tempSemana.put(26, "Quarta");
        tempSemana.put(13, "Quinta");
        tempSemana.put(22, "Sexta");
        tempSemana.put(16, "Sábado");

        var mediaTemperatura = tempSemana.keySet() // Retorna um Set com os valores
                .stream() // Transforma o Set em Stream
                .mapToInt(Integer::intValue) // Transforma o Set em Int
                .average();// Retorna a média

        System.out.println("Média de temperatura: " + mediaTemperatura);

    }
}