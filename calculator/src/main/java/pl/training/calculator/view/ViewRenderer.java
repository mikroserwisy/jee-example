package pl.training.calculator.view;

import jakarta.enterprise.event.Observes;
import jakarta.inject.Inject;
import lombok.Setter;

import java.util.Collections;

import static java.util.Collections.emptyMap;

@Setter
public class ViewRenderer {

    @Inject
    private MenuTextView menuView;
    @Inject
    private AddValuesFormTextView addView;
    @Inject
    private ResultTextView resultView;

    public void onModelAndView(@Observes ModelAndView modelAndView) {
        TextView textView;
        switch (modelAndView.getViewName()) {
            case "menu":
                textView = menuView;
                break;
            case "add":
                textView = addView;
                break;
            case "result":
                textView = resultView;
                break;
            default:
                throw  new IllegalStateException();
        }
        textView.render(modelAndView.getData());
    }

}
