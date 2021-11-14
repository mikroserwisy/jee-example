package pl.training.calculator.view;

import jakarta.inject.Inject;
import pl.training.calculator.controller.CalculatorController;

import java.util.Map;

public class MenuView extends TextView {

    @Inject
    public MenuView(CalculatorController calculatorController) {
        super(calculatorController);
    }

    @Override
    public void render(Map<String, Object> data) {
        System.out.println("Menu");
        System.out.println("1 - Dodaj");
        System.out.println("2 - Usuń");
        System.out.println("3 - Wyjdź");
        var option = scanner.next();
        calculatorController.menuOptionSelected(option);
    }

}
