package mx.uaemex.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class MyServer {

  public MyServer() {
    ServerSocket serverSocket = null;
    OutputStream outputStream = null;
    InputStream inputStream = null;
    try {
      serverSocket = new ServerSocket(1732);
      Socket socket =  serverSocket.accept();
      System.out.println("Conexión recibida");
      outputStream = socket.getOutputStream();
      String msj = "Bienvenido al servidor de la alegría!";
      outputStream.write(msj.getBytes());
      outputStream.flush();
      inputStream = socket.getInputStream();
      byte[] datos = new byte[1024];
      inputStream.read(datos);
      String msg2 = new String(datos);
      System.out.println("Mensaje recibido: " + msg2);
    } catch (IOException ex) {
      //TODO something..
    } finally {
      try {
        inputStream.close();
        outputStream.close();
        serverSocket.close();
        System.out.println("Conexión cerrada en el servidor de la alegria!");
      } catch (IOException ex) {
        //...
      }
    }
  }
  
}

