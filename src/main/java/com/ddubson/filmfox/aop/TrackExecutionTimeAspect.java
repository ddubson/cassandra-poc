package com.ddubson.filmfox.aop;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StopWatch;

/**
 * Author: ddubson
 */
@Aspect
@Component
public class TrackExecutionTimeAspect {
    @Autowired
    Logger sysLog;
    StopWatch stopWatch = null;

    @Before("@annotation(com.ddubson.filmfox.aop.TrackExecutionTime)")
    public void start() {
        stopWatch = new StopWatch();
        stopWatch.start();
    }

    @After("@annotation(com.ddubson.filmfox.aop.TrackExecutionTime)")
    public void end() {
        if (stopWatch != null) {
            stopWatch.stop();
            sysLog.info(String.format("Task took %s seconds.", stopWatch.getTotalTimeSeconds()));
        }
    }
}
