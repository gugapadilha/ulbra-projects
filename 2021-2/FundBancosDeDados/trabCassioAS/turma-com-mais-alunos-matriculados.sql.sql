-- Faça um SQL para listar qual a turma que tem mais alunos matriculados.

SELECT t.sala, COUNT(a.idaluno)
FROM turma t 
INNER JOIN matricula m ON t.idturma = m.idturma
INNER JOIN aluno a ON a.idaluno = m.idaluno
GROUP BY t.idturma
ORDER BY COUNT(a.idaluno) DESC
LIMIT 1