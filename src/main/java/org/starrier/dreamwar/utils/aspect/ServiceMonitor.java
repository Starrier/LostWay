package org.starrier.dreamwar.utils.aspect;

import lombok.extern.apachecommons.CommonsLog;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.Signature;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;
import org.starrier.dreamwar.utils.common.exception.ServerInternalErrorException;

import java.util.Arrays;

/**
 * @author Starrier
 * @Time 2018/6/8
 */
@CommonsLog
@Aspect
@Component
public class ServiceMonitor {

    private static final Logger LOGGER = LoggerFactory.getLogger(ServiceMonitor.class);

    /**
     * A join point is in the service layer if the method is defined
     * in a type in the com.shawn.service package or any sub-package
     * under that.
     */
    @Pointcut("execution(* org.starrier.dreamwar.service..*(..))")
    private void serviceLayer() {
    }

    /**
     * Monitor whether exception is thrown in service layer. If exception
     * has been thrown, in order to detecting it conveniently, log the
     * situation where it happened. Then create a server internal error
     * exception and throw it out.
     */
    @AfterThrowing(pointcut = "org.starrier.dreamwar.utils.aspect.ServiceMonitor.serviceLayer()monitor.ServiceMonitor.serviceLayer()", throwing = "e")
    public void monitorException(JoinPoint joinPoint, Throwable e) {
        // Log the situation where exception happened
        Object[] args = joinPoint.getArgs();
        Signature signature = joinPoint.getSignature();
        LOGGER.error("[" + signature.toShortString() + "]" + Arrays.toString(args) + "[" + e.toString() + "]");
        // Throw a new server internal error exception
        throw new ServerInternalErrorException();
    }

}
