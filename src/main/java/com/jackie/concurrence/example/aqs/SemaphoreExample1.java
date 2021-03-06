package com.jackie.concurrence.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2020-08-24
 */
@Slf4j
public class SemaphoreExample1 {

    private static int threadCount = 200;

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i ++){
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    semaphore.acquire(3);//获取多个许可
                    test(threadNum);
                    semaphore.release(3);//释放多个许可
                } catch (Exception e){
                    log.error("exception", e);
                } finally {
                }
            });
        }
        log.info("finish");
        exec.shutdown();
    }

    private static void test(int threadNum) throws Exception{
        log.info("{}", threadNum);
        Thread.sleep(1000);
    }
}
