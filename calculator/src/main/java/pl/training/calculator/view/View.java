package pl.training.calculator.view;

import java.util.Map;

public interface View {

    void render(Map<String, Object> data);

    String getName();

}
