%1
zeroInit([0|_]).

%2
has5([_,_,_,_,_]).

%3
hasN(L,N) :- length(L, N).

%4
potN0(-1, []).
potN0(N, [X|T]) :- 
	N >= 0,
	X is 2^N,
	N1 is N-1,
	potN0(N1, T).

%5
zipmult([],[],[]).
zipmult([H1|T1], [H2|T2], [H3|T3]) :- 
	H3 is H1*H2,
	zipmult(T1, T2, T3). 

%6
potencias(N,L) :- potencias_aux(N, 0, L).
potencias_aux(N, N, []).
potencias_aux(N, C, [H|T]) :-
	C =< N,
	H is 2^C,
	C1 is C+1, 
	potencias_aux(N, C1, T).

%7
positivos([],[]).
positivos([H|T],L) :- H =< 0, positivos(T, L).
positivos([H|T1], [H|T2]) :- H>0, positivos(T1, T2). 

%8
mesmaPosicao(X, [X|_],[X|_]).
mesmaPosicao(X, [_|T1], [_|T2]) :- mesmaPosicao(X, T1, T2).

%9 
comissao(0,_,[]).
comissao(NP,[H|T],[H|T1]) :- 
	NP>0,
	N1 is NP-1,
	comissao(N1, T, T1).
comissao(NP,[_|T],T1) :- 
	NP>0,
	comissao(NP,T,T1).

%10
azulejos(NA,NQ) :- azulejos_aux(NA,AUX), length(AUX,NQ).
azulejos_aux(0,[]).
azulejos_aux(NA,[LADO|T]) :-
	NA > 0,
	sqrt(NA, RAIZ),
	floor(RAIZ, LADO),
	N is NA-LADO^2,
	azulejos_aux(N, T).


