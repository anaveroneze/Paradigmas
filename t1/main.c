#include <stdio.h>
#include <stdlib.h>
#include <string.h>

#include "clientes.h"
#define MAX 1024

int main()
{
    FILE* ARQ;

    ARQ = fopen("Clientes QueroXis.txt", "r");

    if(ARQ == NULL){
        printf("Erro ao abrir o arquivo.");
    }
    else{

        Cliente* clientesNomeR = NULL;
        char clienteNome[MAX];
        int i = 0;
        int j;

        while(fgets(clienteNome, MAX, ARQ)){
            if(clienteNome[0] == 'R'){
                clientesNomeR = lista_insere(clientesNomeR, clienteNome);
                i++;
            }
        }
        fclose(ARQ);

        ARQ = fopen("Clientes premiadas.html", "w");

        if(ARQ == NULL){
            printf("Erro ao escrever o arquivo.");
        }
        else{

            if(clientesNomeR == NULL){
                fprintf(ARQ, "Nao houveram clientes premiadas.");
            }
            else{
                char** clientesNomesOrd = ordenar_nomes(clientesNomeR, i);

                for(j=0; j<i; j++){
                    fprintf(ARQ, "%d - %s <br>", (j+1), clientesNomesOrd[j]);
                }
            }
            fclose(ARQ);
        }

    }
    return 0;
}
