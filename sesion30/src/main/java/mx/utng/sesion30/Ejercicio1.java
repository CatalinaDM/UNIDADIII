package mx.utng.sesion30;

import java.util.List;
import java.util.function.IntUnaryOperator;

public class Ejercicio1 {
 //Método manipular 
 //¿Qué debuelve este metodo ? Un entero por el "Integer"
 Integer manipular(List<Integer>conjunto,IntUnaryOperator transformacion){//Iterable es el parametro que le pasas y permite que vaya recorriendose por si mismo o sea como una lista. o sea pasar por cada uno de sus elementos
    return conjunto.stream().mapToInt(s->s).map(transformacion).sum();
 }
}
