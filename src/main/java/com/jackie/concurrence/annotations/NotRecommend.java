package com.jackie.concurrence.annotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Created with IntelliJ IDEA
 * Description:用来标记【不推荐】的类或者写法
 *
 * @author xujj
 * @date 2020-07-29
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.SOURCE )
public @interface NotRecommend {
    String value() default "";

}
