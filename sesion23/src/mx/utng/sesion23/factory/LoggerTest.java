package mx.utng.sesion23.factory;

import java.util.Scanner;

public class LoggerTest {
    public static void main(String[] args){
        //Declarar un objeto Logger
     LoggerFactory factory= new LoggerFactory();
        //El usuario teclara el tipo.
        Scanner scanner = new Scanner(System.in);
        System.out.println("Teclea el tipo de Logger: ");
        int type = scanner.nextInt();
        scanner.close();
        //Crear el logger elegido por el usuario
        Logger logger = factory.getLogger(type);
        logger.log("Registros del sistema");

    }
    
}
