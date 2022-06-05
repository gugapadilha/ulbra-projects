using System.Collections.Generic;
using System.Linq;
using WebApi.Models.Domains;
using Microsoft.EntityFrameworkCore;

namespace WebApi.Models.Repositories
{
    public class PersonRepository : IPersonRepository
    {
        private DataContext context;
        public PersonRepository(DataContext context)
        {
            this.context = context;
        }
        public void Create(Person person)
        {
            if(person.City.Id>0)
                person.City = 
                context.Cities
                    .SingleOrDefault(x=>x.Id == person.City.Id);
            
            context.Add(person);
            context.SaveChanges();
        }

        public void Delete(int id)
        {
            context.People.Remove(GetById(id));
            context.SaveChanges();
        }

        public List<Person> GetAll()
        {
            return context.People
                .Include(c=>c.City).ToList();
        }

        public Person GetById(int id)
        {
            return context.People.Include(c=>c.City).SingleOrDefault(i=>i.Id == id);
        }

        public void Update(Person person)
        {
            context.People.Update(person);
            context.SaveChanges();
        }
    }
}