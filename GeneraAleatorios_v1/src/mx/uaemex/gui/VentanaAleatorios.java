package mx.uaemex.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.text.DefaultCaret;
import mx.uaemex.threads.GeneraAleatorioThread;

public class VentanaAleatorios extends JFrame{

  public VentanaAleatorios() {
    setSize(600, 400);
    setTitle("Generador de Aleatorios v1.0");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    JPanel panelDatos = new JPanel();
    JTextArea txtInfo = new JTextArea(10, 30);
    DefaultCaret caret = (DefaultCaret)txtInfo.getCaret();
    caret.setUpdatePolicy(DefaultCaret.OUT_BOTTOM);
    JScrollPane panelScroll = new JScrollPane(txtInfo);
    panelDatos.add(panelScroll);
    add(panelDatos, BorderLayout.CENTER);
    JPanel panelBotones = new JPanel();
    JButton btnIniciar = new JButton("Iniciar");
    GeneraAleatorioThread hilos[] = new GeneraAleatorioThread[100];
    for (int i = 0; i < hilos.length; i++) {
      hilos[i] = new GeneraAleatorioThread("Hilo " + i, txtInfo);      
    }
    
    btnIniciar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < hilos.length; i++) {
          hilos[i].start();
        }
      }
    });
    panelBotones.add(btnIniciar);
    JButton btnDetener = new JButton("Detener");
    btnDetener.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < hilos.length; i++) {
          hilos[i].stopThread();
        }
      }
    });
    panelBotones.add(btnDetener);
    JButton btnSalir = new JButton("Salir");
    btnSalir.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    panelBotones.add(btnSalir);
    add(panelBotones, BorderLayout.SOUTH);
    setVisible(true);
  }
  
}
