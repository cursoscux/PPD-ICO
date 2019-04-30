package mx.uaemex.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import mx.uaemex.msg.Message;

public class MyServer extends Thread{

  private String serverName;
  private boolean isRunning;
  
  public MyServer(String serverName) {
    this.serverName = serverName;
  }

  @Override
  public void run() {
    super.run(); 
    isRunning = true;
    ServerSocket serverSocket = null;
    ObjectOutputStream oOutputStream = null;
    ObjectInputStream oInputStream = null;
    while (isRunning) {
      try {
      serverSocket = new ServerSocket(1600);    
      System.out.println("Servidor escuchando en puerto 1600...");
      Socket socket =  serverSocket.accept();
      String remoteUser = socket.getRemoteSocketAddress().toString();      
      System.out.println("Conexión recibida de " + remoteUser);
      oOutputStream = new ObjectOutputStream(socket.getOutputStream());
      
      Message myMessage = new Message(99, "YoMerengues", "Hola, como estas?");
      //String msj = "Bienvenido al servidor " + serverName;
      oOutputStream.writeObject(myMessage);
      oOutputStream.flush();
      
      
      oInputStream = new ObjectInputStream(socket.getInputStream());
//      byte[] datos = new byte[1024];
//      oInputStream.read(datos);
//      String msg2 = new String(datos); 
      Message msg2 = null;
        try {
          msg2 = (Message) oInputStream.readObject();
        } catch (ClassNotFoundException ex) {
          //Do something...
        }
      System.out.println("Mensaje recibido\n" + 
              "id: " + msg2.getIdMessage() + "\n" + 
              "Remitente: " + msg2.getMsgSender() + "\n" +
              "Cuerpo del msj: " + msg2.getMsgBody());
    } catch (IOException ex) {
      //TODO something..
    } finally {
      try {
        oInputStream.close();
        oOutputStream.close();
        serverSocket.close();
        System.out.println("Conexión cerrada en el servidor " + serverName);
      } catch (IOException ex) {
        //...
      }
    }
    }
  }
  
  public void stopMyServer() {
    isRunning = false;
  }
  
}
