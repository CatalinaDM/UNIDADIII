package mx.utng.sesion27.reto01;

public class RetoTest {
    public static void main(String[] args) {
        Hilo1 h1 = new Hilo1();
        Hilo2 h2 = new Hilo2();
        h2.setDaemon(true); //Daemon son procesos que se ejecutan en segundo plano CONTINUAMENTE
        h1.start();
        h2.start();
    

    }
    
}
