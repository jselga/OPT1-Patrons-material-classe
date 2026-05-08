/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Model_Negoci.Alumne;
import Model_Persistencia.AlumneDAO;
import Model_Persistencia.BDUtilDAO;
import Vista.AlumnesVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author david
 */
public class AlumnesControlador implements ActionListener {

    private AlumnesVista v_alumnes;
    private DefaultTableModel tm;

    //Patró Singleton
    private static AlumnesControlador instancia = null;

    private AlumnesControlador() {

        v_alumnes = new AlumnesVista();
        v_alumnes.getjButton_afegir().addActionListener(this);
        v_alumnes.getjButton_eliminar().addActionListener(this);
        v_alumnes.getjButton_modificar().addActionListener(this);

    }

    //Patró Singleton
    public static AlumnesControlador getInstance() {
        if (instancia == null) {
            instancia = new AlumnesControlador();
        }
        return instancia;
    }

    public AlumnesVista getV_alumnes() {
        return v_alumnes;
    }

    public void run() {
        try {
            BDUtilDAO.crearTaulaAlumne();
            BDUtilDAO.netejaTaules();
             BDUtilDAO.inserirDadesProva(); // Descomenta per provar el mostrar inicial.
            carregarJTable();
        } catch (SQLException ex) {
            mostrarErrorBD("Error inicialitzant la base de dades", ex);
        }

        v_alumnes.setVisible(true);
        v_alumnes.setTitle("Llistat alumnes del CGFS de DAW");
        v_alumnes.setLocationRelativeTo(null);

    }

    public void carregarJTable() {
        try {
            DefaultTableModel tm = new DefaultTableModel();

            tm.addColumn("Id");
            tm.addColumn("Nom");
            tm.addColumn("Edat");

            v_alumnes.getjTable_llistatAlumnes().setModel(tm);

            ArrayList<Alumne> llistatAlumnes = AlumneDAO.getInstance().getAlumnes();

            Object[] alumnes = new Object[3];

            for (Alumne al : llistatAlumnes) {

                alumnes[0] = al.getId();
                alumnes[1] = al.getNom();
                alumnes[2] = al.getEdat();

                tm.addRow(alumnes);
            }
        } catch (SQLException ex) {
            mostrarErrorBD("Error carregant alumnes", ex);
        }
    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getActionCommand().equals("Afegir")) {

            v_alumnes.setVisible(false);
            AfegirControlador.getInstance().run();

        } else if (ae.getActionCommand().equals("Modificar")) {

            modificar();

        } else if (ae.getActionCommand().equals("Eliminar")) {

            eliminar();
        }

    }

    public void modificar() {

        int filaSeleccionada = v_alumnes.getjTable_llistatAlumnes().getSelectedRow();

        if (filaSeleccionada != -1) { // Comprova que hi ha alguna fila seleccionada
            Object id = v_alumnes.getjTable_llistatAlumnes().getValueAt(filaSeleccionada, 0); // 0 és la columna que vols
            v_alumnes.setVisible(false);
            Alumne alumne = getAlumneSegur((int) id);
            if (alumne == null) {
                JOptionPane.showMessageDialog(null, "TODO: implementar getAlumne(id) a AlumneDAO", "Exercici", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            ModificarControlador.getInstance().run(alumne);
            ModificarControlador.getInstance().carregarAlumne();

        } else {
            JOptionPane.showMessageDialog(null, "Cap fila seleccionada", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    public void eliminar() {

        Alumne alumne = null;

        int filaSeleccionada = v_alumnes.getjTable_llistatAlumnes().getSelectedRow();

        if (filaSeleccionada != -1) {
            Object id = v_alumnes.getjTable_llistatAlumnes().getValueAt(filaSeleccionada, 0);
            alumne = getAlumneSegur((int) id);

            if (alumne == null) {
                JOptionPane.showMessageDialog(null, "TODO: implementar getAlumne(id) a AlumneDAO", "Exercici", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            Object[] options = {"Sí", "No"};
            int resposta = JOptionPane.showOptionDialog(
                    null,
                    "Segur que vols eliminar l'alumne: " + alumne.getNom(),
                    "Confirmació",
                    JOptionPane.YES_NO_OPTION,
                    JOptionPane.QUESTION_MESSAGE,
                    null,
                    options,
                    options[0]
            );

            if (resposta == JOptionPane.YES_OPTION) {
                if (deleteAlumneSegur(alumne.getId())) {
                    carregarJTable();
                } else {
                    JOptionPane.showMessageDialog(null, "TODO: implementar deleteAlumne(id) a AlumneDAO", "Exercici", JOptionPane.INFORMATION_MESSAGE);
                }

            }

        } else {
            JOptionPane.showMessageDialog(null, "Cap fila seleccionada", "Error", JOptionPane.ERROR_MESSAGE);

        }

    }

    private Alumne getAlumneSegur(int id) {
        try {
            return AlumneDAO.getInstance().getAlumne(id);
        } catch (SQLException ex) {
            mostrarErrorBD("Error obtenint alumne", ex);
            return null;
        }
    }

    private boolean deleteAlumneSegur(int id) {
        try {
            return AlumneDAO.getInstance().deleteAlumne(id);
        } catch (SQLException ex) {
            mostrarErrorBD("Error eliminant alumne", ex);
            return false;
        }
    }

    private void mostrarErrorBD(String missatge, Exception ex) {
        System.out.println(missatge + ": " + ex.getMessage());
        JOptionPane.showMessageDialog(null, missatge, "Error", JOptionPane.ERROR_MESSAGE);
    }
}
