using System.Text;
using clientesCobrancas.Data;
using clientesCobrancas.Domain;

namespace clientesCobrancas.Services
{
    public class ClienteService
    {
        ClienteRepository clienteRep = new ClienteRepository();

        public int tamanhoListaClientes()
        {
            var quantidade = clienteRep.GetAll().Count;
            return quantidade;
        }

        public string criarCliente(string nome, string telefone)
        {
            int id = tamanhoListaClientes() + 1;

            clienteRep.Save(new Cliente(id, nome, telefone));

            return "Cliente adicionado!";
        }   

        public string editarCliente(int idCliente, string nome, string telefone)
        {
            string retorno;

            if(tamanhoListaClientes().Equals(0))
            {
                retorno = "LISTA VAZIA! Adicione o menos um cliente para poder editá-lo.";
                return retorno;
            }

            var contato = clienteRep.GetById(idCliente);

            if(contato == null){
                retorno = "Não há cliente cadastrado com o id digitado.";
                return retorno;
            }

            clienteRep.Update(new Cliente(idCliente, nome, telefone));
            retorno = "Contato Editado!";
            return retorno;
        }

        public string listarClientes()
        {
            var builder = new StringBuilder();
            var clientes = clienteRep.GetAll();
            var qtdClientes = tamanhoListaClientes();

            if(qtdClientes == 0)
            {
                builder.AppendLine("Lista vazia!");
                return builder.ToString();
            }

            foreach (var item in clientes)
            {
                builder.AppendLine($"Id: {item.Id} - Nome: {item.Nome} - Telefone: {item.Telefone}");
            }

            return builder.ToString();
        }

        public string RemoverCliente(int idCliente)
        {
            string retorno;

            if(tamanhoListaClientes().Equals(0))
            {
                retorno = "LISTA VAZIA! Adicione o menos um cliente para poder removê-lo.";
                return retorno;
            }

            var cliente = clienteRep.GetById(idCliente);

            if (cliente == null)
            {
                retorno = $"Não existe um cliente com o código {idCliente}";
            }

            clienteRep.Delete(cliente);

            retorno = "Cliente excluído!";
            return retorno;
        }

        public string AcharClienteNome(string nome)
        {
            var retorno = clienteRep.GetByNome(nome);
            return retorno;
        }
    }
}