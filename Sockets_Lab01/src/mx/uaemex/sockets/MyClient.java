package mx.uaemex.sockets;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

public class MyClient {

  public MyClient() {
    Socket socket = null;
    InputStream inputStream = null;
    OutputStream outputStream = null;
    try {
      System.out.println("Intentando conexión...");
      socket = new Socket("127.0.0.1", 1600);
      System.out.println("Conexión establecida");
      inputStream = socket.getInputStream();
      byte[] datos = new byte[1024];
      inputStream.read(datos);
      String msg = new String(datos);
      System.out.println("Mensaje recibido: " + msg);
      outputStream = socket.getOutputStream();
      String msg2 = "Soy el cliente: Rabanito!";
      outputStream.write(msg2.getBytes());
      outputStream.flush();
    } catch (IOException ex) {
      //TODO something...
    } finally {
      try {
        outputStream.close();
        inputStream.close();
        socket.close();
        System.out.println("Conexión cerrada");
      } catch (IOException ex) {
        //...
      }
    }
  }
  
}
