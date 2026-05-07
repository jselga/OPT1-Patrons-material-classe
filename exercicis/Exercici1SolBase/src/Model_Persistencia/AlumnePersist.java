/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_Persistencia;

import Model_Negoci.Alumne;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author david
 */
public class AlumnePersist {

   
    private final Map<Integer, Alumne> alumnes;

    public AlumnePersist() {
        this.alumnes = new HashMap<>();
    }


    public boolean inserirAlumne(Alumne alumne) {
        int id = alumne.getId();
        if (alumnes.containsKey(id)) {
            return false;
        }
        Alumne nouAlumne = new Alumne(id, alumne.getNom(), alumne.getEdat());
        alumnes.put(id, nouAlumne);
        return true;
    }

    public void mostraAlumnes(){
        for (Map.Entry<Integer, Alumne> entry : alumnes.entrySet()) {
            
            System.out.println(entry.getValue());
            
        }
    }

}
