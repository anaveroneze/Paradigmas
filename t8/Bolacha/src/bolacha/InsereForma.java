/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolacha;

import java.util.ArrayList;

/**
 *
 * @author ana
 */
public class InsereForma {
    
    private int cont = 1;
    private int numBolachas;
    private static int alt, larg;
    private static int tam;
    private Bolacha b;
    
    public InsereForma(){
        numBolachas = 0;
        alt = larg = 0;
        tam = 0;
    }
    
    ArrayList <Bolacha> bolachas = new ArrayList <Bolacha>(); 
            
    public void insere(){
        //Cria a primeira bolacha
        bolachas.add(new Bolacha());
        //Cria as demais bolachas
        while(cont < numBolachas){
            b = bolachas.get(cont-1);
            bolachas.add(new Bolacha(b.getX(), b.getY()));
            cont++;
        }
        
        Calculo.calculaArea(bolachas);
        
        b = Calculo.buscaMaiorBolacha(bolachas);
        System.out.println("Maior bolacha:");
        b.mostra();
        /*
        Imprime forma com bolachas e seus atributos:
        System.out.println(bolachas);        
        */
    }
    
    public void quantidade(int numBolachas){
        this.numBolachas = numBolachas;
    }
    
    public void tamanho(int larg, int alt){
        InsereForma.larg = larg;
        InsereForma.alt = alt;
        tam = larg*alt;
    }
    
    public static int getAlt(){
        return alt;
    }
    
    public static int getLarg(){
        return larg;
    }

    public static int getTamanho() {
        return tam;
    }
}
