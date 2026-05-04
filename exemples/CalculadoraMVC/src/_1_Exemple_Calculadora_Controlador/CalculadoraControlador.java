package _1_Exemple_Calculadora_Controlador;

import _1_Exemple_Calculadora_Model.Calculadora;
import _1_Exemple_Calculadora_Vista.CalculadoraVista;
import _1_Exemple_Calculadora_Vista.CalculadoraVista;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ButtonGroup;

/**
 * @author david
 */
public class CalculadoraControlador implements ActionListener {

    private CalculadoraVista calculadoraVista;
    private Calculadora calculadora;

    public CalculadoraControlador() {

        calculadoraVista = new CalculadoraVista();        
        calculadora = new Calculadora("TI-84 Plus", "Científica");
        calculadoraVista.getButton_calcular().addActionListener(this);

    }

    public void run() {

        calculadoraVista.setVisible(true);
        calculadoraVista.setTitle("Calculadora: " + calculadora.getModel());
        calculadoraVista.setLocationRelativeTo(null);
        carregarComponents();

    }

    public void carregarComponents() {
        calculadoraVista.getjComboBox_operacions().addItem("Suma");
        calculadoraVista.getjComboBox_operacions().addItem("Resta");
        calculadoraVista.getjComboBox_operacions().addItem("Multiplicació");
        calculadoraVista.getjComboBox_operacions().addItem("Divisió");

//        ButtonGroup buttonGroup = new ButtonGroup();
//        buttonGroup.add(v_cal.getjRadioButton_suma());
//        buttonGroup.add(v_cal.getjRadioButton_resta());
//        buttonGroup.add(v_cal.getjRadioButton_multiplicacio());
//        buttonGroup.add(v_cal.getjRadioButton_divisio());
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getActionCommand().equals("Calcular")) {

            int num1, num2, operacio;

            num1 = Integer.parseInt(calculadoraVista.getjTextField_num1().getText());
            num2 = Integer.parseInt(calculadoraVista.getjTextField_num2().getText());


            if (calculadoraVista.getjCheckBox_accepta().isSelected()) {

                if (calculadoraVista.getjComboBox_operacions().getSelectedItem().equals("Suma")) {
                    calculadoraVista.getjTextField_resultat().setText("" + calculadora.suma(num1, num2));

                } else if (calculadoraVista.getjComboBox_operacions().getSelectedItem().equals("Resta")) {
                    calculadoraVista.getjTextField_resultat().setText("" + calculadora.resta(num1, num2));

                } else if (calculadoraVista.getjComboBox_operacions().getSelectedItem().equals("Multiplicació")) {
                    calculadoraVista.getjTextField_resultat().setText("" + calculadora.multiplicacio(num1, num2));

                } else {
                    calculadoraVista.getjTextField_resultat().setText("" + calculadora.divisio(num1, num2));
                }
            } else {
                calculadoraVista.getjTextField_resultat().setText("Has d'acceptar fer l'operació");
            }
        }

    }

    

}
