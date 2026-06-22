EM PYTHON

A. Distribuição Justa de Cookies
Branch and Bound

Dado um vetor cookies, em que cada posição representa a quantidade de cookies em um pacote, distribua todos os pacotes entre k crianças.

Cada pacote deve ser dado inteiro para exatamente uma criança.

A injustiça da distribuição é o maior total de cookies recebido por uma criança. O objetivo é minimizar essa injustiça.

Entrada
A primeira linha contém dois inteiros n (número de pacotes) e k (número de crianças). A segunda linha contém n inteiros, representando os pacotes de cookies.

Saída
Imprima o menor valor possível da injustiça.

Explicação do Exemplo 1: Uma distribuição ótima é [8,15,8] e [10,20].
- A primeira criança recebe [8,15,8] que tem um total de 8 + 15 + 8 = 31 biscoitos.
- A segunda criança recebe [10,20] que tem um total de 10 + 20 = 30 biscoitos.
A injustiça da distribuição é max(31,30) = 31.
Pode-se demonstrar que não existe distribuição com um grau de injustiça inferior a 31.

Exemplos
Exemplo 1:

Entrada:

5 2
8 15 10 20 8
Saída:

31
Exemplo 2:

Entrada:

8 3
6 1 3 2 2 4 1 2
Saída:

7

C. Táxi
Gulosos

Depois de uma competição, vários grupos de crianças precisam voltar para casa de táxi.

Cada grupo deve permanecer junto e não pode ser dividido.

Um táxi possui exatamente 4 lugares, e cada grupo possui entre 1 a 4 crianças.

Determine o menor número de táxis necessários para transportar todos os grupos.

Entrada
 A primeira linha contém um inteiro, n, que representa a quantidade de grupos

A segunda linha contém n inteiros, s1, s2 … sn, onde cada si representa a quantidade de crianças do grupo i.

Saída
Imprima um único inteiro: menor quantidade de táxis necessária.

Exemplos
Exemplo 1:

Entrada:

5
1 2 4 3 3
Saída:

4
Exemplo 2:

Entrada:

8
2 3 4 4 2 1 3 1
Saída:

5
