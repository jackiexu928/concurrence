package com.jackie.concurrence.example.publish;

import com.jackie.concurrence.annotations.NotRecommend;
import com.jackie.concurrence.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2020-08-04
 */
@Slf4j
@NotThreadSafe
@NotRecommend
public class Escape {
    private int thisCanBeExcape = 0;

    public Escape() {
        new InnerClass();
    }

    private class InnerClass{
        public InnerClass(){
            log.info("{}", Escape.this.thisCanBeExcape);
        }
    }

    public static void main(String[] args) {
        new Escape();
    }
}
