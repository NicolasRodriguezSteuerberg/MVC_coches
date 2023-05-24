import javax.swing.*;

public class Dialog extends JDialog{
    private JPanel panel1;
    private JLabel eVelocidad;

    public Dialog(){
        setContentPane(panel1);
        setModal(true);
        setDefaultCloseOperation(HIDE_ON_CLOSE);
    }

    public static void vDialogo(String mensajito){
        Dialog dialogo = new Dialog();
        dialogo.pack();
        dialogo.eVelocidad.setText(mensajito);
        dialogo.setVisible(true);
    }
}
