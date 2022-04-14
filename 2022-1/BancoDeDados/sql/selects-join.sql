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

