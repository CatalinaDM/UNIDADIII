package mx.utng.sesion23.factory;

public class LoggerFactory {
    public Logger getLogger(int type){
        if(type==1){
            return new FileLogger();
        }else if(type==2){
            return new ConsoleLogger();
        }else{
            System.out.println("Opción no valida,por defecto será consola");
            return new ConsoleLogger();
        }
    }
    
}
