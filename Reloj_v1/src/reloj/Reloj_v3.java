package reloj;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class Reloj_v3 {

  Boolean estaCorriendo = true;

  public Reloj_v3() {
    JFrame ventana = new JFrame("Reloj v3.0");
    ventana.setSize(300, 200);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setLayout(new FlowLayout());

    JLabel lblHora = new JLabel("Hora:");
    ventana.add(lblHora);
    JTextField txtHora = new JTextField(10);
    ventana.add(txtHora);
    JButton btnIniciaReloj = new JButton("Iniciar");
    ventana.add(btnIniciaReloj);

    Thread miHilo = new Thread(new Runnable() {
      @Override
      public void run() {
        while (estaCorriendo) {
          Calendar cal = Calendar.getInstance();
          Date date = cal.getTime();
          DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
          String strDate = dateFormat.format(date);
          System.out.println("Hora: " + strDate);
          txtHora.setText(strDate);
          try {
            Thread.sleep(1000);
          } catch (InterruptedException ex) {
            //TODO something...
          }
        }
      }
    });

    btnIniciaReloj.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {

        miHilo.start();
      }
    });

    JButton btnDetenerReloj = new JButton("Detener");
    ventana.add(btnDetenerReloj);
    btnDetenerReloj.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        //miHilo.stop();
        estaCorriendo = false;
      }
    });

    ventana.setVisible(true);
  }

  public static void main(String[] args) {
    //Reloj_v3 miInstancia = new Reloj_v3();
    new Reloj_v3();
  }
}
