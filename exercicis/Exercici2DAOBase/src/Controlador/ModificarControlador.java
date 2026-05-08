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
import java.util.logging.Level;
import java.util.logging.Logger;

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

            try {
                String nom = v_modificar.getjTextField_nom().getText();
                int edat = Integer.parseInt(v_modificar.getjTextField_edat().getText());
                alumne.setNom(nom);
                alumne.setEdat(edat);
                AlumneDAO.getInstance().updateAlumne(alumne);
                v_modificar.dispose();
                AlumnesControlador.getInstance().carregarJTable();
                AlumnesControlador.getInstance().getV_alumnes().setVisible(true);
            } catch (SQLException ex) {
                Logger.getLogger(ModificarControlador.class.getName()).log(Level.SEVERE, null, ex);
            }

        }

    }

}
