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