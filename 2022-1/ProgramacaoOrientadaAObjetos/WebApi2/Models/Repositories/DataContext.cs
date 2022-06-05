using WebApi.Models.Domains;
using WebApi.Models.Domains;
using Microsoft.EntityFrameworkCore;

namespace WebApi.Models.Repositories
{
    public class DataContext : DbContext
    {
        public DataContext(DbContextOptions<DataContext> opts)
            :base(opts)
        {}

        public DbSet<Person> People { get; set; }

        public DbSet<Address> Addresses { get; set; }
        public DbSet<City> Cities { get; set; }
    }
}