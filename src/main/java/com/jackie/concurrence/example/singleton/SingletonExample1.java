package com.jackie.concurrence.example.singleton;

import com.jackie.concurrence.annotations.NotThreadSafe;

/**
 * Created with IntelliJ IDEA
 * Description:懒汉模式
 * 单例实例在第一次使用时进行创建
 *
 * @author xujj
 * @date 2020-08-04
 */
@NotThreadSafe
public class SingletonExample1 {
    /**
     * 如果我们想保证一个类只能被初始化一次，
     * 那么首先要保证的是这个类不能随便new一个新的对象出来
     * 因此，这里默认的构造方法必须是私有的，不允许外面直接调用
     */
    private SingletonExample1() {

    }

    //单例对象
    private static SingletonExample1 instance = null;

    /**
     * 静态的工厂方法
     * 在单线程模式下没有问题，
     * 但是在多线程环境下，就可能出现问题
     */
    public static SingletonExample1 getInstance(){
        if (instance == null){
            instance = new SingletonExample1();
        }
        return instance;
    }
}
