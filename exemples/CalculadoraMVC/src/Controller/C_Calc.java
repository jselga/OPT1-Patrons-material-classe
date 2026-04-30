/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Controller;

import Model.M_Calc;
import View.V_Calc;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 *
 * @author jordi
 */
public class C_Calc implements ActionListener {

    private V_Calc v_calc;
    private M_Calc m_calc;

    public C_Calc() {
        v_calc = new V_Calc();
        m_calc = new M_Calc("SumaResta");
        v_calc.getjButton_calcular().addActionListener(this);
    }

    public void run() {
        v_calc.setVisible(true);
        loadComponents();
    }

    public void loadComponents() {
        v_calc.getjComboBox_operacions().addItem("Suma");
        v_calc.getjComboBox_operacions().addItem("Resta");
        v_calc.getjComboBox_operacions().addItem("Multiplicació");
        v_calc.getjComboBox_operacions().addItem("Divisió");

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        int num1, num2, op;
        num1 = Integer.parseInt(v_calc.getjTextField_num1().getText());
        num2 = Integer.parseInt(v_calc.getjTextField_num2().getText());

        if (v_calc.getjComboBox_operacions().getSelectedItem().equals("Suma")) {
            v_calc.getjTextField_resultat().setText("" + m_calc.suma(num1, num2));
        } else if (v_calc.getjComboBox_operacions().getSelectedItem().equals("Resta")) {
            v_calc.getjTextField_resultat().setText("" + m_calc.resta(num1, num2));
        } else {
            v_calc.getjTextField_resultat().setText("Operació no disponible encara...");
        }
    }

}
