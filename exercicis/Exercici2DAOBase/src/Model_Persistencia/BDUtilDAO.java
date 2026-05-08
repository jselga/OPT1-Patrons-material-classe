/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_Persistencia;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

/**
 *
 * @author david
 */
public class BDUtilDAO {
    
    public static void crearTaulaAlumne() throws SQLException {

        BaseDAO.connect();
        Connection conn = BaseDAO.getConn();
        PreparedStatement stmt;

        String query = "CREATE TABLE IF NOT EXISTS alumnes ("
                     + "id INT AUTO_INCREMENT PRIMARY KEY, "
                     + "nom VARCHAR(50) NOT NULL, "
                     + "edat INT NOT NULL"
                     + ");";

        stmt = conn.prepareStatement(query);
        stmt.executeUpdate();
        stmt.close();

    }

    public static void netejaTaules() {
        BaseDAO.connect();
        Connection conn = BaseDAO.getConn();
        PreparedStatement stmt;
        try {
            String query = "delete from alumnes";
            stmt = conn.prepareStatement(query);
            stmt.executeUpdate();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void inserirDadesProva() throws SQLException {
        BaseDAO.connect();
        Connection conn = BaseDAO.getConn();
        PreparedStatement stmt;

        String query = "INSERT INTO alumnes (nom, edat) VALUES (?, ?), (?, ?), (?, ?)";
        stmt = conn.prepareStatement(query);
        stmt.setString(1, "Anna");
        stmt.setInt(2, 19);
        stmt.setString(3, "Joan");
        stmt.setInt(4, 21);
        stmt.setString(5, "Marta");
        stmt.setInt(6, 20);
        stmt.executeUpdate();
        stmt.close();
    }
    
    
    
    
    
    
}
