package mx.uaem;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Vector;

/**
 *
 * @author René Cruz
 */
public class Servidor extends Thread {

    private static ServerSocket servidor;
    private static Socket conexion;
    private static ObjectOutputStream salida;
    private static ObjectInputStream entrada;
    private static Mensaje mensaje;

    private Vector clientes;
    private Vector conectados;

    private String txtNickName;

    public Servidor(String txtNickName) {

        this.txtNickName = txtNickName;
        clientes = new Vector();
        conectados = new Vector();
    }

    @Override
    public void run() {

        try {

            servidor = new ServerSocket(12345, 100);
            addConectado();
            while (true) {
                System.out.println("Esperando una conexión\n");
                conexion = servidor.accept(); // permitir al servidor aceptar la conexión
                System.out.println("Conexión recibida de: " + conexion.getInetAddress().getHostName());
                // establecer flujo de salida para los objetos
                salida = new ObjectOutputStream(conexion.getOutputStream());

                // establecer flujo de entrada para los objetos
                entrada = new ObjectInputStream(conexion.getInputStream());
                
                //Mensaje miMensaje =  (Mensaje) entrada.readObject();
//                conectados.add(miMensaje.getRemitente());
//                addConectado();
//                System.out.println("El usuario: " + miMensaje.getRemitente() +
//                        " se ha conectado");

                addClientOutputStream(salida);
                receiveMsg(entrada);
            }
        } catch (Exception ex) {
        }

    }
    public void addConectado() {
        String strConectados = txtNickName + "\n";
        for (Object  usuario: conectados) {
            strConectados += (String) usuario + "\n";
        }
        System.out.println(strConectados);

    }

    public void sendMessage(Mensaje msg) {
        try {
            for (Object flujo : clientes) {
                ((ObjectOutputStream) flujo).writeObject(msg);
                ((ObjectOutputStream) flujo).flush();
            }
        } catch (Exception ex) {            
        }
    }

    private void addClientOutputStream(ObjectOutputStream salida) {
        try {
            Mensaje miMensaje = new Mensaje();
            miMensaje.setTipo(Mensaje.MESSAGE_LOGIN);
            miMensaje.setRemitente(txtNickName);
            miMensaje.setCuerpo("Conectado con el servidor...");
            salida.writeObject(miMensaje);
            salida.flush(); // vaciar búfer de salida para enviar información de encabezado            
            clientes.add(salida);
        } catch (Exception ex) {            
        }
    }


    public void receiveMsg(final ObjectInputStream entrada) {
        Thread oreja = new Thread() {

            @Override
            public void run() {
                try {
                    super.run();
                    ObjectInputStream newInput = entrada;
                    while (true) {
                        mensaje = (Mensaje) newInput.readObject();
                        int tipo = mensaje.getTipo();
                        switch (tipo) {
                            case Mensaje.MESSAGE_LOGIN: {
                                conectados.add(mensaje.getRemitente());
                                addConectado();
                                System.out.println("El usuario: " + mensaje.getRemitente()
                                        + " se ha conectado");
                                verificaParticipantes();
                            }
                            break;
                            case Mensaje.MESSAGE_CHAT: {
                                System.out.println( mensaje.getRemitente() + ": "
                                        + mensaje.getCuerpo() + "\n");
                                sendMessage(mensaje);
                            }
                            break;
                            case Mensaje.MESSAGE_LOGOUT: {
                                //do something
                            }
                            break;
                                case Mensaje.MESSAGE_WAIT: {
                                //do something
                            }
                            break;
                            case Mensaje.MESSAGE_START: {
                                //do something
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

    public void verificaParticipantes() {
        int numParticipantes = conectados.size();
        System.out.println("Participantes: " + 
               numParticipantes ); 
        switch (numParticipantes) {
            case 1: { //Falta un participante
                Mensaje newMensaje = new Mensaje();
                newMensaje.setTipo(Mensaje.MESSAGE_WAIT);
                newMensaje.setRemitente(txtNickName);
                newMensaje.setCuerpo("Esperando otro participante");
                sendMessage(newMensaje);
            } break;
            case 2: {
                Mensaje newMensaje = new Mensaje();
                newMensaje.setTipo(Mensaje.MESSAGE_START);
                newMensaje.setRemitente(txtNickName);
                newMensaje.setCuerpo("Inicia la interaccion!");
                sendMessage(newMensaje);
            }
        }
    }
    
    public void close() {
        try {
            salida.close();
            entrada.close();
            conexion.close();

        } catch (Exception ex) {
        }
    }


}
