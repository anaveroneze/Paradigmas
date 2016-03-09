#ifndef CLIENTES_H_INCLUDED
#define CLIENTES_H_INCLUDED

typedef struct cliente Cliente;

Cliente* lista_insere(Cliente* c, char* nome);

void lista_imprime(Cliente* c);

char* ordenar_nomes (Cliente* c, int i);


#endif // CLIENTES_H_INCLUDED
