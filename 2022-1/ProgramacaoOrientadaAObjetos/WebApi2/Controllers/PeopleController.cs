using System.Collections;
using System.Collections.Generic;
using WebApi.Models.Domains;
using WebApi.Models.Repositories;
using Microsoft.AspNetCore.Mvc;

namespace WebApi.Controllers
{
    [ApiController]
    [Route("[controller]")]
    public class PeopleController : ControllerBase
    {
        private IPersonRepository repository;
    
        public PeopleController(IPersonRepository repository)
        {
            this.repository = repository;
        }

        [HttpGet()]
        public IEnumerable<Person>Get()
        {
            return repository.GetAll();
        }

        [HttpGet("{id}")]
        public Person Get(int id)
        {
            return repository.GetById(id);
        }

        [HttpPost()]
        public IActionResult Post([FromBody]Person person)
        {
            repository.Create(person);
            return Ok(person);
        } 

        [HttpPut]
        public ActionResult Put([FromBody] Person person)
        {
            repository.Update(person);
            return Ok( new {
                message = "Person Updated.",
                errorCode = 202,
                objCreated = person});
        }

        [HttpDelete("{Id}")]
        public ActionResult Delete(int id)
        {
            repository.Delete(id);
            return Ok( new {
                message = "Person deleted.",
                errorCode = 202
                });
        }
    }
}