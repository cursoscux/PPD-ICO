
package mx.uaemex.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import mx.uaemex.threads.Hilo;

public class Hilo_GUI extends JFrame{

  public Hilo_GUI() {
    setSize(280, 200);
    setTitle("Hilos Aleatorios v2.0");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    
    JLabel lblHilo = new JLabel("Hilo Ejecutandose: ");
    add(lblHilo);
    
    JTextField txtHilo = new JTextField(15);
    add(txtHilo);
    
    Hilo hilos[] = new Hilo[100];
    for (int i = 0; i < hilos.length; i++) {
      hilos[i] = new Hilo("Hilo " + (i + 1), txtHilo);      
    }
    
    JButton btnIniciarHilo = new JButton("Iniciar");
    add(btnIniciarHilo);
    btnIniciarHilo.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < hilos.length; i++) {
          hilos[i].start();
        }
      }
    });
    
    JButton btnDetenerHilo = new JButton("Detener");
    add(btnDetenerHilo);
    btnDetenerHilo.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < hilos.length; i++) {
          hilos[i].stopHilo_01();
        }
      }
    });
    
    setVisible(true);
  }
  
}
