/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolacha;

import java.util.ArrayList;

/**
 *
 * @author Ana
 */
public class Calculo {

    public static void calculaArea(ArrayList<Bolacha> bolachas){
        
        for(Bolacha b : bolachas){
            switch(b.getFormato()){
                case 1: 
                    b.setArea((Math.pow(b.getLado(),2)*Math.cbrt(3))/4);
                    break;
                case 2:
                    b.setArea(Math.PI*b.getRaio()*b.getRaio());
                    break;
                case 3:
                    b.setArea(b.getLado()*b.getLado2());
                    break;
            }
        }
    }
    
    public static Bolacha buscaMaiorBolacha(ArrayList<Bolacha> bolachas){
       
        Bolacha maiorArea = bolachas.get(0);
        Bolacha b;
        
        for(int i=1 ; i<bolachas.size(); i++){
            b = bolachas.get(i);
            if(b.getArea() > maiorArea.getArea()){
                maiorArea = b;
            }
        }
        return maiorArea;
    }
    
}
