package mx.utng.sesion27.reto01;

import java.util.concurrent.TimeUnit;

public class Hilo1 extends Thread {

@Override
public void run(){
    super.run(); //Método de ejecución
    for (int i = 0; i <=10; i++) {
        System.out.println("Hilo 1: "+i);
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}

    
}
