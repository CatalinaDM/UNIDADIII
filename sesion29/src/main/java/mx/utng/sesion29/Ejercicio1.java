package mx.utng.sesion29;

import java.util.function.Function;

public class Ejercicio1 {

   /*  private final IStringToInteger parser = new IStringToInteger() {
        public Integer convertir(String s){
            return Integer.parseInt(s);
        };
    };
    */
    // private final IStringToInteger parser = s->Integer.parseInt(s); //Es lo mismo que lo que esta comentado arriba

   // private final IStringToInteger parser = Integer::parseInt;//lo mismo que arriba solo que aqui el metodo Integer en return es convetir en vez de apply 

    private final Function<String,Integer> parser=Integer::parseInt;

    Integer sumar (String a, String b){
        return parser.apply(a)+parser.apply(b);
    }
    
}
