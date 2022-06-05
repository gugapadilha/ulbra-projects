namespace WebApi.Models.Domains
{
    public class Billing
    {
        public Billing(int id, float price, Person person) 
        {
            this.id = id;
                this.price = price;
                this.person = person;
                
        }
                public int id { get; set; }
        public float price { get; set; }
        public Person person { get; set; }
    }
}