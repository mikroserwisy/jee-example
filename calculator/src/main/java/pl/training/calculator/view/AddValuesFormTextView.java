package pl.training.calculator.view;

import jakarta.inject.Inject;
import pl.training.calculator.controller.CalculatorController;

import java.util.Map;

public class AddValuesFormTextView extends TextView {

    @Inject
    public AddValuesFormTextView(CalculatorController calculatorController) {
        super(calculatorController);
    }

    @Override
    public void render(Map<String, Object> data) {
        System.out.println("Podaj pierwszą liczbę");
        var firstNumber = scanner.next();
        System.out.println("Podaj drugą liczbę");
        var secondNumber = scanner.next();
        calculatorController.addNumbers(firstNumber, secondNumber);
    }

}
