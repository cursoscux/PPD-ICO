
package mx.uaemex.main;

import mx.uaemex.sockets.MyChatServer;

public class MyChat_Server_v1 {

  public static void main(String[] args) {
    MyChatServer server = new MyChatServer("Servidor MX");
    server.start();
  }
  
}
