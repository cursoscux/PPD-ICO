package mx.uaemex.gui;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import mx.uaemex.sockets.MyServer;

public class MyServerGUI {

  private JTextField txtServerName;
  private JTextField txtServerMsg;
  private JTextArea txtIncomingMsg;
  
  public MyServerGUI() {
    JFrame ventana = new JFrame("Servidor v2");
    ventana.setSize(320, 240);
    ventana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    ventana.setLayout(new GridLayout(8,1));
    
    JLabel lblServerName = new JLabel("Nombre de servidor");
     txtServerName = new JTextField(15);
    ventana.add(lblServerName);
    ventana.add(txtServerName);
    JLabel lblServerMsg =  new JLabel("Mensaje a enviar:");
     txtServerMsg = new JTextField(15);
    ventana.add(lblServerMsg);
    ventana.add(txtServerMsg);        
    
    JLabel lblIncomingMsg  = new JLabel("Mensaje Entrante:");
    txtIncomingMsg = new JTextArea(10, 15);
    ventana.add(lblIncomingMsg);
    ventana.add(txtIncomingMsg);
    
    JButton btnIniciar = new JButton("Iniciar");
    ventana.add(btnIniciar);
    btnIniciar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        MyServer myServer = new MyServer(txtServerName.getText(), 
                            txtServerMsg.getText(), txtIncomingMsg);
        myServer.start();
      }
    });
    
    JButton btnSalir = new JButton("Salir");
    ventana.add(btnSalir);
    btnSalir.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    
    ventana.setVisible(true);
  }
  
  
  
}
