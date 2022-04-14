CREATE DATABASE `02-aula`;
USE `02-aula`;

DROP TABLE IF EXISTS `autores_livros`;
DROP TABLE IF EXISTS `livros`;
DROP TABLE IF EXISTS `autores`;
DROP TABLE IF EXISTS `editoras`;
DROP TABLE IF EXISTS `assuntos`;

CREATE TABLE IF NOT EXISTS `assuntos` (
	sigla CHAR(1) PRIMARY KEY,
    descricao VARCHAR(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS `editoras` (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(40) NOT NULL
);

CREATE TABLE IF NOT EXISTS `autores` (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(40) NOT NULL,
    cpf VARCHAR(11) NOT NULL,
    endereco VARCHAR(50) NOT NULL,
    data_nascimento DATE NOT NULL,
    nacionalidade VARCHAR(30) NOT NULL
);

CREATE TABLE IF NOT EXISTS `livros` (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(80) NOT NULL,
    preco DOUBLE NOT NULL,
    lancamento DATE,
    editora_id INT NOT NULL,
    assunto_sigla CHAR(1) NOT NULL,
	CONSTRAINT livros_assuntos
		FOREIGN KEY (assunto_sigla)
			REFERENCES assuntos(sigla),
	CONSTRAINT livros_livros
		FOREIGN KEY (editora_id)
			REFERENCES editoras(id)
);

CREATE TABLE IF NOT EXISTS `autores_livros` (
    livro_id INT NOT NULL,
    autore_id INT NOT NULL,
	CONSTRAINT autores_livros_livros
		FOREIGN KEY (livro_id)
			REFERENCES livros(id),
	CONSTRAINT autores_livros_autores
		FOREIGN KEY (autore_id)
			REFERENCES autores(id)
);

INSERT INTO `editoras` (nome) 
	VALUES 
		("Mirandela Editora"),
        ("Editora Via-norte"),
        ("Editora Ilhas Tijucas"),
        ("Maria José Editora");
        
INSERT INTO `assuntos` (sigla, descricao) 
	VALUES 
		("B", "Banco de Dados"),
        ("P", "Programação"),
        ("R", "Redes"),
        ("S", "Sistemas Operacionais");
        
INSERT INTO `livros` (titulo, preco, lancamento, assunto_sigla, editora_id) 
	VALUES 
		("Banco de Dados para a Web", 31.20, "1999-01-10", "B", 1),
		("Programando em Linguagem C", 30.00, "1997-10-01", "P", 1),
		("Programando em Linguagem C++", 111.50, "1998-11-01", "P", 3),
		("Banco de Dados na Bioinformática", 48.00, "1998-04-08", "B", 2),
		("Redes de Computadores", 42.00, "1996-09-01", "R", 2);
                
INSERT INTO `autores` (nome, cpf, endereco, data_nascimento, nacionalidade) 
	VALUES 
		("Douglas Serena", "00000000000", "R. Casa SHow - Capão da Canoa RS, 95555-000", "2001-03-26", "Brasileiros"),
		("João Silva", "00000000000", "R. Casa SHow - Capão da Canoa RS, 95555-000", "2001-03-26", "Brasileiros"),
		("José Pedro", "00000000000", "R. Casa SHow - Capão da Canoa RS, 95555-000", "2001-03-26", "Brasileiros"),
		("Carlos Oliveira", "00000000000", "R. Casa SHow - Capão da Canoa RS, 95555-000", "2001-03-26", "Brasileiros"),
		("Matheus Silva", "00000000000", "R. Casa SHow - Capão da Canoa RS, 95555-000", "2001-03-26", "Brasileiros"),
		("João Carlos", "00000000000", "R. Casa SHow - Capão da Canoa RS, 95555-000", "2001-03-26", "Brasileiros");
                
INSERT INTO `autores_livros` (livro_id, autore_id)
	VALUES
		(1, 2),
        (2, 1),
        (3, 4),		
        (3, 2),
        (1, 1),
        (2, 4),
        (4, 3);

-- Monte um comando para excluir da tabela livros aqueles que possuem o código maior ou igual a 2, que possuem o preço maior que R$ 50,00 e que já foram lançados.
DELETE FROM `livros` 
WHERE id >= 2 AND preco > 50 AND lancamento < NOW();

-- Escreva o comando que seleciona as colunas NOME, CPF e ENDERECO, da tabela AUTOR, para aqueles que possuem a palavra ‘joão’ no nome.
SELECT nome, cpf, endereco FROM `autores`
WHERE nome LIKE "%joão%";

-- Excluir o livro cujo título é ‘BANCO DE DADOS DISTRIBUÍDO’ ou ‘BANCOS DE DADOS DISTRIBUÍDOS’. Somente essas duas opções devem ser consideradas.
DELETE FROM `livros` 
WHERE titulo = "BANCO DE DADOS DISTRIBUÍDO" OR titulo = "BANCOS DE DADOS DISTRIBUÍDOS";

-- Selecione o nome e o CPF de todos os autores que nasceram após 01 de janeiro de 1990.
SELECT nome, cpf FROM `autores`
WHERE data_nascimento > "1990-01-01";

-- Selecione a matrícula e o nome dos autores que possuem RIO DE JANEIRO no seu endereço.
SELECT id, nome FROM `autores`
WHERE endereco LIKE "%RIO DE JANEIRO%";

-- Atualize para zero o preço de todos os livros onde a data de lançamento for nula ou onde seu preço atual for inferior a R$ 55,00.
UPDATE livros
SET preco=0
WHERE lancamento is null OR preco < 55;

-- Exclua todos os livros onde o assunto for diferente de ‘S’, ‘P’, ou ‘B’.
DELETE FROM `livros` 
WHERE assunto_sigla != "S" AND assunto_sigla != "P" AND assunto_sigla != "B";

-- Escreva o comando para contar quantos são os autores cadastrados na tabela AUTORES.
SELECT COUNT(*) FROM `autores`;

-- Escreva o comando que apresenta qual o número médio de autores de cada livro. Você deve utilizar, novamente, a tabela AUTOR_LIVRO. 
SELECT AVG(autores_livros.autore_id) FROM autores_livros
	JOIN livros
		ON livros.id = autores_livros.livro_id;

-- Apresente o comando SQL para gerar uma listagem dos códigos dos livros que possuem a menos dois autores.
SELECT livros.id, livros.titulo, COUNT(livros.id) AS livros_total FROM autores_livros
	JOIN livros
		ON livros.id = autores_livros.livro_id
GROUP BY livros.id, livros.titulo
HAVING livros_total >= 2;

-- Escreva o comando para apresentar o preço médio dos livros por código de editora. Considere somente aqueles que custam mais de R$ 45,00.
SELECT livros.titulo, editoras.nome, AVG(livros.preco) AS media  FROM livros
	JOIN editoras
		ON editoras.id = livros.editora_id
WHERE livros.preco > 45
GROUP BY livros.titulo, livros.editora_id;

-- Apresente o preço máximo, o preço mínimo e o preço médio dos livros cujos assuntos são ‘S’ ou ‘P’ ou ‘B’, para cada código de editora.
SELECT editoras.nome, MIN(livros.preco) AS preco_minimo, AVG(livros.preco) AS preco_media, MAX(livros.preco) AS preco_maximo FROM livros
	JOIN editoras
		ON editoras.id = livros.editora_id
WHERE livros.assunto_sigla = "S" OR livros.assunto_sigla = "P" OR livros.assunto_sigla = "B"
GROUP BY editoras.nome;

-- Altere o comando do exercício anterior para só considerar os livros que já foram lançados (data de lançamento inferior a data atual) e cujo o preço máximo é inferior a R$ 100,00.
SELECT editoras.nome, MIN(livros.preco) AS preco_minimo, AVG(livros.preco) AS preco_media, MAX(livros.preco) AS preco_maximo FROM livros
	JOIN editoras
		ON editoras.id = livros.editora_id
WHERE livros.assunto_sigla = "S" OR livros.assunto_sigla = "P" OR livros.assunto_sigla = "B" AND livros.lancamento < NOW()
GROUP BY editoras.nome
HAVING preco_maximo < 100;

-- Estão sendo estudados aumentos nos preços dos livros. Escreva o comando SQL que retorna uma listagem contendo o titulo dos livros, e mais três colunas: uma contendo os preços dos livros acrescidos de 10% (deve ser chamada de ‘Opção_1’),
-- a segunda contendo os preços acrescidos de 15% (deve ser chamada de ‘Opção_2’) e a terceira contendo os preços dos livros acrescidos de 20% (deve ser chamada de ‘Opção_3’). Somente devem ser considerados livros que já tenham sido lançados.
SELECT livros.titulo, livros.preco * 1.1 AS opcao_1, livros.preco * 1.15 AS opcao_2, livros.preco * 1.2 AS opcao_3 FROM livros
WHERE livros.lancamento < NOW();

-- Escreva o comando SQL que apresenta uma listagem contendo o código da editora, o nome da editora, a sigla do assunto e o titulo dos livros que já foram lançados. Os dados devem estar em ordem decrescente de preço, e ascendente de código da editora e de título do livro.
SELECT editoras.id, editoras.nome AS editora, livros.titulo, livros.preco, livros.assunto_sigla FROM livros
	JOIN editoras
		ON editoras.id = livros.editora_id
WHERE livros.lancamento < NOW()
ORDER BY livros.preco DESC, editoras.id ASC;

-- Escreva o comando que apresente uma listagem dos nomes dos autores e do seu ano e mês de nascimento, para os autores brasileiros e que tem livros ainda não lançados. A listagem deve estar ordenada em ordem crescente de nome.
SELECT autores.nome AS autor, autores.data_nascimento FROM autores_livros
	JOIN livros
		ON livros.id = autores_livros.livro_id
	JOIN autores
		ON autores.id = autores_livros.autore_id
WHERE autores.nacionalidade = "Brasileiros" AND livros.lancamento > NOW()
ORDER BY autores.nome ASC;

-- Escreva o comando que retorna o nome dos autores e o título dos livros de sua autoria. A listagem deve estar ordenada pelo nome do autor, mostrar somente os livros já lançados.
SELECT autores.nome AS autor, livros.titulo FROM autores_livros
	JOIN livros
		ON livros.id = autores_livros.livro_id
	JOIN autores
		ON autores.id = autores_livros.autore_id
WHERE livros.lancamento < NOW()
ORDER BY autores.nome ASC;

-- Monte a consulta SQL que retorna as editoras que publicaram livros escritos pela autora 'Ana da Silva'
SELECT autores.nome AS autor, editoras.nome AS editora, livros.titulo FROM autores_livros
	JOIN livros
		ON livros.id = autores_livros.livro_id
	JOIN autores
		ON autores.id = autores_livros.autore_id
	JOIN editoras
		ON editoras.id = livros.editora_id
WHERE autores.nome = "Ana da Silva";

-- FUS (faça um SQL) que apresente o título do livro e o nome da editora que o publica para todos os livros que custam menos que 50 reais.
SELECT editoras.nome AS editora, livros.titulo FROM livros
	JOIN editoras
		ON editoras.id = livros.editora_id
WHERE livros.preco < 50;

-- FUS que apresente o CPF, nome do autor e o preço máximo dos livros de sua autoria. Apresente somente as informações para os autores cujo preço máximo for superior a 50.
SELECT autores.nome AS autor, autores.cpf, MAX(livros.preco) AS livro_maior_preco FROM autores_livros
	JOIN livros
		ON livros.id = autores_livros.livro_id
	JOIN autores
		ON autores.id = autores_livros.autore_id
GROUP BY autores.nome, autores.cpf
HAVING livro_maior_preco > 50;

