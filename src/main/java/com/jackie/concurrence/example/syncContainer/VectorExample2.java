package com.jackie.concurrence.example.syncContainer;

import com.jackie.concurrence.annotations.NotThreadSafe;

import java.util.Vector;

/**
 * Created with IntelliJ IDEA
 * Description:
 * 会报数组下标越界异常
 * 同步容器的两个同步方法，因为操作顺序的差异，不同的线程里面，可能会触发线程安全问题
 *
 * @author xujj
 * @date 2020-08-18
 */
@NotThreadSafe
public class VectorExample2 {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        while (true) {
            for (int i = 0; i < 10; i++) {
                vector.add(i);
            }

            Thread thread1 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.remove(i);
                    }
                }
            };

            Thread thread2 = new Thread() {
                public void run() {
                    for (int i = 0; i < vector.size(); i++) {
                        vector.get(i);
                    }
                }
            };

            thread1.start();
            thread2.start();
        }

    }
}
