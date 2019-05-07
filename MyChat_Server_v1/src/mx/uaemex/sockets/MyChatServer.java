package mx.uaemex.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyChatServer extends Thread {

  private String serverName;
  private boolean isRunning;

  public MyChatServer(String serverName) {
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
        Socket socket = serverSocket.accept();
        oOutputStream = new ObjectOutputStream(socket.getOutputStream());
        oInputStream = new ObjectInputStream(socket.getInputStream());
        System.out.println("Conexión establecida...");
        //.. TODO something...
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
