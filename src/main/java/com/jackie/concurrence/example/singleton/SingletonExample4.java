package com.jackie.concurrence.example.singleton;

import com.jackie.concurrence.annotations.NotRecommend;
import com.jackie.concurrence.annotations.NotThreadSafe;
import com.jackie.concurrence.annotations.ThreadSafe;

/**
 * Created with IntelliJ IDEA
 * Description:懒汉模式 -》双重同步锁单例模式
 * 单例实例在第一次使用时进行创建
 *
 * @author xujj
 * @date 2020-08-04
 */
@NotThreadSafe
public class SingletonExample4 {
    /**
     * 如果我们想保证一个类只能被初始化一次，
     * 那么首先要保证的是这个类不能随便new一个新的对象出来
     * 因此，这里默认的构造方法必须是私有的，不允许外面直接调用
     */
    private SingletonExample4() {

    }

    //1、memory = allocate() 分配对象的内存空间
    //2、ctorInstance() 初始化对象
    //3、instance = memory 设置instance指向刚分配的内存

    //JVM和cpu优化，发生了指令重排，导致双重检测机制不再好用

    //1、memory = allocate() 分配对象的内存空间
    //3、instance = memory 设置instance指向刚分配的内存
    //2、ctorInstance() 初始化对象

    //单例对象
    private volatile static SingletonExample4 instance = null;

    /**
     * 静态的工厂方法
     *
     */
    public static SingletonExample4 getInstance(){
        if (instance == null){//双重检测机制
            synchronized (SingletonExample4.class) {//同步锁
                if (instance == null) {
                    instance = new SingletonExample4();
                }
            }
        }
        return instance;
    }
}
