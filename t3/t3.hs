-- 1.Defina uma função recursiva que receba uma lista de números inteiros e produza uma nova lista com cada número elevado ao quadrado.
numsqrt :: [Int] -> [Int]
numsqrt [] = []
numsqrt (x:xs) = x^2  : numsqrt xs

-- 2.Escreva uma função recursiva que receba uma lista de nomes e adicione a string "Sr. " no início de cada nome.
addSr :: [String] -> [String]
addSr [] = []
addSr (x:xs) = ("Sr. " ++ x) : addSr xs

-- 3.Crie uma função recursiva que receba uma string e retorne o número de espaços nela contidos.
numSpaces :: String -> Int
numSpaces "" = 0
numSpaces (x:xs)
	| (x == ' ') = (1 + numSpaces xs)
	| otherwise = numSpaces xs

-- 4.Escreva uma função recursiva que, dada uma lista de números, calcule 3*n^2 + 2/n + 1 para cada número n da lista. 
numCalc :: [Float] -> [Float]
numCalc [] = []
numCalc n = (\n -> 3*n^2+2/n +1)(head n) : numCalc (tail n)

-- 5.Escreva uma função recursiva que, dada uma lista de números, selecione somente os que forem negativos.
numNeg :: [Integer] -> [Integer]
numNeg [] = []
numNeg (x:xs)
	| x<0 = x : numNeg xs
	| otherwise = numNeg xs

-- 6.Defina uma função não-recursiva que receba uma string e retire suas vogais, conforme os exemplos abaixo.
noVowels :: String -> String
noVowels x = [n | n <- x, not (n `elem` "aeiouAEIOU")]

-- 7.Expresse uma solução recursiva para o exercício anterior
noVowels' :: String -> String
noVowels' "" = ""
noVowels' (x:xs)
	| x `elem` "aeiouAEIOU" = noVowels' xs
	| otherwise = x : noVowels' xs

-- 8.Defina uma função não-recursiva que receba uma string, possivelmente contendo espaços, e que retorne outra string substituindo os demais caracteres por '-', mas mantendo os espaços. 
codifica :: String -> String
codifica x = map (\n -> if n /= ' ' then '-'; else n)x

-- 9.Defina uma função recursiva que resolva o mesmo problema do exercício anterior.
codifica' :: String -> String
codifica' "" = ""
codifica' (x:xs)
	| (x /= ' ') = '-' : codifica' xs
	| otherwise = x : codifica' xs

-- 10.Crie uma função recursiva charFound :: Char -> String -> Bool, que verifique se o caracter (primeiro argumento) está contido na string (segundo argumento).
charFound :: Char -> String -> Bool
charFound _ "" = False
charFound a (x:xs) 
	| a == x = True
	| otherwise = charFound a xs 

-- 11.Defina uma função recursiva que receba uma lista de coordenadas de pontos 2D e desloque esses pontos em 2 unidades, conforme o exemplo abaixo:
desloc :: [(Double, Double)] -> [(Double, Double)]
desloc [] = []
desloc (x:xs) = (fst x + 2.0, snd x + 2.0) : desloc xs

-- 12.Defina uma função recursiva que receba 2 listas e retorne uma lista contendo o produto, par a par, dos elementos das listas de entrada.
prodVet :: [Int] -> [Int] -> [Int]
prodVet [] _ = []
prodVet _ [] = []
prodVet (x:xs) (y:ys) = x*y : prodVet xs ys 

-- 13.Resolva o exercício anterior usando uma função de alta ordem, eliminando a necessidade de escrever código com recursão.
prodVet' :: [Int] -> [Int] -> [Int]
prodVet' x y = zipWith (*) x y

-- 14.Defina uma função recursiva que receba um número n e retorne uma tabela de números de 1 a n e seus quadrados
geraTabela :: Int -> [(Int, Int)]
geraTabela n = aux 1 n

aux :: Int -> Int -> [(Int, Int)]
aux x n = if (x <= n)
	then (x, x^2) : aux (x+1) n 
	else []