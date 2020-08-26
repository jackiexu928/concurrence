package com.jackie.concurrence.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2020-08-25
 */
@Slf4j
public class CyclicBarrierExample3 {
    private static CyclicBarrier barrier = new CyclicBarrier(5, () -> {
        log.info("callback is running");//当线程到达这个屏障当时候，优先执行这个runnable
    });

    public static void main(String[] args) throws Exception{
        ExecutorService executorService = Executors.newCachedThreadPool();

        for (int i = 0; i < 10; i ++){
            final int threadNum = i;
            Thread.sleep(1000);
            executorService.execute(() -> {
                try {
                    race(threadNum);
                } catch (Exception e){
                    log.error("exception", e);
                }
            });
        }

    }
    private static void race(int threadNum) throws Exception{
        Thread.sleep(1000);
        log.info("{} is ready", threadNum);
        barrier.await();
        log.info("{} continue", threadNum);
    }
}
