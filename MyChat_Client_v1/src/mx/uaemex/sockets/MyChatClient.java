package mx.uaemex.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JTextArea;
import mx.uaemex.msg.Message;

public class MyChatClient extends Thread {
  private String clientName;
  private JTextArea txtCharla;
  private MsgSender msgSender;
  private MsgListener msgListener;
  
  public MyChatClient(String clientName, JTextArea txtCharla) {
    this.clientName = clientName;
    this.txtCharla = txtCharla;
  }
  
  @Override
  public void run() {
    super.run();
    Socket socket = null;
    ObjectInputStream oInputStream = null;
    ObjectOutputStream oOutputStream = null;
    try {
      txtCharla.append("Intentando conexión...\n");
      socket = new Socket("127.0.0.1", 1600);
      oInputStream = new ObjectInputStream(socket.getInputStream());
      oOutputStream = new ObjectOutputStream(socket.getOutputStream());
      txtCharla.append("Conexión establecida\n");
      msgSender = new MsgSender(oOutputStream);
      msgListener = new MsgListener(oInputStream, txtCharla);
      msgListener.start();
    } catch (IOException ex) {
      //TODO to fix error...
    } finally {
//      try {
//        oOutputStream.close();
//        oInputStream.close();
//        socket.close();
//        txtCharla.append("Conexión cerrada\n");
//      } catch (IOException ex) {
//        //...
//      }
    }

  }
  
  public void sendMessage(Message msg) {
      msgSender.sendMessage(msg);
  }

}
