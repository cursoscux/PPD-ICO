package mx.uaemex.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import mx.uaemex.msg.Message;

public class MyClient extends Thread{

  @Override
  public void run() {
    super.run(); 
    Socket socket = null;
    ObjectInputStream oInputStream = null;
    ObjectOutputStream oOutputStream = null;
    try {
      System.out.println("Intentando conexión...");
      socket = new Socket("127.0.0.1", 1600);
      System.out.println("Conexión establecida");
      oInputStream = new ObjectInputStream(socket.getInputStream());
      Message msg = null;
        try {
          msg = (Message) oInputStream.readObject();
        } catch (ClassNotFoundException ex) {
          //Do something...
        }
      System.out.println("Mensaje recibido\n" + 
              "id: " + msg.getIdMessage() + "\n" + 
              "Remitente: " + msg.getMsgSender() + "\n" +
              "Cuerpo del msj: " + msg.getMsgBody());
      
      oOutputStream = new ObjectOutputStream(socket.getOutputStream());
      Message msg2 = new Message(12, "Rabanito", "Que onda?");
      oOutputStream.writeObject(msg2);
      oOutputStream.flush();
    } catch (IOException ex) {
      //TODO something...
    } finally {
      try {
        oOutputStream.close();
        oInputStream.close();
        socket.close();
        System.out.println("Conexión cerrada");
      } catch (IOException ex) {
        //...
      }
    }
  }
  
}
