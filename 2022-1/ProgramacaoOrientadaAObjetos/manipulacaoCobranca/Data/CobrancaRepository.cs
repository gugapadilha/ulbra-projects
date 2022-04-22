using System.Collections.Generic;
using clientesCobrancas.Domain;

namespace clientesCobrancas.Data
{
    public class CobrancaRepository
    {
        private List<Cobrancas> listaDeCobrancas = new List<Cobrancas>();

        public List<Cobrancas> GetAll()
        {
            return listaDeCobrancas;
        } 

        public Cobrancas GetById(int idCobranca)
        {
            return listaDeCobrancas.Find(cob => cob.Id == idCobranca); //usando expressão lambda
        }

        public Cobrancas GetByCliente(Cliente cliente)
        {
            return listaDeCobrancas.Find(cl => cl.Cliente == cliente);
        }

        public void Update(Cobrancas cobranca)
        {
            var cobrancaEditada = GetById(cobranca.Id);

            cobrancaEditada.Valor = cobranca.Valor;
            cobrancaEditada.DataVencimento = cobranca.DataVencimento;
        }

        public void Save(Cobrancas cobranca)
        {
            listaDeCobrancas.Add(cobranca);
        }

        public void Delete(Cobrancas cobranca)
        {
            listaDeCobrancas.Remove(cobranca);
        }
    }
}