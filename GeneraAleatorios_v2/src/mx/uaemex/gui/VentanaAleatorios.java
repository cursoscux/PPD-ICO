package mx.uaemex.gui;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.SwingUtilities;
import javax.swing.event.ListDataEvent;
import javax.swing.event.ListDataListener;
import mx.uaemex.threads.GeneraAleatorioThread;

public class VentanaAleatorios extends JFrame {

  public static ArrayList datos = new ArrayList();
  public VentanaAleatorios() {
    setSize(400, 240);
    setTitle("Generador de Aleatorios v2.0");
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

    JPanel panelDatos = new JPanel();
    DefaultListModel modeloLista = new DefaultListModel();
    JList listaInfo = new JList(modeloLista);
    modeloLista.addListDataListener(new ListDataListener() {
      @Override
      public void intervalAdded(ListDataEvent e) {
        Runnable doRun = new Runnable() {
          @Override
          public void run() {
            listaInfo.ensureIndexIsVisible(modeloLista.getSize() - 1);
            
          }
        };
        SwingUtilities.invokeLater(doRun);
      }

      @Override
      public void intervalRemoved(ListDataEvent e) {
      }

      @Override
      public void contentsChanged(ListDataEvent e) {
      }
    });
    JScrollPane panelScroll = new JScrollPane(listaInfo);
    panelDatos.add(panelScroll);
    add(panelDatos, BorderLayout.CENTER);

    JPanel panelBotones = new JPanel();
    JButton btnIniciar = new JButton("Iniciar");
    GeneraAleatorioThread hilos[] = new GeneraAleatorioThread[100];
    for (int i = 0; i < hilos.length; i++) {
      hilos[i] = new GeneraAleatorioThread("Hilo " + i, modeloLista);
    }

    btnIniciar.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < hilos.length; i++) {
          hilos[i].start();
        }
      }
    });
    panelBotones.add(btnIniciar);
    JButton btnDetener = new JButton("Detener");
    btnDetener.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        for (int i = 0; i < hilos.length; i++) {
          hilos[i].stopThread();
        }
      }
    });
    panelBotones.add(btnDetener);
    JButton btnSalir = new JButton("Salir");
    btnSalir.addActionListener(new ActionListener() {
      @Override
      public void actionPerformed(ActionEvent e) {
        System.exit(0);
      }
    });
    panelBotones.add(btnSalir);
    add(panelBotones, BorderLayout.SOUTH);
    setVisible(true);
  }

}
