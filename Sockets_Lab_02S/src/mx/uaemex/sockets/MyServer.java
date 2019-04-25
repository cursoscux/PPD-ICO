package mx.uaemex.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextPane;

public class MyServer extends Thread{

  private JTextPane txtPanelLog;
  private String serverName;
  
  public MyServer(JTextPane txtPanelLog, String serverName) {
    this.txtPanelLog = txtPanelLog;
    this.serverName = serverName;
  }

  @Override
  public void run() {
    super.run(); 
    ServerSocket serverSocket = null;
    OutputStream outputStream = null;
    InputStream inputStream = null;
    try {
      serverSocket = new ServerSocket(1600);
      txtPanelLog.setText("Servidor escuchando en puerto 1600...");
      System.out.println("Servidor escuchando en puerto 1600...");
      Socket socket =  serverSocket.accept();
      String remoteUser = socket.getRemoteSocketAddress().toString();
      txtPanelLog.setText(txtPanelLog.getText() + "\n" + 
              "Conexión recibida de " + remoteUser);
      System.out.println("Conexión recibida de " + remoteUser);
      outputStream = socket.getOutputStream();
      String msj = "Bienvenido al servidor " + serverName;
      outputStream.write(msj.getBytes());
      outputStream.flush();
      inputStream = socket.getInputStream();
      byte[] datos = new byte[1024];
      inputStream.read(datos);
      String msg2 = new String(datos);
      txtPanelLog.setText(txtPanelLog.getText() + "\n" + 
              "Mensaje recibido: " + msg2);
      System.out.println("Mensaje recibido: " + msg2);
    } catch (IOException ex) {
      //TODO something..
    } finally {
      try {
        inputStream.close();
        outputStream.close();
        serverSocket.close();
        System.out.println("Conexión cerrada en el servidor " + serverName);
      } catch (IOException ex) {
        //...
      }
    }
  }
  
  
}
