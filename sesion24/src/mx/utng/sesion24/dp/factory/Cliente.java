package mx.utng.sesion24.dp.factory;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

 //Declaro una clase que  crea JFrame (ventana básica)
public class Cliente extends JFrame {

    //Declaro dos elementos de formulario
    private JTextField txtUsuario;
    private JPasswordField txtPassword;

    //Creando los elementos de incio de la ventana
    public Cliente(){
        //Llamo al construcotr de JFrame colocandole un titulo 
        super("Login");

        //Pongo una operación de cierre en el boton x
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        //COLOCO LAS DIMENSIONES DE ANCHO Y ALTO

        setSize(300,150);

        //Defino un contenedor de elementos visuales
        JPanel panel=new JPanel();

        //Al panel le doy un diseño
        panel.setLayout(new GridLayout(3,2));

        //Etiqueta para el usuario 
        JLabel lbUsuario= new JLabel("Usuario: ");

        //Etiqueta para el password
        JLabel lblPassword = new JLabel ("Password: ");

        //Creamos las cajas de texto
        txtUsuario = new JTextField();
        txtPassword = new JPasswordField();

        //Creamos un boton
        JButton btnLogin= new JButton("Login");

        //Colocamos accion al boton
        btnLogin.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               
                String usuario = txtUsuario.getText();
                char[] caraPassword= txtPassword.getPassword();
                String password = new String(caraPassword);

             if  ( validarLogin(usuario, password)){
                JOptionPane.showMessageDialog(Cliente.this, "Inicio de sesion correcto","Validacion",JOptionPane.INFORMATION_MESSAGE);
             }
                else{
                    JOptionPane.showMessageDialog(Cliente.this, "Inicio de sesion incorrecto");
                }
             

                System.out.println("Usuario: "+usuario+" ,Password: "+password);
            }
        });

        //Añadir los elementos visuales al contenedor 

        panel.add(lbUsuario);
        panel.add(txtUsuario);
        panel.add(lblPassword);
        panel.add(txtPassword);
        panel.add(btnLogin);

        //Agregando a la ventana en el panel 
        add(panel);
        //Hacemos visible a la ventana
        setVisible(true);

        //Centrar la ventana
        setLocationRelativeTo(null);
         
    }
    
    public static void main(String [] args) {
        new Cliente();

    }

    //Método privado para validar usuario y contraseña que no sean iguales
    private boolean validarLogin(String usuario, String password){
        return usuario.equals("utng") && password.equals("xyz123");

    }
}
