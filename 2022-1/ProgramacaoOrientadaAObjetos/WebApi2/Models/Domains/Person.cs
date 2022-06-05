using System.Security.AccessControl;
using WebApi.Models.Domains;

namespace WebApi.Models.Domains
{
    public class Person
    {
        public Person(){}
        public Person(int id, string nome, string fone, City city)
        {
            this.Id = id;
            this.Nome = nome;
            this.Fone = fone;
            this.City = city;

        }
        public int Id { get; set; }
        public string Nome { get; set; }
        public string Fone { get; set; }
        public City City { get; set; }
    }
}