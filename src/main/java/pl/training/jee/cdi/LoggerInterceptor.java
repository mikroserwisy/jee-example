package pl.training.jee.cdi;

import lombok.extern.java.Log;

import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

@Log
@LogInfo
@Interceptor
public class LoggerInterceptor {

    @AroundInvoke
    public Object log(InvocationContext invocationContext) throws Exception {
        log.info("Before go");
        var result = invocationContext.proceed();
        log.info("After go");
        return result;
    }

}
