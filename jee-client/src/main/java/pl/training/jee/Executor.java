package pl.training.jee;

import javax.ejb.Remote;
import java.util.Map;

@Remote
public interface Executor {

    void add(Map<String, String> data);

    void execute();


}
