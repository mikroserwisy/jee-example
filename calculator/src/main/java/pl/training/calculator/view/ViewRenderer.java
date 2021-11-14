package pl.training.calculator.view;

import jakarta.annotation.PostConstruct;
import jakarta.enterprise.event.Observes;
import jakarta.enterprise.inject.Any;
import jakarta.enterprise.inject.Instance;
import jakarta.inject.Inject;
import lombok.Setter;

import java.util.HashMap;
import java.util.Map;

@Setter
public class ViewRenderer {

    @Inject @Any
    private Instance<View> views;
    private Map<String, View> viewsMap = new HashMap<>();

    @PostConstruct
    public void init() {
        views.forEach(view -> viewsMap.put(view.getName(), view));
    }

    public void onRender(@Observes ModelAndView modelAndView) {
        viewsMap.get(modelAndView.getViewName()).render(modelAndView.getData());
    }

}
