package mx.uaemex.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import mx.uaemex.threads.Alarma_Thread;
import mx.uaemex.threads.Reloj_Thread;

public class Reloj_GUI extends JFrame{

  public Reloj_GUI() {
    setSize(520, 200);
    setTitle("Reloj Internacional");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    setLayout(new FlowLayout());
    
    //**************** Reloj MX        
    JTextField txtHoraMexico = new JTextField(15);
    add(txtHoraMexico);
    
    
    JLabel paisMX = new JLabel(new ImageIcon("mx.png"));    
    add(paisMX);
    
    Alarma_Thread relojMX = new Alarma_Thread(txtHoraMexico, "MX");
    
    JButton btnIniciaRelojMX = new JButton("Iniciar");
    btnIniciaRelojMX.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        relojMX.start();
      }
    });
    add(btnIniciaRelojMX);
        
    JButton btnDetenerRelojMX = new JButton("Detener");
    btnDetenerRelojMX.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        relojMX.stopThread();
      }
    });
    add(btnDetenerRelojMX);
    
    JButton btnAgregaAlarma = new JButton("Alarma");
    btnAgregaAlarma.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        String strHora = JOptionPane.showInputDialog("¿Hora de la alarma?");
        String strMsg = JOptionPane.showInputDialog("¿Mensaje a mostrar?");
        relojMX.addAlarma(strHora, strMsg);
      }
    });
    add(btnAgregaAlarma);
    
    
    //************ Reloj BR
    JTextField txtHoraBrasil = new JTextField(15);
    add(txtHoraBrasil);
    
    JLabel paisBR = new JLabel(new ImageIcon("br.png"));    
    add(paisBR);
    
    Reloj_Thread relojBR = new Reloj_Thread(txtHoraBrasil, "BR");
    
    JButton btnIniciaRelojBR = new JButton("Iniciar");
    btnIniciaRelojBR.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        relojBR.start();
      }
    });
    add(btnIniciaRelojBR);
        
    JButton btnDetenerRelojBR = new JButton("Detener");
    btnDetenerRelojBR.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        relojBR.stopThread();
      }
    });
    add(btnDetenerRelojBR);
     
    //************ Reloj TK
    JTextField txtHoraTokio = new JTextField(15);
    add(txtHoraTokio);
    
    JLabel paisTK = new JLabel(new ImageIcon("tk.png"));    
    add(paisTK);
    
    Reloj_Thread relojTK = new Reloj_Thread(txtHoraTokio, "TK");
    
    JButton btnIniciaRelojTK = new JButton("Iniciar");
    btnIniciaRelojTK.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        relojTK.start();
      }
    });
    add(btnIniciaRelojTK);
        
    JButton btnDetenerRelojTK = new JButton("Detener");
    btnDetenerRelojTK.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        relojTK.stopThread();
      }
    });
    add(btnDetenerRelojTK);
    
    setVisible(true);
  }
  
}
