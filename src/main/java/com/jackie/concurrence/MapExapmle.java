package com.jackie.concurrence;

import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2020-07-28
 */
public class MapExapmle {
    private static Map<Integer, Integer> map = new HashMap<>();
    private static int threadTotal = 1;
    private static int clientTotal = 5000;

    public static void main(String[] args) {
        ExecutorService exec = Executors.newCachedThreadPool();
        final Semaphore semaphore = new Semaphore(threadTotal);
        for (int index = 0; index < clientTotal; index ++){
            final int threadNum = index;
            exec.execute(() -> {
                try {
                    semaphore.acquire();
                    func(threadNum);
                    semaphore.release();
                } catch (Exception e){
                    System.out.println(e);
                }
            });
        }
        exec.shutdown();
        System.out.println(map.size());
    }

    public static void func(int threadNum){
        map.put(threadNum, threadNum);
    }
}
