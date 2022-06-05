using WebApi.Models.Domains;

namespace WebApi.Models.Domains
{
    public class Address
    {
        public Address() {}
        public Address(int id, string street, string number, string zipCode)
        {
            this.Id = id;
            this.Street = street;
            this.Number = number;
            this.ZipCode = zipCode;

        }
        public int Id { get; set; }
        public string Street { get; set; }
        public string Number { get; set; }

        public string ZipCode { get; set; }
        public Person Person { get; set; }
    }
}