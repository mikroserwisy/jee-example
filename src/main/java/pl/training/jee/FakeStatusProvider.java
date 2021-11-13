package pl.training.jee;

import javax.ejb.Stateless;

@Stateless
public class FakeStatusProvider implements StatusProvider{

    @Override
    public String getStatus(String name) {
        return "Ready";
    }

}
