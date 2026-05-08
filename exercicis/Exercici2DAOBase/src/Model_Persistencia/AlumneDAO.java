/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_Persistencia;

import Model_Negoci.Alumne;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

/**
 *
 * @author david
 */
public class AlumneDAO extends BaseDAO {

    private static AlumneDAO instancia = null;

    private AlumneDAO() {
        this.connect();
    }

    public static AlumneDAO getInstance() {
        if (instancia == null) {
            instancia = new AlumneDAO();
        }
        return instancia;
    }

    public boolean inserirAlumne(Alumne alumne) throws SQLException {
        // TODO EXERCICI:
        // 1) Crear el PreparedStatement amb un INSERT a la taula alumnes.
        // 2) Assignar nom i edat amb setString / setInt.
        // 3) Executar l'update i retornar true si s'ha inserit 1 registre.
        return false;
    }

    public ArrayList<Alumne> getAlumnes() throws SQLException {

        ArrayList<Alumne> llistaAlumnes = new ArrayList<>();

        PreparedStatement stmt = conn.prepareStatement("SELECT * FROM alumnes");

        ResultSet rs = stmt.executeQuery();

        while (rs.next()) {
            Alumne al = new Alumne();
            al.setId(rs.getInt("id"));
            al.setNom(rs.getString("nom"));
            al.setEdat(rs.getInt("edat"));
            llistaAlumnes.add(al);
        }

        rs.close();
        stmt.close();

        return llistaAlumnes;
    }

    public Alumne getAlumne(int id) throws SQLException {
        // TODO EXERCICI:
        // 1) Fer un SELECT per id amb PreparedStatement.
        // 2) Si existeix, crear i retornar l'objecte Alumne.
        // 3) Si no existeix, retornar null.
        return null;
    }

    public void updateAlumne(Alumne alumne) throws SQLException {
        // TODO EXERCICI:
        // 1) Fer un UPDATE de nom i edat filtrant per id.
        // 2) Assignar valors amb setString / setInt.
        // 3) Executar l'update.
    }
    
    public boolean deleteAlumne(int id) throws SQLException {
        // TODO EXERCICI:
        // 1) Fer un DELETE per id.
        // 2) Retornar true si s'ha eliminat com a minim 1 registre.
        return false;
    }

}
