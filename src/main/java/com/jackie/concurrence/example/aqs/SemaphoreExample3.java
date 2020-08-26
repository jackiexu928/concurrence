package com.jackie.concurrence.example.aqs;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2020-08-24
 */
@Slf4j
public class SemaphoreExample3 {

    private static int threadCount = 200;

    public static void main(String[] args) throws Exception{
        ExecutorService exec = Executors.newCachedThreadPool();

        final Semaphore semaphore = new Semaphore(3);
        for (int i = 0; i < threadCount; i ++){
            final int threadNum = i;
            exec.execute(() -> {
                try {
                    //执行3次之后则不再执行
                    //if(semaphore.tryAcquire()){//尝试获取一个许可
                    if (semaphore.tryAcquire(5000, TimeUnit.MILLISECONDS)){//尝试获取一个许可，如果没获取到，可以等1秒，直到获取到位为止，如果1秒内没有获取到许可，则就没有获取到许可
                        test(threadNum);
                        semaphore.release();//释放一个许可
                    }
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
