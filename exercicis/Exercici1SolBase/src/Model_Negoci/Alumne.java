/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model_Negoci;

/**
 *
 * @author david
 */
public class Alumne {

    private int id;
    private String nom;
    private int edat;

    public Alumne(int id, String nom, int edat) {
        this.id = id;
        this.nom = nom;
        this.edat = edat;
    }

    public Alumne(String nom, int edat) {
        this.nom = nom;
        this.edat = edat;
    }

    public Alumne() {}
    

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public int getEdat() {
        return edat;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setEdat(int edat) {
        this.edat = edat;
    }

    @Override
    public String toString() {
        return "Alumne{" + "id=" + id + ", nom='" + nom + '\'' + ", edat=" + edat + '}';
    }
}

