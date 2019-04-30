package mx.uaemex.main;

import mx.uaemex.sockets.MyClient;

public class Sockets_Lab03C {

  public static void main(String[] args) {
    MyClient myClient = new MyClient();
    myClient.start();
  }
}
