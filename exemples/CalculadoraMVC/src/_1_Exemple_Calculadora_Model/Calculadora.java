package _1_Exemple_Calculadora_Model;

/**
 *
 * @author david
 */
public class Calculadora {

    private String model;
    private String tipus;

    public Calculadora(String model, String tipus) {
        this.model = model;
        this.tipus = tipus;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTipus() {
        return tipus;
    }

    public void setTipus(String tipus) {
        this.tipus = tipus;
    }

    public int suma(int a, int b) {
        return a + b;
    }

    public int resta(int a, int b) {
        return a - b;
    }

    public int multiplicacio(int a, int b) {
        return a * b;
    }

    public int divisio(int a, int b) {
        return a / b;
    }

}
