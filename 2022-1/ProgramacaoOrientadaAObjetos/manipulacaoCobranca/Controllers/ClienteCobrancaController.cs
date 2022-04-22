using System;
using clientesCobrancas.Data;
using clientesCobrancas.Services;

namespace clientesCobrancas.Controllers{
    public class ClienteCobrancaController{
        ClienteService ServicoCliente = new ClienteService();
        CobrancasService ServicoCobrancas = new CobrancasService();
        /*CobrancaRepository RepositoryCobrancas = new CobrancaRepository();
        ClienteRepository RepositoryCliente = new ClienteRepository();*/
        public void Menu(){
            string number = string.Empty;

            while(number != "99"){
                Console.WriteLine("Escreva o numero: (99) - finalizar o programa");

                Console.WriteLine("Escreva o numero: (1) - adicionar um novo cliente");
                Console.WriteLine("Escreva o numero: (2) - editar um cliente");
                Console.WriteLine("Escreva o numero: (3) - listar todos cliente");
                Console.WriteLine("Escreva o numero: (4) - remover um cliente");
                Console.WriteLine("Escreva o numero: (5) - ver quantos clientes estão cadastrados");
                Console.WriteLine("Escreva o numero: (6) - verificar se um cliente está cadastrado, pelo NOME");

                Console.WriteLine("Escreva o numero: (7) - adicionar uma nova cobrança");
                Console.WriteLine("Escreva o numero: (8) - pagar uma cobrança");
                Console.WriteLine("Escreva o numero: (9) - listar todas as cobranças");

                number = Console.ReadLine();

                switch (number){
                    case "99":
                        Environment.Exit(0);
                    break;

                    case "1":
                        Console.WriteLine("Digite o nome do cliente:");
                        string nome = Console.ReadLine().Trim();

                        Console.WriteLine("Digite o telefone do cliente:");
                        string telefone = Console.ReadLine().Trim();

                        var retorno = ServicoCliente.criarCliente(nome, telefone);
                        Console.WriteLine(retorno + "\n");
                    break;

                    case "2":
                        Console.WriteLine("Digite o id do usuário que deseja editar: ");
                        var clientes = ServicoCliente.listarClientes();

                        if(clientes.Contains("vazia")){
                            Console.WriteLine(clientes);
                            Menu();
                        }else{
                            Console.WriteLine(clientes);
                        }

                        string idCliente = Console.ReadLine();
                        int idClienteInt = Convert.ToInt32(idCliente);

                        Console.WriteLine("Digite o novo nome do cliente");
                        string novoNome = Console.ReadLine().Trim();

                        Console.WriteLine("Digite o novo telefone do cliente");
                        string novoTelefone = Console.ReadLine().Trim();

                        var retornoClienteEditado = ServicoCliente.editarCliente(idClienteInt, novoNome, novoTelefone);
                        Console.WriteLine(retornoClienteEditado + "\n");
                    break;

                    case "3":
                        var retornoListar = ServicoCliente.listarClientes();
                        Console.WriteLine(retornoListar);
                    break;

                    case "4":
                        Console.WriteLine("Escolha o id do cliente que deseja remover");
                        var todosClientes = ServicoCliente.listarClientes();

                        if (todosClientes.Contains("vazia")){
                            Console.WriteLine(todosClientes);
                            Menu();
                        }else{
                            Console.WriteLine(todosClientes);
                        }

                        string idClienteRemover = Console.ReadLine();
                        int idClienteRemoverInt = Convert.ToInt32(idClienteRemover);

                        var clienteRemovido = ServicoCliente.RemoverCliente(idClienteRemoverInt);
                        Console.WriteLine(clienteRemovido);
                    break;

                    case "5":
                        var tamanho = ServicoCliente.tamanhoListaClientes();
                        Console.WriteLine(tamanho);
                    break;

                    case "6":
                        Console.WriteLine("Digite o nome que deseja procurar na lista:");
                        string nomeCliente = Console.ReadLine();
                        nomeCliente = ServicoCliente.AcharClienteNome(nomeCliente);
                    break;

                    case "7":
                        Console.WriteLine("Digite o id do cliente que pertence a esta cobrança:");
                        var clientesListar = ServicoCliente.listarClientes();
                        int tamanhoLista = ServicoCliente.tamanhoListaClientes();
                        if(tamanhoLista == 0){
                            Console.WriteLine("Não há nenhum cliente cadastrado!");
                            Menu();
                        }else{
                            Console.WriteLine(clientesListar);
                        }

                        string id = Console.ReadLine();
                        var idInt = Convert.ToInt32(id);

                        Console.WriteLine("Digite a data de emissão da cobranca:");
                        string emissao = Console.ReadLine().Trim();

                        Console.WriteLine("Digite a data de vencimento da cobranca:");
                        string vencimento = Console.ReadLine().Trim();
                        DateTime dataVencData = Convert.ToDateTime(vencimento);

                        Console.WriteLine("Digite o valor da cobranca:");
                        string valor = Console.ReadLine().Trim();
                        double valorDouble = Convert.ToDouble(valor);

                        
                        var retorno2 = ServicoCobrancas.criarCobranca(emissao, dataVencData, valorDouble, idInt);
                        Console.WriteLine(retorno2 + "\n");
                    break;

                    case "8":
                    var tamanhoListaC = ServicoCobrancas.tamanhoListaCobrancas();
                        if(tamanhoListaC == 0){
                            Console.WriteLine("A lista de cobranças está vazia!");
                        }else{
                            ServicoCobrancas.listarTodasCobrancas();

                            Console.WriteLine("Digite o id da cobrança que deseja pagar");
                            string idCob = Console.ReadLine().Trim();
                            int idCobInt = Convert.ToInt32(idCob);

                            var retorno3 = ServicoCobrancas.pagamentoEfetuar(idCobInt);
                            Console.WriteLine(retorno3 + "\n");                           
                        }
                    break;

                    case "9":
                        var retorno4 = ServicoCobrancas.listarTodasCobrancas();
                        Console.WriteLine(retorno4);
                    break;

                    default:
                        Console.WriteLine("Opção inválida!");
                        Menu();
                    break;
                }
            }
        }
    }
}