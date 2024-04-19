package mx.utng.sesion19;
import java.util.Scanner;

import javax.swing.plaf.synth.SynthSliderUI;

public class IntegerToBinary {
    public static void main (String[] args){

        int numero = 40; 
        String binario = Integer.toBinaryString(numero);
        System.out.printf("El numero %d es en binario %s:",numero,binario);
//Ejemplo 2: 

        Scanner salida = new Scanner (System.in);
        int numero1= netxInt(); 
        System.out.println("Ingresa un numero");
        String binario1 = Integer.toBinaryString(numero1);
        System.out.printf("El numero %d es en binario %s:",numero1,binario1);
    }
    
}
