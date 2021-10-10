public class Data {
   public int dia;
   public int ano;
   public int mes;
   public static String separador = "/";

   public void mostrar() {
       System.out.println(dia + separador + mes + separador + ano);
   }
}
