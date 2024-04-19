package mx.utng.sesion30;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.assertj.core.api.Assertions;

public class Ejercicio1Tests {
    //Métdo 
    @Test @DisplayName("Prueba para transformar y sumar")
    void transformarYSumar(){

        Ejercicio1 e1 = new Ejercicio1(); 

        List<Integer>conjunto = Arrays.asList(1,4,-6,7,3,5,-1);

        Integer expected = -27;

        Assertions.assertThat(e1.manipular(conjunto, i->i<0? i:-i)).isEqualTo(expected);


    }

}
