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

    private static final String VIEW_SUFFIX = "View";

    @Inject @Any
    private Instance<View> views;
    private Map<String, View> mappings = new HashMap<>();

    @PostConstruct
    public void init() {
        views.forEach(view -> mappings.put(mapName(view.getName()), view));
    }

    private String mapName(String viewName) {
        return viewName.substring(0, viewName.lastIndexOf(VIEW_SUFFIX));
    }

    public void onRender(@Observes ModelAndView modelAndView) {
        mappings.get(modelAndView.getViewName()).render(modelAndView.getData());
    }

}
