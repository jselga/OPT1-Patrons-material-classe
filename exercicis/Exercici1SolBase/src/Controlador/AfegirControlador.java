/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controlador;

import Model_Negoci.Alumne;
import Model_Persistencia.AlumnePersist;
import Vista.AfegirVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author david
 */
public class AfegirControlador implements ActionListener{
    
    private final AfegirVista v_afegir;
    private final AlumnePersist m_alumne;
  
    

    public AfegirControlador() {        
        v_afegir = new AfegirVista();
        m_alumne = AlumnePersist.getInstance();
        v_afegir.getjToggleButton_afegir().addActionListener(this);
    }
    
   
    public void run() {

        v_afegir.setVisible(true);
        v_afegir.setTitle("Afegir alumne");
        v_afegir.setLocationRelativeTo(null);       

    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        
        if ("Afegir".equals(ae.getActionCommand())) {
            v_afegir.netejarErrors();
            String idText = v_afegir.getjTextField_id().getText().trim();
            String nom = v_afegir.getjTextField_nom().getText().trim();
            String edatText = v_afegir.getjTextField_edat().getText().trim();

            int id;
            try {
                id = Integer.parseInt(idText);
                if (id < 0) {
                    System.out.println("Validacio ERROR: la id ha de ser un nombre positiu");
                    v_afegir.setErrorId("ha de ser positiva");
                    return;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Validacio ERROR: la id ha de ser numerica");
                v_afegir.setErrorId("ha de ser numerica");
                return;
            }

            if (nom.isEmpty()) {
                System.out.println("Validacio ERROR: el nom no pot estar buit");
                v_afegir.setErrorNom("obligatori");
                return;
            }

            int edat;
            try {
                edat = Integer.parseInt(edatText);
                if (edat < 0) {
                    System.out.println("Validacio ERROR: l'edat ha de ser un nombre positiu");
                    v_afegir.setErrorEdat("ha de ser positiva");
                    return;
                }
            } catch (NumberFormatException ex) {
                System.out.println("Validacio ERROR: l'edat ha de ser numerica");
                v_afegir.setErrorEdat("ha de ser numerica");
                return;
            }

            Alumne alumne = new Alumne(id, nom, edat);
            boolean inserit = m_alumne.inserirAlumne(alumne);
            if (!inserit) {
                System.out.println("Validacio ERROR: la id " + id + " ja existeix");
                v_afegir.setErrorId("duplicada");
                return;
            }
            System.out.println("Validacio OK: alumne afegit correctament");
            System.out.println("Map actual: ");
            m_alumne.mostraAlumnes();
            v_afegir.getjTextField_id().setText("");
            v_afegir.getjTextField_nom().setText("");
            v_afegir.getjTextField_edat().setText("");
        }
    }
    
}
