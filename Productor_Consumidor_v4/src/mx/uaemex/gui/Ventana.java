package mx.uaemex.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import mx.uaemex.shared.Comal;
import mx.uaemex.threads.Consumidor;
import mx.uaemex.threads.Productor;

public class Ventana extends JFrame{

  public Ventana() {
    setSize(550, 250);
    setTitle("Productor-Consumidor v4.0");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    
    
    JPanel panelHeaders = new JPanel();
    panelHeaders.add(new JLabel("Productor:"));
    panelHeaders.add(new JLabel("Consumidor:"));
    add(panelHeaders, BorderLayout.NORTH);
    
    JPanel panelListas = new JPanel();
    DefaultListModel modeloProductor = new DefaultListModel();
    JList listProductor = new JList(modeloProductor);
    JScrollPane pScrollP = new JScrollPane();
    pScrollP.setViewportView(listProductor);
    panelListas.add(pScrollP);
    DefaultListModel modeloConsumidor = new DefaultListModel(); 
    JList listConsumidor = new JList(modeloConsumidor);
    JScrollPane pScrollC = new JScrollPane();
    pScrollC.setViewportView(listConsumidor);
    panelListas.add(pScrollC);
    add(panelListas, BorderLayout.CENTER);
        
    Comal comal = new Comal();
    Productor productor = new Productor(comal, modeloProductor);
    Consumidor consumidor = new Consumidor(comal, modeloConsumidor, modeloProductor);
    
    JPanel panelBotones = new JPanel();
    JButton btnIniciar = new JButton("Iniciar");
    btnIniciar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        productor.start();
        consumidor.start();
      }
    });
    panelBotones.add(btnIniciar);
    JButton btnDetener = new JButton("Detener");
    btnDetener.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        productor.stopThread();
        consumidor.stopThread();
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
