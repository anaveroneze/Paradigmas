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
public class Ponto {
    
    private double x, y;
    protected final double distCentroMax = Math.sqrt(InsereForma.getTamanho()/50)/2;
    
    public Ponto(){
        x = distCentroMax;
        y = distCentroMax;
    }
        
    public Ponto(double x, double y){

        if((x+3*distCentroMax) <= InsereForma.getLarg()){
            this.x = x + 2*distCentroMax;
            this.y = y;
        }
        else{
            setX();
            setY(y);
        }        
    }
    
    public double getX(){
        return x;
    }
    
    public double getY(){
        return y;
    }
    
    public void setX(){
        x = distCentroMax;
    }
    
    public void setY(double y){
        this.y = y + 2*distCentroMax;
    }
}
