-- Faça um SQL para selecionar os alunos que não moram na cidade onde estudam.
-- Considerando que a cidade onde estudam é Torres.
-- Exibir o código, o nome do aluno e a cidade onde ele mora

SELECT a.idaluno, a.nome as nome_aluno, c.nome as nome_cidade
FROM aluno a
INNER JOIN cidade c ON a.idcid = c.idcid
WHERE c.nome NOT LIKE 'Torres'
