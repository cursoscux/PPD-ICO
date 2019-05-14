package mx.uaemex.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import javax.swing.text.BadLocationException;
import javax.swing.text.Document;
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
        append("Servidor escuchando en puerto 1600...\n");
        Socket socket = serverSocket.accept();
        oOutputStream = new ObjectOutputStream(socket.getOutputStream());
        oInputStream = new ObjectInputStream(socket.getInputStream());
        append("Conexión establecida...\n");
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
  
  public void append(String s) {
    try {
      Document doc = txtCharla.getDocument();
      doc.insertString(doc.getLength(), s, null);
    } catch(BadLocationException ex) {
      //TODO something...
    }
  }
}
