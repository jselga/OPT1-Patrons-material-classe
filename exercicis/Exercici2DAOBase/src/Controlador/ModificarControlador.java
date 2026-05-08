/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Model_Negoci.Alumne;
import Model_Persistencia.AlumneDAO;
import Vista.ModificarVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class ModificarControlador implements ActionListener {

    private ModificarVista v_modificar;
    private Alumne alumne;
    private static ModificarControlador instancia = null;

    public ModificarControlador() {
        v_modificar = new ModificarVista();
        v_modificar.getjToggleButton_modificar().addActionListener(this);
    }

    public static ModificarControlador getInstance() {
        if (instancia == null) {
            instancia = new ModificarControlador();
        }
        return instancia;
    }

    public void run(Alumne alumne) {

        v_modificar.setVisible(true);
        v_modificar.setTitle("Modificar alumne");
        v_modificar.setLocationRelativeTo(null);
        this.alumne = alumne;

    }

    public void carregarAlumne() {

        v_modificar.getjTextField_nom().setText(alumne.getNom());
        v_modificar.getjTextField_edat().setText("" + alumne.getEdat());

    }

    @Override
    public void actionPerformed(ActionEvent ae) {

        if (ae.getActionCommand().equals("Modificar")) {

            String nom = v_modificar.getjTextField_nom().getText();
            int edat;
            try {
                edat = Integer.parseInt(v_modificar.getjTextField_edat().getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "L'edat ha de ser numerica", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            alumne.setNom(nom);
            alumne.setEdat(edat);
            if (updateAlumneSegur(alumne)) {
                v_modificar.dispose();
                AlumnesControlador.getInstance().carregarJTable();
                AlumnesControlador.getInstance().getV_alumnes().setVisible(true);
            }

        }

    }

    private boolean updateAlumneSegur(Alumne alumne) {
        try {
            AlumneDAO.getInstance().updateAlumne(alumne);
            return true;
        } catch (SQLException ex) {
            mostrarErrorBD("Error modificant alumne", ex);
            return false;
        }
    }

    private void mostrarErrorBD(String missatge, Exception ex) {
        System.out.println(missatge + ": " + ex.getMessage());
        JOptionPane.showMessageDialog(null, missatge, "Error", JOptionPane.ERROR_MESSAGE);
    }

}
