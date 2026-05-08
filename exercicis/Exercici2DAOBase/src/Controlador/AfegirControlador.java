/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Model_Negoci.Alumne;
import Model_Persistencia.AlumneDAO;
import Vista.AfegirVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import javax.swing.JOptionPane;

/**
 *
 * @author david
 */
public class AfegirControlador implements ActionListener{
    
    private AfegirVista v_afegir;
    private static AfegirControlador instancia = null;
    

    public AfegirControlador() {        
        v_afegir = new AfegirVista();
        v_afegir.getjToggleButton_afegir().addActionListener(this);
    }
    
    public static AfegirControlador getInstance() {
        if (instancia == null) {
            instancia = new AfegirControlador();
        }
        return instancia;
    }
    
    public void run() {

        v_afegir.setVisible(true);
        v_afegir.setTitle("Afegir alumne");
        v_afegir.setLocationRelativeTo(null);       

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if (ae.getActionCommand().equals("Afegir")) {
            String nom = v_afegir.getjTextField_nom().getText();
            int edat;
            try {
                edat = Integer.parseInt(v_afegir.getjTextField_edat().getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(null, "L'edat ha de ser numerica", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }
            boolean inserit = inserirAlumneSegur(new Alumne(nom, edat));
            if (!inserit) {
                JOptionPane.showMessageDialog(null, "TODO: implementar INSERT a AlumneDAO.inserirAlumne()", "Exercici", JOptionPane.INFORMATION_MESSAGE);
                return;
            }
            v_afegir.dispose();
            AlumnesControlador.getInstance().carregarJTable();
            AlumnesControlador.getInstance().getV_alumnes().setVisible(true);
        }
    }

    private boolean inserirAlumneSegur(Alumne alumne) {
        try {
            return AlumneDAO.getInstance().inserirAlumne(alumne);
        } catch (SQLException ex) {
            mostrarErrorBD("Error inserint alumne", ex);
            return false;
        }
    }

    private void mostrarErrorBD(String missatge, Exception ex) {
        System.out.println(missatge + ": " + ex.getMessage());
        JOptionPane.showMessageDialog(null, missatge, "Error", JOptionPane.ERROR_MESSAGE);
    }
    
}
