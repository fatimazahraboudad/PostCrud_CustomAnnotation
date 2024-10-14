package com.example.ProjectWithCustomAnnotation.aspect;

import com.example.ProjectWithCustomAnnotation.Annotation.RequestLogger;
import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

@Aspect
@Component
@Slf4j
public class LoggerAspect {

    @Around("@annotation(requestLogger)")
    public Object logRequest(ProceedingJoinPoint joinPoint,  RequestLogger requestLogger) throws Throwable {
        HttpServletRequest request = ((ServletRequestAttributes) RequestContextHolder.currentRequestAttributes()).getRequest();
        if (requestLogger.enabled()) {
            log.info("{} : Request received", request.getRequestURI());
            Object obj = joinPoint.proceed();
            log.info("{} : Request finished", request.getRequestURI());
            return obj;
        } else {
            log.warn("{} : Request received but logging is disabled", request.getRequestURI());
            return joinPoint.proceed();
        }
    }
}
