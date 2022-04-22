using System;

namespace clientesCobrancas.Domain
{
    public class Cobrancas
    {
        public Cobrancas(int id, DateTime dataEmissao, DateTime dataVencimento, double valor, Cliente cliente)
        {
            this.Id = id;
            this.DataEmissao = dataEmissao;
            this.DataVencimento = dataVencimento;
            this.Valor = valor;
            this.Pago = false;
            this.DataPagamento = "";
            this.Cliente = cliente;
        }

        public int Id { get; set; }
        public DateTime DataEmissao { get; set; }
        public DateTime DataVencimento { get; set; }
        public double Valor { get; set; }
        public bool Pago { get; set; }
        public string DataPagamento { get; set; }
        public Cliente Cliente { get; set; }
    
    }
}