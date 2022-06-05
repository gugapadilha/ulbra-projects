namespace WebApi.Models.Repositories
{
    public interface IBaseRepository<Entity>
        where Entity : class
    {
         Entity GetById(int id);
         List<Entity>GetAll();
         void Create(Entity entity);
         void Update(Entity entity);
         void Delete(int id);
    }
}