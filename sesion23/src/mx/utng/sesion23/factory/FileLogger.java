package mx.utng.sesion23.factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class FileLogger implements Logger {
  
    @Override//Se soobreescribe el método log 
    public void log(String msg) {
        try {//Se utilizan para manenejar ejecutar en el try se intenta ejecutar todo pero si hay errores se ejecuta el catch
            BufferedWriter writer = new BufferedWriter (new FileWriter("log.txt"));
            writer.write(msg);
            writer.close();
        } catch (IOException e) {
          System.out.println("Error de I/O");
        }
      
        
    }
}
