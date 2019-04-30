package mx.uaemex.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import mx.uaemex.sockets.MyServer;

public class MyServerGUI {

  private JTextPane txtLogServer;
  private JTextField txtNombreServer;
  
  public MyServerGUI() {
    JFrame ventana = new JFrame("Servidor v2.0");
    ventana.setSize(320, 240);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    //Panel superior
    JPanel panelSuperior = new JPanel();
    JLabel lblNombreServer = new JLabel("Nombre del servidor:");
    panelSuperior.add(lblNombreServer);
    txtNombreServer = new JTextField(10);
    panelSuperior.add(txtNombreServer);
    ventana.add(panelSuperior, BorderLayout.NORTH);
    
    //Panel Central
    JPanel panelCentral = new JPanel(new BorderLayout());
    JLabel lblLogServer = new JLabel("Registro/Actividad:");
    panelCentral.add(lblLogServer, BorderLayout.NORTH);
    txtLogServer = new JTextPane();
    txtLogServer.setPreferredSize(new Dimension(200, 100));
    JScrollPane scrollLog = new JScrollPane(txtLogServer);
    scrollLog.setSize(200, 100);
    panelCentral.add(scrollLog, BorderLayout.CENTER);
    ventana.add(panelCentral, BorderLayout.CENTER);
    
    //Panel Inferior
    JPanel panelInferior = new JPanel();
    JButton btnIniciarServer = new JButton("Iniciar");
    panelInferior.add(btnIniciarServer);
    btnIniciarServer.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MyServer myServer = new MyServer(txtLogServer, txtNombreServer.getText());
        myServer.start();
      }
    });
    JButton btnSalir = new JButton("Salir");
    panelInferior.add(btnSalir);
    btnSalir.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    ventana.add(panelInferior, BorderLayout.SOUTH);
    
    ventana.setVisible(true);
  }
  
}
