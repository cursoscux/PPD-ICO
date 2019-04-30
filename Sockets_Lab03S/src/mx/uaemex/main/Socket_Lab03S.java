package mx.uaemex.main;

import mx.uaemex.sockets.MyServer;

public class Socket_Lab03S {

 
  public static void main(String[] args) {
    MyServer myServer = new MyServer("Empresarial");
    myServer.start();
  }
  
}
