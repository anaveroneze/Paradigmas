-- 1. Escreva uma função addSuffix :: String -> [String] -> [String] usando list comprehension, 
-- para adicionar um dado sufixo às strings contidas numa lista. 
addSuffix :: String -> [String] -> [String]
addSuffix suf str = [suf++y| y<-str]

-- 2.Escreva uma função countShorts :: [String] -> Int, que receba uma lista de 
-- palavras e retorne a quantidade de palavras dessa lista que possuem menos de 5 caracteres. Use recursão.
countShorts :: [String] -> Int
countShorts [] = 0
countShorts (x:xs) = if (length x < 5) then 1 + countShorts xs else countShorts xs

-- 3.Reescreva a função do exercício acima, desta vez usando list comprehension.
countShorts' :: [String] -> Int
countShorts' str = length [x| x<-str, length x < 5]

-- 4.Escreva uma função ciclo :: Int -> [Int] -> [Int] que receba um número N e
-- uma lista de inteiros, retornando uma nova lista com N repetições da lista original, conforme o exemplo abaixo:
ciclo :: Int -> [Int] -> [Int]
ciclo 0 _ = []
ciclo num lst = lst ++ ciclo (num-1) lst

-- 5.Escreva uma função numera :: [String] -> [(Int,String)], que receba uma lista de palavras e 
-- retorne outra lista contendo tuplas com as palavras numeradas a partir de 1. Use recursão. Exemplo de uso da função:
numera :: [String] -> [(Int,String)]
numera str = numeraAux str [1..]

numeraAux :: [String] -> [Int] -> [(Int,String)]
numeraAux [] _ = []
numeraAux (x:xs) (y:ys) = (y, x) : numeraAux xs ys 

-- 6.Explique, em forma de comentário, o resultado de cada expressão abaixo.
{-
	a)  [ (x,y) | x <- [1..5], even x, y <- [(x + 1)..6], odd y ] 
		> [(2,3),(2,5),(4,5)]
		Lista de tuplas das possíveis combinações entre cada número par da 1ª lista com os números ímpares da 2ª lista, que sempre começa com o (par+1) encontrado na 1ª lista:
		1º) x <- [2,4], y <-[(2+1)..6]: combinações de x=2 e y <- [3,5]
		2º) x <- [2,4], y <-[(4+1)..6]: combinações de x=4 e y <- [5]
	b)  [ a ++ b | a <- ["lazy","big"], b <- ["frog", "dog"]]
		> ["lazyfrog","lazydog","bigfrog","bigdog"]
		Concatena cada string da 1ª lista com cada string da 2ª lista, retornando uma lista das strings concatenadas
	c)  concat [ [a,'-'] | a <- "paralelepipedo", not (elem a "aeiou")]
		> "p-r-l-l-p-p-d-"
		Concatena listas de consoantes seguidas de '-' formando uma string
-}

-- 7.(G. Malcolm, Univ. Liverpool) Write a function crossProduct :: [a] -> [b] -> [(a,b)] that takes two lists xs and ys, and returns the list of all possible pairings:
-- [ (x,y) | x <- xs, y <- ys ] without using the above list comprehension. (As an exercise in problem decomposition, try first defining a "helper" function 
-- pairWithAll :: a -> [b] -> [(a,b)] that pairs its first argument with each element in its second.)

pair :: [a] -> [b] -> [(a,b)]
pair [] _ = []
pair (x:xs) y = pairWithAll x y ++ pair xs y

pairWithAll :: a -> [b] -> [(a,b)]
pairWithAll _ [] = []
pairWithAll x (y:ys) = (x, y) : pairWithAll x ys

-- 8.
genRects :: Int -> (Int,Int) -> [(Float,Float,Float,Float)]
genRects n points = [(fromIntegral (fst points) + (5.5*fromIntegral x), fromIntegral (snd points), 5.5, 5.5) | x <- [0..(n-1)]]

-- 9.Escreva uma função recursiva que receba uma lista de tuplas e decomponha cada uma delas, gerando uma tupla de listas
listaTupla :: [(a, b)] -> ([a], [b])
listaTupla [] = ([],[])
listaTupla (x:xs) = (fst x : fst (listaTupla xs), snd x : snd (listaTupla xs)) 

-- 10.Refaça o exercício anterior usando list comprehension.
listaTupla' :: [(a, b)] -> ([a], [b])
listaTupla' lst = ([fst x | x <- lst],[snd y | y <- lst])

-- 11.Refaça o exercício anterior usando uma função de alta ordem.
listaTupla'' :: [(a, b)] -> ([a], [b])
listaTupla'' lst = (map(fst)lst , map(snd)lst) 