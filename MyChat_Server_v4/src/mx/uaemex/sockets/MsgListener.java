package mx.uaemex.sockets;

import java.awt.Color;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.HashMap;
import java.util.concurrent.ThreadLocalRandom;
import javax.swing.JTextPane;
import mx.uaemex.msg.Message;
import mx.uaemex.gui.MyServerGUI;

public class MsgListener extends Thread{

  private ObjectInputStream oIS;
  private JTextPane txtCharla;
  private MyChatServer myChatServer;
  private HashMap<String, Integer> listaUsuarios = new HashMap<>(); 
  
  public MsgListener(ObjectInputStream oIS, JTextPane txtCharla, MyChatServer myChatServer) {
    this.oIS = oIS;
    this.txtCharla = txtCharla;
    this.myChatServer = myChatServer;
  }
  
  private boolean isRunning;
  
  @Override
  public void run() {
    super.run(); 
    isRunning = true;
    while (isRunning) {
      try {
        Message msg = (Message) oIS.readObject();
        if (!listaUsuarios.containsKey(msg.getMsgSender())) {
          listaUsuarios.put(msg.getMsgSender(), 
                  ThreadLocalRandom.current().nextInt(0xFFFFFF));
        }
        String strMessage = msg.getMsgSender() + ": " +  msg.getMsgBody() + "\n";
        Color msgColor = new Color(listaUsuarios.get(msg.getMsgSender()));
        MyServerGUI.append(msgColor, txtCharla, strMessage);
        txtCharla.setCaretPosition(txtCharla.getDocument().getLength());
        myChatServer.sendMessage(msg);
      } catch (IOException ex) {        
      } catch (ClassNotFoundException ex) {        
      }
    }
  }
  
  public void stopMsgListener() {
    isRunning = false;
  }
  
}
