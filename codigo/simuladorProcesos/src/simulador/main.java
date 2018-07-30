/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simulador;

import java.util.Random;

/**
 *
 * @author litosoler
 */
public class main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random aleatorio = new Random();
  
        for (int i = 0; i < 10; i++) {
            Proceso proceso = new Proceso();
            System.out.println(proceso+";");
            
        }
    }
    
}
