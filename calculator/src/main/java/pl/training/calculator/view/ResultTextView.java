package pl.training.calculator.view;

import jakarta.inject.Inject;
import pl.training.calculator.controller.CalculatorController;

import java.util.Map;

public class ResultTextView extends TextView {

    @Inject
    public ResultTextView(CalculatorController calculatorController) {
        super(calculatorController);
    }

    @Override
    public void render(Map<String, Object> data) {
        System.out.println("Result: " + data.get("result"));
        calculatorController.showDefaultView();
    }

}
