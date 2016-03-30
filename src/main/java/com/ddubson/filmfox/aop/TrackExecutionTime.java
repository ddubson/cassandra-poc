package com.ddubson.filmfox.aop;

import java.lang.annotation.*;

/**
 * Author: ddubson
 */
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
@Inherited
@Documented
public @interface TrackExecutionTime {

}
