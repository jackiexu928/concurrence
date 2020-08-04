package com.jackie.concurrence.example.atomic;

import com.jackie.concurrence.annotations.ThreadSafe;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReference;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2020-08-02
 */
@Slf4j
@ThreadSafe
public class AtomicExample5 {
    //核心作用：更新指定的类的某个字段的值，而这个字段必须要有volatile修饰，同时还是非static描述的字段
    private static AtomicIntegerFieldUpdater<AtomicExample5> updater =
            AtomicIntegerFieldUpdater.newUpdater(AtomicExample5.class, "count");

    @Getter
    public volatile int count = 100;

    public static void main(String[] args) {
        AtomicExample5 example5 = new AtomicExample5();

        if (updater.compareAndSet(example5, 100, 120)){
            log.info("update success, {}", example5.getCount());
        }

        if (updater.compareAndSet(example5, 100, 120)){
            log.info("update success, {}", example5.getCount());
        } else {
            log.info("update failed, {}", example5.getCount());
        }
    }
}
