package pl.training.calculator.view;

import jakarta.inject.Inject;
import pl.training.calculator.controller.CalculatorController;

import java.util.Map;

public class ResultView extends TextView {

    @Inject
    public ResultView(CalculatorController calculatorController) {
        super(calculatorController);
    }

    @Override
    public void render(Map<String, Object> data) {
        System.out.println("Result: " + data.get("result"));
        calculatorController.showMenu();
    }

}
