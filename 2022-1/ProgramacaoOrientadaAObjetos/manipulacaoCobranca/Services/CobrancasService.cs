using System;
using System.Text;
using clientesCobrancas.Data;
using clientesCobrancas.Domain;

namespace clientesCobrancas.Services{
    public class CobrancasService{
        CobrancaRepository cobRep = new CobrancaRepository();
        ClienteRepository clRep = new ClienteRepository();
        public int tamanhoListaCobrancas(){
            var quantidade = cobRep.GetAll().Count;
            return quantidade;
        }
        public string criarCobranca(string dataEmissao, DateTime dataVencimento, double valor, int idCliente){
            int id = tamanhoListaCobrancas() + 1;

            DateTime dataEmissaoC = Convert.ToDateTime(dataEmissao);

            Cliente clienteDaCob = clRep.GetById(idCliente);

            cobRep.Save(new Cobrancas(id, dataEmissaoC, dataVencimento, valor, clienteDaCob));
            return "Cobrança adicionada!";
        }   
        public string listarTodasCobrancas(){
            var builder = new StringBuilder();
            var cobrancas = cobRep.GetAll();
            var qtdCob = tamanhoListaCobrancas();

            if(qtdCob == 0){
                builder.AppendLine("Lista vazia!");
                return builder.ToString();
            }

            foreach (Cobrancas itemC in cobrancas){
                if(itemC.Pago == true){
                    builder.AppendLine($"Id: {itemC.Id} - Data de vencimento: {itemC.DataVencimento} - Data de Emissao: {itemC.DataEmissao} - Fatura Paga: {itemC.DataPagamento} - Valor: {itemC.Valor}");
                }else{
                    builder.AppendLine($"Id: {itemC.Id} - Data de vencimento: {itemC.DataVencimento} - Data de Emissao: {itemC.DataEmissao} - Valor: {itemC.Valor}");
                }
            }

            return builder.ToString();
        }
        public string RemoverCobranca(int idCob){
            string retorno;

            if(tamanhoListaCobrancas().Equals(0)){
                retorno = "LISTA VAZIA! Adicione o menos uma cobrança para poder removê-la.";
                return retorno;
            }

            var cobranca = cobRep.GetById(idCob);

            if (cobranca == null){
                retorno = $"Não existe uma cobrança com o código {idCob}";
            }

            cobRep.Delete(cobranca);

            retorno = "Cobrança excluída!";
            return retorno;
        }
        public string pagamentoEfetuar(int idCob){
            Cobrancas cobranca = null;
            cobranca = cobRep.GetById(idCob);

            if(cobranca == null){
                return "ERRO, cobrança não encontrada, verifique o id correto na lista de cobranças";
            }
            
            if (cobranca.Pago == true){
                return "Está cobrança já está paga!";
            }

            DateTime dataHoje = DateTime.Today;
            DateTime venc = cobranca.DataVencimento;

            int result = DateTime.Compare(dataHoje, venc);
            
            if(result > 0){
                double valorReajustado = cobranca.Valor * 1.15;
                cobranca.Valor = valorReajustado;

                cobranca.DataPagamento = dataHoje.ToString();
                cobranca.Pago = true;

                return $"Pagamento realizado. Você pagou depois da data de vencimento, por isso foi aplicado juros de 15%.\nValor com juros: R${cobranca.Valor} - Data de Emissao: {cobranca.DataEmissao} - Data de vencimento: {cobranca.DataVencimento} - Data de Pagamento: {cobranca.DataPagamento}";
            }else{
                cobranca.DataPagamento = dataHoje.ToString();
                cobranca.Pago = true;

                return $"Pagamento realizado.\nValor pago: R${cobranca.Valor} - Data de Emissao: {cobranca.DataEmissao} - Data de vencimento: {cobranca.DataVencimento} - Data de Pagamento: {cobranca.DataPagamento}";
            }
        }
    }
}