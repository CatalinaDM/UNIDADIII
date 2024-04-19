package mx.utng.sesion27.reto01;

import java.util.concurrent.TimeUnit;

public class Hilo2  extends Thread{

    @Override
    public void run() {
        super.run();
        while(true){
            System.out.println("Hilo 2: Sigo en ejecución");
            try {
                TimeUnit.MILLISECONDS.sleep(500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            };
        }
    }
    
}
