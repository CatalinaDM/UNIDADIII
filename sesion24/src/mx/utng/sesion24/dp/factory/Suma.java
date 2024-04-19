package mx.utng.sesion24.dp.factory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


 //Declaro una clase que  crea JFrame (ventana básica)
public class Suma extends JFrame {

    //Declaro dos elementos de formulario
    private JTextField txtNumero1;
    private JTextField txtNumero2;
    private JLabel resultLabel;

    //Creando los elementos de incio de la ventana
    public Suma(){
        //Llamo al construcotr de JFrame colocandole un titulo 
        super("SUMA DE DOS NÚMEROS");

        //Pongo una operación de cierre en el boton x
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //COLOCO LAS DIMENSIONES DE ANCHO Y ALTO

        setSize(300,150);

        //Defino un contenedor de elementos visuales
        JPanel panel=new JPanel();

        //Al panel le doy un diseño
        panel.setLayout(new GridLayout(3,2));

        //Etiqueta para el usuario 
        JLabel lbNumero1= new JLabel("Numero1: ");

        //Etiqueta para el password
        JLabel lblNumero2 = new JLabel ("Numero2: ");

        //Creamos las cajas de texto
        txtNumero1= new JTextField();
        txtNumero2 = new JTextField();
        resultLabel= new JLabel();

        //Creamos un boton
        JButton btnComiezo= new JButton("Calcular");

        //Colocamos accion al boton
        btnComiezo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
double numero1,numero2;
                try {
                    numero1 = Double.parseDouble(txtNumero1.getText());
                    numero2 = Double.parseDouble(txtNumero2.getText());
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(Suma.this, "Solo se aceptan valores numéricos", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método actionPerformed si los valores no son numéricos
                }
                
                if (!validarNumeros(numero1, numero2)) {
                    JOptionPane.showMessageDialog(Suma.this, "Los parámetros deben ser valores numéricos.", "Error", JOptionPane.ERROR_MESSAGE);
                    return; // Salir del método actionPerformed si la validación falla
                }
                else{
                    JOptionPane.showMessageDialog(Suma.this, "Ejecución correcta");
                }
        
                // Calcular el resultado
                double resultado = numero1 + numero2;
        
                // Actualizar el texto del JLabel con el resultado
                resultLabel.setText("Resultado: " + resultado);
        
                System.out.println("Numero 1: " + numero1 + ", Numero 2: " + numero2);
            
                    }
        });

        //Añadir los elementos visuales al contenedor 

        panel.add(lbNumero1);
        panel.add(txtNumero1);
        panel.add(lblNumero2);
        panel.add(txtNumero2);
        panel.add(btnComiezo);
        panel.add(resultLabel);

        //Agregando a la ventana en el panel 
        add(panel);
        //Hacemos visible a la ventana
        setVisible(true);

        //Centrar la ventana
        setLocationRelativeTo(null);
         
    }
    
    public static void main(String [] args) {
        new Suma();

    }

    private boolean validarNumeros(double numero1, double numero2) {
        if (Double.isNaN(numero1) || Double.isNaN(numero2)) {
            System.out.println("Los parámetros deben ser valores numéricos.");
            return false; 
        }
        return true;
}
}

    

