--1. Crie uma função somaQuad :: Int -> Int -> Int que calcule a soma dos quadrados de dois números x e y.

somaQuad :: Int -> Int -> Int 
somaQuad x y = (x^2 + y^2) 

--2. Crie uma função hasEqHeads :: [Int] -> [Int] -> Bool que verifique se 2 listas possuem o mesmo primeiro elemento. 
--Use o operador lógico '==' para verificar igualdade.

hasEqHeads :: [Int] -> [Int] -> Bool
hasEqHeads x y = if head x == head y then True else False

--3. Escreva uma função que receba uma lista de nomes e adicione a string "Sr. " no início de cada nome.

addSr  :: [String]->[String]
addSr names = map ("Sr. " ++) names
lstrg names = length names

--4. Crie uma função que receba uma string e retorne o número de espaços nela contidos. Dica: aplique 2 funções consecutivamente.

numSpaces :: String -> Int
numSpaces x =  length (filter (== ' ') x)

--5. Escreva uma função que, dada uma lista de números, calcule 3*n^2 + 2/n + 1 
--para cada número n da lista. Dica: defina uma função anônima.

numList :: [Float] -> [Float]
numList numbers = map (\n -> 3*(n^2) + (2/n + 1)) numbers 

--6. Escreva uma função que, dada uma lista de números, selecione somente os que forem negativos.

numNeg :: [Integer] -> [Integer] 
numNeg numbers = filter (<0) numbers

--7. Escreva uma função que receba uma lista de números e retorne somente os que estiverem entre 1 e 100, inclusive. 
--Dica 1: use uma função anônima. Dica 2: use o operador '&&' para expressar um 'E' lógico.

numSlct :: [Integer] -> [Integer]
numSlct numbers = filter (\n -> n>=1 && n<=100)numbers

--8. Escreva uma função que, dada uma lista de idades de pessoas no ano atual, retorne uma lista somente com as idades
-- de quem nasceu depois de 1970. Para testar a condição, sua função deverá subtrair a idade do ano atual.

after70 :: [Int] -> [Int]
after70 age = filter(\n -> 2016-n > 1970)age 

--9. Escreva uma função que receba uma lista de números e retorne somente aqueles que forem pares.

numEven :: [Int] -> [Int]
numEven numbers = filter(even)numbers

--10. Crie uma função charFound :: Char -> String -> Bool que verifique se o caracter (primeiro argumento) 
--está contido na string (segundo argumento).

charFound :: Char -> String -> Bool
--charFound x y = x `elem` y
charFound x y = length(filter(x==) y) > 0

{-
11. A função takeWhile :: (a -> Bool) -> [a] -> [a] é uma função de alta ordem. Ela recebe uma função condicional e uma 
lista, retornando o "menor prefixo" (isto é, porção inicial) da lista que satisfaça a condição dada. 
Teste os exemplos abaixo no GHCi e depois crie um novo exemplo:

> takeWhile (< 5) [1,2,3,4,5]
[1,2,3,4]
> takeWhile (/=' ') "Fulana de Tal"
"Fulana"

> takeWhile (\n-> n^2 < 50) [1,2,3,4,5,6,7,8,9]
[1,2,3,4,5,6,7]
-}

--12. Crie uma função que receba uma lista de nomes e retorne outra lista com somente aqueles nomes que terminarem com a letra 'a'.

finalA :: [String] -> [String]
finalA names = filter(\n -> last n == 'a')names
