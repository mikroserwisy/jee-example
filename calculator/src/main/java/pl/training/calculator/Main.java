package pl.training.calculator;

import org.jboss.weld.environment.se.Weld;
import pl.training.calculator.controller.CalculatorController;

public class Main {

    public static void main(String[] args) {
        var weld = new Weld();
        var container = weld.initialize();

        var controller = container.select(CalculatorController.class).get();
        controller.showDefaultView();

        container.shutdown();
    }

}
