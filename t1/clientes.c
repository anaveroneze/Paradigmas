#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "clientes.h"

struct cliente{
    char* nome;
    struct cliente* prox;
};

Cliente* lista_insere(Cliente* c, char* nome){

    Cliente* novo = (Cliente*)malloc(sizeof(Cliente));
    int tamString = strlen(nome) + 1;

    novo->nome = malloc(tamString * sizeof(char));
    strcpy(novo->nome, nome);
    novo->prox = c;
    c = novo;

    return novo;
}

void lista_imprime(Cliente* c){

    while(c != NULL){
        Cliente* aux = c->prox;
        puts(c->nome);
        c = aux;
    }
}

static int compara (const void *a, const void *b) {

   return strcmp (*(char **)a, *(char **)b);
}

char* ordenar_nomes(Cliente* c, int numNomes){

    int i = 0;
    char** nomes;

    nomes = malloc(numNomes*sizeof(char*));

    while(c != NULL){
        nomes[i] = malloc((strlen(c->nome)+1)*sizeof(char));
        strcpy(nomes[i++], c->nome);
        c = c->prox;
    }

    qsort(nomes, i , sizeof(char*), compara);

    return nomes;
}
