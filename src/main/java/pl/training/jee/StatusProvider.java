package pl.training.jee;

import javax.ejb.Local;

@Local
public interface StatusProvider {

    String getStatus(String name);

}
