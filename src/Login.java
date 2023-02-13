import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

public class Login extends JDialog {
    private JPanel login;
    private JButton ingresarButton;
    private JComboBox comboBox1;
    private JTextField txtUsuario;
    private JPasswordField passwordField1;
    private JLabel Modo_Sesion;
    private JLabel imagen;

    int index = 0;
    String imgs[] = {
            "Imagenes/admin.png",
            "Imagenes/cajero.png",
            "",
    };
    public Login() {
        inicio();
        JFrame validacion = new JFrame("ventana-emergente");
        validacion.setSize(150, 150);
        validacion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        validacion.setLayout(new BorderLayout());

        comboBox1.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                index = comboBox1.getSelectedIndex();
                inicio();
            }
        });
        ingresarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String usuarioAdmin = "admin";
                String contraseñaAdmin = "admin";

                String usuarioCliente = "1751354422";
                String contraseñaCliente = "cliente";

                String usuario = txtUsuario.getText();
                char[] contraseña = passwordField1.getPassword();

                if (index == 0) {
                    Modo_Sesion.setText("Administrativo:");
                    if (usuarioAdmin.equals(usuario) && contraseñaAdmin.equals(new String(contraseña))) {
                        JOptionPane.showMessageDialog(validacion, "Haz iniciado sesion como Administrador");
                    }  else {
                            JOptionPane.showMessageDialog(validacion, "Usuario o contraseña incorrectos");
                    }

                } else {
                    Modo_Sesion.setText("Cédula:");
                    if (usuarioCliente.equals(usuario) && contraseñaCliente.equals(new String(contraseña))) {
                        JOptionPane.showMessageDialog(validacion, "Haz iniciado sesion como Cliente");
                    } else {
                        JOptionPane.showMessageDialog(validacion, "Usuario o contraseña incorrectos");
                    }
                }

            }
        });
    }

    public void inicio(){
        Image img = Toolkit.getDefaultToolkit().getImage(getClass().getResource(imgs[index]));
        if (index == 0) {
            Modo_Sesion.setText("Administrativo:");
            imagen.setIcon(new ImageIcon(img));
        } else {
            Modo_Sesion.setText("Cédula:");
            imagen.setIcon(new ImageIcon(img));
        }
    }


    public static void main(String[] args) {
        JFrame milogin = new JFrame("Login");
        milogin.setContentPane(new Login().login);
        milogin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        milogin.pack();
        //milogin.dispose();
        milogin.setVisible(true);

    }
}
