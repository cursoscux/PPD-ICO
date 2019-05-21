package mx.uaemex.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import javax.swing.JTextPane;
import mx.uaemex.gui.MyClientGUI;
import mx.uaemex.msg.Message;

public class MyChatClient extends Thread {

  private String clientName;
  private JTextPane txtCharla;
  private MsgSender msgSender;
  private MsgListener msgListener;
  private String IPServidor;

  public MyChatClient(String clientName, JTextPane txtCharla, String IPServidor) {
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
      MyClientGUI.append(Message.COMM_MESSAGE , txtCharla, "Intentando conexión...\n");
      socket = new Socket(IPServidor, 1600);
      oInputStream = new ObjectInputStream(socket.getInputStream());
      oOutputStream = new ObjectOutputStream(socket.getOutputStream());
      MyClientGUI.append(Message.COMM_MESSAGE , txtCharla, "Conexión establecida\n");

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
