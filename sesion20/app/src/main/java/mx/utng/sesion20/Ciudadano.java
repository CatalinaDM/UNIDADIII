package mx.utng.sesion20;

public class Ciudadano {
    public static void main(String[] args) {
    
        Gobierno gobierno = Gobierno.getInstancia();
       gobierno.darApoyo();
    
       Gobierno pseudoOtro = Gobierno.getInstancia();
       pseudoOtro.darApoyo();
       
        // Gobierno.getInstancia().darApoyo();//Mandando a llamar la instancia de class Gobierno
}
}

