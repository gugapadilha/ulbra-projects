SET SQL_SAFE_UPDATES = 0;

-- Monte um comando para excluir da tabela livros aqueles que possuem o código maior ou igual a 2, que possuem o preço maior que R$ 50,00 e que já foram lançados.
DELETE FROM `livros` 
WHERE id >= 2 AND preco > 50 AND lancamento < NOW();

-- Escreva o comando que seleciona as colunas NOME, CPF e ENDERECO, da tabela AUTOR, para aqueles que possuem a palavra ‘joão’ no nome.
SELECT nome, cpf, endereco FROM `autores`
WHERE nome LIKE "%joão%";

-- Excluir o livro cujo título é ‘BANCO DE DADOS DISTRIBUÍDO’ ou ‘BANCOS DE DADOS DISTRIBUÍDOS’. Somente essas duas opções devem ser consideradas.
DELETE FROM `livros` 
WHERE titulo = "BANCOS DE DADOS DISTRIBUÍDO" OR titulo = "BANCO DE DADOS DISTRIBUÍDO";

-- Selecione o nome e o CPF de todos os autores que nasceram após 01 de janeiro de 1990.
SELECT nome, cpf FROM `autores`
WHERE data_nascimento > "1990-01-01";

-- Selecione a matrícula e o nome dos autores que possuem RIO DE JANEIRO no seu endereço.
SELECT id, nome FROM `autores`
WHERE endereco LIKE "%RIO DE JANEIRO%";

-- Atualize para zero o preço de todos os livros onde a data de lançamento for nula ou onde seu preço atual for inferior a R$ 55,00.
UPDATE `livros`
SET preco=0
WHERE lancamento is null OR preco < 55;

-- Exclua todos os livros onde o assunto for diferente de ‘S’, ‘P’, ou ‘B’.
DELETE FROM `livros` 
WHERE assunto_sigla != "S" AND assunto_sigla != "P" AND assunto_sigla != "B";

-- Escreva o comando para contar quantos são os autores cadastrados na tabela AUTORES.
SELECT COUNT(*) FROM `autores`;

-- Escreva o comando que apresenta qual o número médio de autores de cada livro. Você deve utilizar, novamente, a tabela AUTOR_LIVRO. 
SELECT AVG(autores_livros.autore_id) FROM `autores_livros`
	JOIN livros
		ON livros.id = autores_livros.livro_id;
        
SELECT AVG(quantos) as media_autores
FROM (
	SELECT livro_id, count(autore_id) AS quantos
	FROM `autores_livros`
    GROUP BY livro_id
) AS consulta;

-- Apresente o comando SQL para gerar uma listagem dos códigos dos livros que possuem a menos dois autores.
SELECT livros.id, livros.titulo, COUNT(livros.id) AS livros_total FROM `autores_livros`
	JOIN livros
		ON livros.id = autores_livros.livro_id
GROUP BY livros.id, livros.titulo
HAVING livros_total >= 2;

-- Escreva o comando para apresentar o preço médio dos livros por código de editora. Considere somente aqueles que custam mais de R$ 45,00.
SELECT livros.titulo, editoras.nome, AVG(livros.preco) AS media FROM `livros`
	JOIN editoras
		ON editoras.id = livros.editora_id
WHERE livros.preco > 45
GROUP BY livros.titulo, livros.editora_id;

-- Apresente o preço máximo, o preço mínimo e o preço médio dos livros cujos assuntos são ‘S’ ou ‘P’ ou ‘B’, para cada código de editora.
SELECT editoras.nome, MIN(livros.preco) AS preco_minimo, AVG(livros.preco) AS preco_media, MAX(livros.preco) AS preco_maximo FROM `livros`
	JOIN editoras
		ON editoras.id = livros.editora_id
WHERE livros.assunto_sigla = "S" OR livros.assunto_sigla = "P" OR livros.assunto_sigla = "B"
GROUP BY editoras.nome;

-- Altere o comando do exercício anterior para só considerar os livros que já foram lançados (data de lançamento inferior a data atual) e cujo o preço máximo é inferior a R$ 100,00.
SELECT editoras.nome, MIN(livros.preco) AS preco_minimo, AVG(livros.preco) AS preco_media, MAX(livros.preco) AS preco_maximo FROM `livros`
	JOIN editoras
		ON editoras.id = livros.editora_id
WHERE livros.assunto_sigla = "S" OR livros.assunto_sigla = "P" OR livros.assunto_sigla = "B" AND livros.lancamento < NOW()
GROUP BY editoras.nome
HAVING preco_maximo < 100;
