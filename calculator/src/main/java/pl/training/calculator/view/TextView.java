package pl.training.calculator.view;


import pl.training.calculator.controller.CalculatorController;

import java.util.Scanner;

public abstract class TextView implements View {

    protected final Scanner scanner = new Scanner(System.in);
    protected final CalculatorController calculatorController;

    public TextView(CalculatorController calculatorController) {
        this.calculatorController = calculatorController;
    }

}
