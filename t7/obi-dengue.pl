/*
	(OBI 2009, Iniciação - Fase 1, Nível 2) 
	(http://olimpiada.ic.unicamp.br/passadas/pdf/provas/ProvaOBI2009_inic_f1n2.pdf)
	
	Problema: Combate à Dengue
	Uma força-tarefa para combater a dengue precisa visitar
	sete casas em busca de focos do mosquito. As casa
	são denominadas F, G, H, L, M, P e T. Deve ser feito
	um plano de ação determinando a ordem em que as
	casas são visitadas. Para isso considera-se as seguintes
	condições:
	• A casa F deve ser uma das três primeiras a serem
	visitadas.
	• A casa H deve ser visitada imediatamente antes
	da casa G.
	•A casa L não pode ser a primeira nem a sétima
	casa a ser visitada.
	• A casa M deve ser a primeira ou a sétima a ser
	visitada.
	• A casa P deve ser uma das três últimas a serem
	visitadas.
*/

%regra 1
regra1(D) :-
	nth0(P,D,f),
	P<3.

%regra 2
regra2(D) :-
	position2(D,h,g).
	position2([X,Y|_],X,Y).
	position2([_|T],X,Y) :-	position2(T,X,Y).

%regra 3
regra3(D) :- 
	nth0(P,D,l),
	P \= 0,
	P \= 6.

%regra 4
regra4(D) :- D = [_,_,_,_,_,_,m].
regra4(D) :- D = [m|_].

%regra 5
regra5(D) :-
	nth0(P,D,p),
	P > 3.

ordem([X,Y,Z|_],X,Y,Z).
ordem([_|T],X,Y,Z) :- ordem(T,X,Y,Z).

position(P,D,C) :-
	nth0(P1,D,C),
	P2 is P1+1,
	P == P2.

%todas regras juntas com sobre as combinações possíveis:
dengue(D) :-
	D = [_,_,_,_,_,_,_],
	Casas = [f,g,h,l,m,p,t],
	permutation(Casas,D),
	regra1(D),
	regra2(D),
	regra3(D),
	regra4(D),
	regra5(D).

%regras para cada questão:
questao2(X,Y,Z,P) :-
	dengue(D),
	ordem(D,X,Y,Z),
	position(P,D,g).

	questao3(D,X) :-
		dengue(D),
		position(4,D,X).

			questao4(P) :-
				dengue(D),
				position(6,D,p),
				position(P,D,h).

					questao5(Y1,Y2) :-
						dengue(D),
						ordem(D,X,Y1,Z),
						dengue(D1),
						ordem(D1,X,Y2,Z).

/*
	Questão 1:
	?-dengue([f,t,h,l,p,g,m]).
	?-dengue([h,g,f,l,t,p,m]).
	?-dengue([l,t,f,h,g,m,p]).
	?-dengue([m,f,d,h,l,g,t]).
	?-dengue([m,l,h,g,f,p,t]).

	Questão 2: 
	?-questao2(t,l,f,2).
	?-questao2(t,l,f,3).
	?-questao2(t,l,f,4).
	?-questao2(t,l,f,5).
	?-questao2(t,l,f,6).

	Questão 3: 
	?-questao3([h|_],f).
	?-questao3([h|_],g).
	?-questao3([h|_],l).
	?-questao3([h|_],m).
	?-questao3([h|_],p).

	Questão 4: resposta correta retorna false (exceto)
	?- questao4(1).
	?- questao4(2).
	?- questao4(3).
	?- questao4(4).
	?- questao4(5).

	Questão 5: 
	?- questao5(g,h).
	?- questao5(g,t).
	?- questao5(h,f).
	?- questao5(l,m).
	?- questao5(l,t).
*/
