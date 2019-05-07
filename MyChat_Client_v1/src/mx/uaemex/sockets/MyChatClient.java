package mx.uaemex.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

public class MyChatClient extends Thread {
  private String clientName;

  public MyChatClient(String clientName) {
    this.clientName = clientName;
  }
  
  @Override
  public void run() {
    super.run();
    Socket socket = null;
    ObjectInputStream oInputStream = null;
    ObjectOutputStream oOutputStream = null;
    try {
      System.out.println("Intentando conexión...");
      socket = new Socket("127.0.0.1", 1600);
      oInputStream = new ObjectInputStream(socket.getInputStream());
      oOutputStream = new ObjectOutputStream(socket.getOutputStream());
      System.out.println("Conexión establecida");
      //TODO comm's
    } catch (IOException ex) {
      //TODO to fix error...
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
