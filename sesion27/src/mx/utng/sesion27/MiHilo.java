package mx.utng.sesion27;

import java.util.concurrent.TimeUnit;

public class MiHilo extends Thread  {//MiHilo hereda a la Thread
    private String parametro;

    public void setParametro(String parametro) {
        this.parametro = parametro;
    }
  @Override
  public void run(){
    while (!"terminar".equals(parametro)) {
     mostrarInfo();
        pausarUnSegundo();
    }
   /*//System.out.println(getName()+"En ejecución"+ isDaemon());
    try {//MANEJO DE EXEPCIONES //CONTINUA CON ERRORES SI OCURREN Y SE VA A CATCH DONDE PUEDES DAR AVISO PERO NO SE CORTA EL PROGRAMA  
        //Trata de hacerlo aqui si no funciona vete a CATCH 
        TimeUnit.SECONDS.sleep(1);
    } catch (InterruptedException e) {
        
        e.printStackTrace();//iMPRIMES EL ERROR EN CONSOLA 
    }finally{
        System.out.println("Veces: "+(++count));
    }
    * 
    */
  }  
    private void mostrarInfo(){
       String tipoHilo = isDaemon()?"Daemon":"Usuario";
    System.out.println("Tipo de hilo:"+"\t| Nombre:"+getName()+"\t| ID:"+getId()+"\t|");
    }

    public static void pausarUnSegundo(){
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
           
            e.printStackTrace();
        }
    } 
}
