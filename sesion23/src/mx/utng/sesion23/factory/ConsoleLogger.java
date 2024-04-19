package mx.utng.sesion23.factory;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ConsoleLogger implements Logger {
    @Override//Se soobreescribe el método log 
    public void log(String msg) {
        System.out.println(msg);
    }

    
}
