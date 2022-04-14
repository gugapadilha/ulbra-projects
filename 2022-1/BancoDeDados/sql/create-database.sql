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