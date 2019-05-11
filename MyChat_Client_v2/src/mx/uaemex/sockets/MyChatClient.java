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
  private String IPServidor;

  public MyChatClient(String clientName, JTextArea txtCharla, String IPServidor) {
    this.clientName = clientName;
    this.txtCharla = txtCharla;
    this.IPServidor = IPServidor;
  }

  @Override
  public void run() {
    super.run();
    Socket socket = null;
    ObjectInputStream oInputStream = null;
    ObjectOutputStream oOutputStream = null;
    try {
      txtCharla.append("Intentando conexión...\n");
      socket = new Socket(IPServidor, 1600);
      oInputStream = new ObjectInputStream(socket.getInputStream());
      oOutputStream = new ObjectOutputStream(socket.getOutputStream());
      txtCharla.append("Conexión establecida\n");

      msgSender = new MsgSender(oOutputStream);
      msgListener = new MsgListener(oInputStream, txtCharla);
      msgListener.start();
    } catch (IOException ex) {
    }
  }

  public void sendMessage(Message msg) {
    msgSender.sendMessage(msg);
  }
}
