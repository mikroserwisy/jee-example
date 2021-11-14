package pl.training.jee.cdi;

import lombok.extern.java.Log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Log
@LogInfo
@Interceptor
public class StopperInterceptor {

    @AroundInvoke
    public Object log(InvocationContext invocationContext) throws Exception {
        var startTime = System.nanoTime();
        var result = invocationContext.proceed();
        log.info("Total time: " + (System.nanoTime() - startTime) + " ns");
        return result;
    }

}
