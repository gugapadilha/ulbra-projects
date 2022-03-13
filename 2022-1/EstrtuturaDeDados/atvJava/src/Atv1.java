import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

public class Atv1 {

    public static void main(String[] args) {

        var totalSum = 0;

         Map<Object, String> tempSemana = new HashMap();
         tempSemana.put(21, "segunda-feira");
         tempSemana.put(26, "terça-feira");
         tempSemana.put(31, "quarta-feira");
         tempSemana.put(19, "quinta-feira");
         tempSemana.put(8,  "sexta-feira");
         tempSemana.put(33, "sabado");
         tempSemana.put(30, "domingo");

        System.out.println(tempSemana);

         var media = tempSemana.keySet().stream().reduce(0, (a, b) -> somaTotal(a, b) / 7 );
        System.out.println(media);

        }

        public static int somaTotal(Object a, Object b ){

        return  somaTotal(a, b);


    }
}
