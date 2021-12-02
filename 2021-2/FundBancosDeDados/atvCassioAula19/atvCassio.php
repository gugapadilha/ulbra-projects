CREATE TABLE Autores(
    id serial NOT NULL PRIMARY KEY,
    nome varchar(50)
);

CREATE TABLE Editoras(
    id serial NOT NULL PRIMARY KEY,
    nome VARCHAR(40)
);

CREATE TABLE Livros(
    id serial NOT NULL PRIMARY KEY,
    nome VARCHAR(50),
    preco decimal,
    id_autor INT,
    id_editora INT,
    CONSTRAINT FK_Autor FOREIGN KEY (id_autor) REFERENCES autores(id),
    CONSTRAINT FK_Editora FOREIGN KEY (id_editora) REFERENCES editoras(id)
);

--Insert Values:

INSERT INTO autores( nome )
  VALUES 
  ('Gustavo'),
  ('Cassio'),
  ('Roger'),
  ('Clarice'),
  ('Clark'),
  ('Robert');

INSERT Into editoras(nome)
  VALUES
  ('Jabutti'),
  ('Infra e vida'),
  ('De volta pra casa'),
  ('Laziers'),
  ('Ouro Ferriço'),
  ('Diamante Unic');


INSERT INTO livros (nome, preco, id_autor, id_editora)
VALUES
('O Último Homem', 37.90, 1, 4),
('Mais Esperto que o Diabo', 80.00, 2, 5),
('Segredos da mente milionaria', 34.90, 3, 6),
('Torre da Andorinha',35.50, 1, 3),
('Respostas para Grandes questões',35.50,  6,1),
('O último desejo ', 100, 5, 2);

-- função de agregação (minimo 2. ex. Sum, count)

SELECT AVG(preco) as average, COUNT(id) as numero_de_livros
FROM livros;


SELECT SUM(preco) as soma_de_precos
FROM livros


SELECT MIN(preco) aS  preco 
FROM livros


SELECT MAX(preco) AS soma_de_precos
FROM livros

-- joins

SELECT livros.nome, autores.nome
FROM livros
INNER JOIN autores 
ON livros.id_autor = autores.id

-- group by

SELECT autores.nome, COUNt(livros.id) as num_de_livros
FROM livros
INNER JOIN autores 
ON livros.id_autor = autores.id
GROUP BY autores.id;

-- having

SELECT autores.nome, COUNt(livros.id) as num_de_livros
FROM livros
INNER JOIN autores 
ON livros.id_autor = autores.id
GROUP BY autores.id
HAVING COUNT(livros.id) < 3;