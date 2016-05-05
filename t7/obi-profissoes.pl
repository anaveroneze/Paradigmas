/*
	http://olimpiada.ic.unicamp.br/pdf/provas/ProvaOBI2013_inic_f2n2.pdf
	
	Feira de Profissões:

	A escola está organizando uma Feira de Profissões, em que seis profissionais – um geólogo, um
	médico, uma jornalista, um químico, uma psicóloga e um sociólogo – darão palestras para os alunos
	sobre suas respectivas profissões.
	Duas palestras serão na segunda-feira, duas na terça-feira, e duas na quarta-feira. 
	As seguintes restrições devem ser obedecidas:
	• A palestra do químico deve ser no mesmo dia em que a da psicóloga.
	• O geólogo não pode dar a sua palestra no mesmo dia em que o médico.
	• Se a palestra da jornalista for na segunda-feira, a palestra do geólogo deve ser na terça-feira.
	• Se a palestra do sociólogo for na quarta-feira, a palestra do médico deve ser na terça-feira.
*/

	%cronograma: [segunda,segunda,terça,terça,quarta,quarta]

dia_semana(0,segunda).
dia_semana(1,segunda).
dia_semana(2,terça).
dia_semana(3,terça).
dia_semana(4,quarta).
dia_semana(5,quarta).

%regra1
regra1(FP) :-
	nth0(P1,FP,q),
	nth0(P2,FP,p),
	dia_semana(P1,D1),
	dia_semana(P2,D2),
	D1 == D2.

%regra2
regra2(FP) :-
	nth0(P1,FP,m),
	nth0(P2,FP,g),
	dia_semana(P1,D1),
	dia_semana(P2,D2),
	D1 \= D2.

%regra3
regra3(FP) :-
	(nth0(P1,FP,j), dia_semana(P1,segunda),
	nth0(P2,FP, g), dia_semana(P2,terça));
	(nth0(P,FP,j), P=\=0, P=\=1).

%regra4
regra4(FP) :-
	(nth0(P1,FP,s), dia_semana(P1,quarta),
	nth0(P2,FP, m), dia_semana(P2,terça));
	(nth0(P,FP,s), P=\=4, P=\=5).

profissoes(FP) :-
	FP = [_,_,_,_,_,_],
	Prof = [m,j,q,p,s,g],
	permutation(Prof,FP),
	regra1(FP),
	regra2(FP),
	regra3(FP),
	regra4(FP).


questao3(Prof,D) :-
	profissoes(L),
	nth0(P1,L,p),
	dia_semana(P1,terça),
	nth0(P2,L,Prof),
	dia_semana(P2,D).

questao5(Ant,Post, Prof, Dia) :-
	profissoes(L),
	nth0(P1,L,Ant), nth0(P2,L,Post),
	P is P2-P1,
	P =< 3, P2>P1,
	dia_semana(P1,D1), dia_semana(P2,D2),
	D1 \= D2,
	nth0(Pos,L,Prof),
	dia_semana(Pos,Dia).


/*
	Questão 1:
	?-profissoes([g,q,m,p,j,s]).
	?-profissoes([g,j,q,p,m,s]).
	?-profissoes([j,s,g,m,q,p]).
	?-profissoes([q,p,g,j,m,s]).
	?-profissoes([q,p,m,j,g,s]).
	

	Questão 3:
	?-questao3(g,segunda).
	?-questao3(j,segunda).
	?-questao3(q,segunda).
	?-questao3(m,terça).
	?-questao3(s,quarta).


	Questão 5: 
	(retorna false para a alternativa correta)
	?- questao5(m,s,m,segunda).
	?- questao5(m,s,j,segunda).
	?- questao5(m,s,g,terça).
	?- questao5(m,s,p,terça).
	?- questao5(m,s,p,quarta).

*/

