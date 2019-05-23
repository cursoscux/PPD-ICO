
package mx.uaem;

import java.io.Serializable;

public class Mensaje implements Serializable {
    /**Define que el mensaje es para conexion con 
    el servidor */
    public static final int MESSAGE_LOGIN = 10;
    
    /**Define que el mensaje es para desconexion con
    el servidor.*/
    public static final int MESSAGE_LOGOUT = 20;
    /**Define que el mensaje contiene la frase
     * para intercambiar entre participantes.
     */
    public static final int MESSAGE_CHAT = 30;
    /** 
     * Define que el mensaje pone en antesala
     * al cliente.
     */
    public static final int MESSAGE_WAIT = 40;
    /**
     * Define que el mensaje indica al cliente
     * que inicie la interaccion
     */
    public static final int MESSAGE_START = 50;
            
    private int tipo;
    private String remitente;
    private String cuerpo;

    /**
     * @return the tipo
     */
    public int getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(int tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the remitente
     */
    public String getRemitente() {
        return remitente;
    }

    /**
     * @param remitente the remitente to set
     */
    public void setRemitente(String remitente) {
        this.remitente = remitente;
    }

    /**
     * @return the cuerpo
     */
    public String getCuerpo() {
        return cuerpo;
    }

    /**
     * @param cuerpo the cuerpo to set
     */
    public void setCuerpo(String cuerpo) {
        this.cuerpo = cuerpo;
    }
    
}
