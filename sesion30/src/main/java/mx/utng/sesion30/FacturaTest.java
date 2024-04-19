package mx.utng.sesion30;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FacturaTest {
    public static void main(String[] args) {
        
        Factura f1 = new Factura ("Computadora", 10000);
        Factura f2 = new Factura("Telefono", 5000); 
        Factura f3 = new Factura("Impresora", 4000); 
        Factura f4 = new Factura("TV", 8000); 
        
        List<Factura> facturas = new ArrayList<>();
        facturas.add(f1);
        facturas.add(f2);
        facturas.add(f3);
        facturas.add(f4);
        
        Factura fo = null; 
        for (Factura factura : facturas) {//foreach nos sirve para ir recorriendo una lista o algo iterable
            if(factura.getImporte()==5000){
                 fo= factura;
                 break; 
            }
        }
        System.out.println(""+fo.getConcepto()+","+fo.getImporte());

//OTRA MANERA DE HACER LO DE ARRIBA


long x = facturas.stream().filter(s->s.getImporte()>4000).count(); 
System.out.println(x);

//otra

//Optional<Long> tt = facturas.stream().map(Factura::getImporte()).findAny(); 
//System.out.println(tt);


//Otra

//long x = facturas.stream().filter(s->s.getImporte()>4000).toList(); 


    }
}
