package mx.uaemex.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JTextPane;
import mx.uaemex.gui.MyServerGUI;
import mx.uaemex.msg.Message;

public class MyChatServer extends Thread {

  private String serverName;
  private boolean isRunning;
  private MsgSender msgSender;
  private MsgListener msgListener;
  private JTextPane txtCharla;
  private ArrayList<MsgSender> listMsgSender;

  public MyChatServer(String serverName, JTextPane txtCharla) {
    this.serverName = serverName;
    this.txtCharla = txtCharla;
    listMsgSender = new ArrayList<MsgSender>();
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
        MyServerGUI.append(Message.COMM_MESSAGE, txtCharla, "Servidor escuchando en puerto 1600...\n");
        Socket socket = serverSocket.accept();
        oOutputStream = new ObjectOutputStream(socket.getOutputStream());
        oInputStream = new ObjectInputStream(socket.getInputStream());
        MyServerGUI.append(Message.COMM_MESSAGE,txtCharla, "Conexión establecida...\n");
        msgSender = new MsgSender(oOutputStream);
        listMsgSender.add(msgSender);
        msgListener = new MsgListener(oInputStream, txtCharla, this);
        msgListener.start();
      } catch (IOException ex) {
      }
    }
  }

  public void stopMyServer() {
    isRunning = false;
  }

  public void sendMessage(Message msg) {
    //msgSender.sendMessage(msg);
    for (MsgSender msgSender : listMsgSender) {
      msgSender.sendMessage(msg);
    }
  }
  
}
