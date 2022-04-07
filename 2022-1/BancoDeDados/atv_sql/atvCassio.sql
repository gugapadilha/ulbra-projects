

/*questao 3*/

/*a*/
delete from livros where id > 2 and preco > 50 and lancamento > current_date();

/*b*/
select lower(nome), cpf, endereco from autores where nome = "joao" or nome = "joão";

/*c*/
delete from livros where titulo = "BANCO DE DADOS DISTRIBUÍDO" or titulo = "BANCO DE DADOS DISTRIBUÍDOS";

/*d*/
select nome, cpf from autores where data_nascimento > date('1990-01-01');

/*e*/
select matricula, nome from autores where endereco like "%RIO DE JANEIRO%";

/*f*/
update livros set preco = 0 where lancamento is null or preco < 55;

/*g*/
delete from livros where id_assunto != 'S' and id_assunto != 'P'and id_assunto != 'B';

/*h*/
select count(matricula) as "quantidade de autores" from autores;

/*i*/
/*reformulação: quantos autores existem por livro e a media de autores*/
select avg(num_autores) as media_autores
from (
	select id_livro, count(matricula) as num_autores
	from autores_livros
	group by id_livro
)
as consulta;

/*j*/
select id_livro, count(matricula) as num_autores
from autores_livros
group by id_livro
having num_autores > 2;

/*l*/
select max(preco) as maximo, min(preco) as minimo, avg(preco) as media
from livros
where id_assunto in('B', 'P');

/*questao 4*/

/*a*/
select  titulo, (preco * 1.10) as opcao_1, 
		(preco * 1.15) as opcao_2, 
        (preco * 1.2) as opcao_3 
from livros
where lancamento is not null and lancamento >= current_date();

/*c*/
select autores.nome, 
		year(autores.data_nascimento), 
        month(autores.data_nascimento) as mes,
        livros.lancamento
from autores
	inner join autores_livros
    on autores.matricula = autores_livros.matricula
    inner join livros
    on livros.id = autores_livros.id
where nacionalidade 
		like '%brasil%' 
        and lancamento is null 
        and lancamento > current_date()
order by nome asc;
