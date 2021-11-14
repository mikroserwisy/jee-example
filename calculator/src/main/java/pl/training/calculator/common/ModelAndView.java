package pl.training.calculator.common;

import lombok.Value;

import java.util.Map;

import static java.util.Collections.emptyMap;

@Value
public class ModelAndView {

   String viewName;
   Map<String, Object> data;

    public ModelAndView(String viewName, Map<String, Object> data) {
        this.viewName = viewName;
        this.data = data;
    }

    public ModelAndView(String viewName) {
        this(viewName, emptyMap());
    }

}
