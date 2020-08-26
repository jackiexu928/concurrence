package com.jackie.concurrence.example.lock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created with IntelliJ IDEA
 * Description:
 * 执行顺序：
 * 线程1 reentrantLock.lock();线程加入到了AQS等待队列中去
 * condition.await();线程从正常AQS队列中移除，其实是锁到释放，接着又加入到了condition的等待队列中去，该线程需要一个信号
 * 线程2因为线程1释放锁的关系，被唤醒，并判断是否可以取到锁，于是
 * ReentrantLock.lock();获取锁，也加入到了AQS等待队列中
 * condition.signalAll();调用发送信号方法
 * 这时condition等待队列里有线程1的节点，于是被取出，加入到AQS等待队列中，但并没有被唤醒
 * 线程2reentrantLock.unlock();释放锁，AQS中只剩线程1，唤醒线程1，线程1继续执行
 *
 * @author xujj
 * @date 2020-08-26
 */
@Slf4j
public class LockExample6 {
    public static void main(String[] args) {
        ReentrantLock reentrantLock = new ReentrantLock();
        Condition condition = reentrantLock.newCondition();

        new Thread(() -> {
            try {
                reentrantLock.lock();
                log.info("wait signal");    //1。等待信号
                condition.await();
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            log.info("get signal"); //4。得到信号
            reentrantLock.unlock();
        }).start();

        new Thread(() -> {
            reentrantLock.lock();
            log.info("get lock");   //2。
            try {
                Thread.sleep(3000);
            } catch (InterruptedException e){
                e.printStackTrace();
            }
            condition.signalAll();  //发送信号
            log.info("send signal ~");  //3。发送信号
            reentrantLock.unlock();
        }).start();
    }
}
