-- Faça um SQL para exibir o nome do aluno, o código do curso, o nome do curso, o nome do professor da turma e a data que ele se matriculou.
-- Apresentar somente para alunos que tenham se matriculado entre semestre 1 de 2019, considere que as matrículas iniciam em janeiro.

ALTER TABLE matricula
ADD data_matricula DATE;


SELECT a.nome as nome_aluno, c.idcurso, c.nomecurso, p.nome as nome_professor, m.data_matricula
FROM matricula m
INNER JOIN aluno a ON a.idaluno = m.idaluno
INNER JOIN turma t ON t.idturma = m.idturma
INNER JOIN curso c ON c.idcurso = t.idcurso
INNER JOIN professor p ON p.idprof = t.idprof
WHERE m.data_matricula BETWEEN '2019-01-01' AND '2019-06-30';