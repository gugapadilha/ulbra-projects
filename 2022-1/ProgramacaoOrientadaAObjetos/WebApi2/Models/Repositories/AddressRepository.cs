using WebApi.Models.Repositories;
using WebApi.Models.Domains;
using Microsoft.EntityFrameworkCore;

namespace WebApi.Models.Repositories
{
    public class AddressRepository : IAddressRepository
    {
        private DataContext context;

        public AddressRepository(DataContext context)
        {
            this.context = context;
        }

        public void Create(Address entity)
        {
            entity.Person = context.People
            .SingleOrDefault(x=>x.Id == entity.Person.Id);
            context.Add(entity);
            context.SaveChanges();
        }

        public void Delete(int id)
        {
            throw new NotImplementedException();
        }

        public List<Address> GetAll()
        {
            return context.Addresses
                .Include(p=>p.Person)
                .Include(c=>c.Person.City)
                .ToList();
        }

        public Address GetById(int id)
        {
            throw new NotImplementedException();
        }

        public void Update(Address entity)
        {
            throw new NotImplementedException();
        }
    }
}