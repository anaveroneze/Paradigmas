/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bolacha;

import java.util.Random;

/**
 *
 * @author ana
 */
public class Bolacha extends Ponto{
    
    Random rand = new Random(); 
    
    //1 - Triangulo    2 - Circulo    3 - Retangular
    private double lado, raio, lado2;
    private int formato;
    private double area;
    private double distCentro = rand.nextDouble() + rand.nextInt((int)distCentroMax);
    private String valores;

    public Bolacha(){
        
        area = 0;
        formato = rand.nextInt(3) + 1;
        
        switch (formato) {
            case 1:
                lado = distCentro*2;
                lado2 = raio = 0;
                break;
            case 2:
                raio = distCentro;            
                lado = lado2 = 0;
                break;
            case 3: 
                lado = distCentro*2;
                lado2 = rand.nextDouble() + rand.nextInt((int)distCentroMax)*2;
                raio = 0;
                break;
            default: break;
        }
    }
    
    public Bolacha(double x, double y){
        
        super(x, y);  
        area = 0;
        formato = rand.nextInt(3) + 1;
        
        switch (formato) {
            case 1:
                lado = distCentro*2;
                lado2 = raio = 0;
                break;
            case 2:
                raio = distCentro;            
                lado = lado2 = 0;
                break;
            case 3: 
                lado = distCentro*2;
                lado2 = rand.nextDouble() + rand.nextInt((int)distCentroMax)*2;
                raio = 0;
                break;
            default: break;
        }
    }
    
    public int getFormato(){
        return formato;
    }
    
    public double getRaio(){
        return raio;
    }
    
    public double getLado(){
        return lado;
    }

    public double getLado2(){
        return lado2;
    }    
    
    public void setArea(double area){
        this.area = area;
    }
    
    public double getArea(){
        return area;
    }
    
    public void mostra(){
        valores = String.format("(%.2f ; %.2f) Área: %.2f", getX(), getY(), area);
        System.out.print(valores);

        if(formato == 1){
            System.out.println(" Formato: Triângulo");
        }
        else if(formato == 2){
            System.out.println(" Formato: Circulo");
        }
        else{
            System.out.println(" Formato: Retângulo");
        }       
    }
    
    public String toString(){
        valores = String.format("(%.2f ; %.2f) Formato: %d Lado 1: %.2f Lado 2: %.2f Raio: %.2f Área: %.2f", getX(), getY(),formato, lado, lado2, raio, area);
        return valores + "\n";
    }
    
}
