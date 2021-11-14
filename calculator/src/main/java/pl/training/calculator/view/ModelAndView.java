package pl.training.calculator.view;

import lombok.Getter;

import java.util.HashMap;
import java.util.Map;

@Getter
public class ModelAndView {

    private final String viewName;
    private final Map<String, Object> data;

    public ModelAndView(String viewName) {
        this.viewName = viewName;
        data = new HashMap<>();
    }

    public ModelAndView(String viewName, Map<String, Object> data) {
        this.viewName = viewName;
        this.data = data;
    }

}
