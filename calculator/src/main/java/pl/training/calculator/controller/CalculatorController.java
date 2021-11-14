package pl.training.calculator.controller;

import jakarta.enterprise.event.Event;
import jakarta.inject.Inject;
import pl.training.calculator.model.Calculator;
import pl.training.calculator.view.ModelAndView;

import java.math.BigDecimal;
import java.util.Map;

public class CalculatorController {

    private final Calculator calculator;
    private final Event<ModelAndView> dispatcher;

    @Inject
    public CalculatorController(Calculator calculator, Event<ModelAndView> dispatcher) {
        this.calculator = calculator;
        this.dispatcher = dispatcher;
    }

    public void showDefaultView() {
        dispatcher.fire(new ModelAndView("MenuTextView"));
    }

    public void optionSelected(String option) {
        switch (option) {
            case "1":
                dispatcher.fire(new ModelAndView("AddValuesTextView"));
                break;
            default:
                throw new IllegalStateException();
        }
    }

    public void addNumbers(String firstNumber, String secondNumber) {
        var result = calculator.add(new BigDecimal(firstNumber), new BigDecimal(secondNumber));
        dispatcher.fire(new ModelAndView("ResultTextView", Map.of("result", result)));
    }

}
