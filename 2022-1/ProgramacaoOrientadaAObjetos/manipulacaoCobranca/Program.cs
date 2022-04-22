using clientesCobrancas.Controllers;

namespace clientesCobrancas
{
    class Program
    {
        static void Main(string[] args){
            ClienteCobrancaController ccc = new ClienteCobrancaController();
            ccc.Menu();
        }
    }
}
