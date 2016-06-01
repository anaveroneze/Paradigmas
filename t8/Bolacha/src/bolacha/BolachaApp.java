/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolacha;

/**
 *
 * @author ana
 */
public class BolachaApp {

    public static void main(String[] args) {
        
        InsereForma forma = new InsereForma();
        
        forma.tamanho(75,45);
        forma.quantidade(50);
        forma.insere();
    }
    
}
