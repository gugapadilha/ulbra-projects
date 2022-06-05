namespace WebApi.Models.Domains
{
    public class City
    {
        public City(){}
        public City(int id, string nome, string estado)
        {
            this.Id = id;
            this.Nome = nome;
            this.Estado = estado;

        }
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Estado { get; set; }
    }
}