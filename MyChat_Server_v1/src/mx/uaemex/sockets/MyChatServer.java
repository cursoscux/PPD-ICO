package mx.uaemex.sockets;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import javax.swing.JTextArea;
import mx.uaemex.msg.Message;

public class MyChatServer extends Thread {

<<<<<<< HEAD
    private String serverName;
    private boolean isRunning;
    private MsgSender msgSender;
    private MsgListener msgListener;
    private JTextArea txtCharla;
    public MyChatServer(String serverName, JTextArea txtCharla) {
        this.serverName = serverName;
        this.txtCharla = txtCharla;
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
                txtCharla.append("Servidor escuchando en puerto 1600...\n");
                Socket socket = serverSocket.accept();
                oOutputStream = new ObjectOutputStream(socket.getOutputStream());
                oInputStream = new ObjectInputStream(socket.getInputStream());
                txtCharla.append("Conexión establecida...\n");
                msgSender = new MsgSender(oOutputStream);
                msgListener = new MsgListener(oInputStream, txtCharla);
                msgListener.start();
            } catch (IOException ex) {
                //TODO something..
            } finally {
//                try {
//                    oInputStream.close();
//                    oOutputStream.close();
//                    serverSocket.close();
//                    txtCharla.append("Conexión cerrada en el servidor " + serverName + "\n");
//                } catch (IOException ex) {
//                    //...
//                }
            }
        }
=======
  private String serverName;
  private boolean isRunning;
  private MsgSender msgSender;
  private MsgListener msgListener;
  private JTextArea txtCharla;

  public MyChatServer(String serverName, JTextArea txtCharla) {
    this.serverName = serverName;
    this.txtCharla = txtCharla;
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
        txtCharla.append("Servidor escuchando en puerto 1600...\n");
        Socket socket = serverSocket.accept();
        oOutputStream = new ObjectOutputStream(socket.getOutputStream());
        oInputStream = new ObjectInputStream(socket.getInputStream());
        txtCharla.append("Conexión establecida...\n");
        msgSender = new MsgSender(oOutputStream);
        msgListener = new MsgListener(oInputStream, txtCharla);
        msgListener.start();
      } catch (IOException ex) {
      }
>>>>>>> 59ea8d660763356c58a85f735da9f901e3c8b268
    }

    public void stopMyServer() {
        isRunning = false;
    }

<<<<<<< HEAD
    public void sendMessage(Message msg) {
        msgSender.sendMessage(msg);
    }
=======
  public void sendMessage(Message msg) {
    msgSender.sendMessage(msg);
  }
>>>>>>> 59ea8d660763356c58a85f735da9f901e3c8b268
}
