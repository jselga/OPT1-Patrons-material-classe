/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Model;

/**
 *
 * @author jordi
 */
public class M_Calc {

    private String nom;
    private String descripcio;

    public M_Calc(String nom) {
        this.nom = nom;
        this.descripcio = "default text";

    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public void setDescripcio(String descripcio) {
        this.descripcio = descripcio;
    }

//    Operacions
    public int suma(int n1, int n2) {
        return n1 + n2;
    }

    public int resta(int n1, int n2) {
        return n1 - n2;
    }

    public int mult(int n1, int n2) {
        return 0;
    }

    public int op4(int n1, int n2) {
        return 0;
    }

}
