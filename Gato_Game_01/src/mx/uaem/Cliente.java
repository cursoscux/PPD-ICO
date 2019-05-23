package mx.uaem;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JTextPane;

/**
 *
 * @author René Cruz
 */
public class Cliente {

    private static Socket cliente;
    private static ObjectInputStream entrada;
    private static Mensaje mensaje;
    private static ObjectOutputStream salida;
    private final JTextPane txtPanel;
    private final JTextField txtNickName;
    private final JTextField txtIPServer;
    private final JTextField txtMessage;
    private final JButton btnSend;
    private final JTextPane txtGato;
    private TableroGato tableroGato;

    public Cliente(JTextPane txtPanel, JTextField txtNickName, JTextField txtIPServer,
            JTextField txtMessage, JButton btnSend, JTextPane txtGato) {
        this.txtPanel = txtPanel;
        this.txtNickName = txtNickName;
        this.txtIPServer = txtIPServer;
        this.txtMessage = txtMessage;
        this.txtGato = txtGato;
        this.btnSend = btnSend;
        tableroGato = new TableroGato();
    }

    public void start() {
        try {
            cliente = new Socket(InetAddress.getByName(txtIPServer.getText()), 12345);
            // mostrar la información de la conexión
            System.out.println("Conectado a: " + cliente.getInetAddress().getHostName());

            // establecer flujo de entrada y salida para los objetos
            entrada = new ObjectInputStream(cliente.getInputStream());
            salida = new ObjectOutputStream(cliente.getOutputStream());

            receiveMsg();
            Mensaje miMensaje = new Mensaje();
            miMensaje.setTipo(Mensaje.MESSAGE_LOGIN);
            miMensaje.setRemitente(txtNickName.getText());
            miMensaje.setCuerpo("");
            sendMessage(miMensaje);
        } catch (Exception ex) {
            //..
        }
    }

    public void sendMessage(Mensaje msg) {
        try {
            salida.writeObject(msg);
            salida.flush(); // vaciar búfer de salida para enviar información de encabezado

        } catch (Exception ex) {
        }
    }

    public void receiveMsg() {
        Thread oreja = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    while (true) {
                        mensaje = (Mensaje) entrada.readObject();
                        int tipo = mensaje.getTipo();
                        switch (tipo) {
                            case Mensaje.MESSAGE_LOGIN: {
                                //do something
                            }
                            break;
                            case Mensaje.MESSAGE_CHAT: {
                                System.out.println(mensaje.getCuerpo());
                                //txtPanel.setText(txtPanel.getText() + mensaje.getRemitente() + ": "
                                //        + mensaje.getCuerpo() + "\n");
                                char simbol = mensaje.getCuerpo().charAt(0);
                                int row = Integer.parseInt(mensaje.getCuerpo().charAt(2) + "");
                                int col = Integer.parseInt(mensaje.getCuerpo().charAt(4) + "");
                                //System.out.println("Tirada de: " + simbol + " en: " + row + ", " + col);
                                if (tableroGato.hacerTirada(simbol, row, col)) {
                                    txtGato.setText(tableroGato.toString());
                                    switch (tableroGato.checkGato()) {
                                        case 0:
                                            break; //continua juego...
                                        case 1: {
                                            JOptionPane.showMessageDialog(null, "Gano el jugador con las X!", "Gato", JOptionPane.INFORMATION_MESSAGE);
                                            tableroGato.initTablero();
                                            txtGato.setText(tableroGato.toString());
                                        }
                                        break;
                                        case 2: {
                                            JOptionPane.showMessageDialog(null, "Gano el jugador con las O!", "Gato", JOptionPane.INFORMATION_MESSAGE);
                                            tableroGato.initTablero();
                                            txtGato.setText(tableroGato.toString());
                                        }
                                        break;
                                    }
                                    if (!mensaje.getRemitente().equals(txtNickName.getText())) {
                                        btnSend.setEnabled(true);
                                        txtMessage.setEditable(true);
                                    }
                                } else if (mensaje.getRemitente().equals(txtNickName.getText())) {
                                    btnSend.setEnabled(true);
                                    txtMessage.setEditable(true);
                                }

                            }
                            break;
                            case Mensaje.MESSAGE_LOGOUT: {
                                //do something
                            }
                            break;
                            case Mensaje.MESSAGE_WAIT: {
                                System.out.println(mensaje.getCuerpo());
                                txtPanel.setText(txtPanel.getText() + mensaje.getRemitente() + ": "
                                        + mensaje.getCuerpo() + "\n");
                            }
                            break;
                            case Mensaje.MESSAGE_START: {
                                System.out.println(mensaje.getCuerpo());
                                txtPanel.setText(txtPanel.getText() + mensaje.getRemitente() + ": "
                                        + mensaje.getCuerpo() + "\n");
                                //habilita controles
                                txtMessage.setEditable(true);
                                btnSend.setEnabled(true);

                                //Crea tablero del gato
                                tableroGato = new TableroGato();
                                txtGato.setText(tableroGato.toString());
                            }
                            break;
                        }
                    }
                } catch (Exception ex) {
                }
            }
        };
        oreja.start();

    }

    public void close() {
        try {
            salida.close();
            entrada.close();
            cliente.close();
        } catch (Exception ex) {
        }
    }
}
