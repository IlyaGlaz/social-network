package org.glaz.network.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Slf4j
@Aspect
@Component
public class CommonAspect {

    @Pointcut("within(org.glaz.network.service.*Service)")
    public void isServiceLayer() {
    }
}
