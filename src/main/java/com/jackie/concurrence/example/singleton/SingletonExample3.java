package com.jackie.concurrence.example.singleton;

import com.jackie.concurrence.annotations.NotRecommend;
import com.jackie.concurrence.annotations.ThreadSafe;

/**
 * Created with IntelliJ IDEA
 * Description:懒汉模式
 * 单例实例在第一次使用时进行创建
 *
 * @author xujj
 * @date 2020-08-04
 */
@ThreadSafe
@NotRecommend
public class SingletonExample3 {
    /**
     * 如果我们想保证一个类只能被初始化一次，
     * 那么首先要保证的是这个类不能随便new一个新的对象出来
     * 因此，这里默认的构造方法必须是私有的，不允许外面直接调用
     */
    private SingletonExample3() {

    }

    //单例对象
    private static SingletonExample3 instance = null;

    /**
     * 静态的工厂方法
     * 虽然synchronized保证了线程安全，但时却带来了性能上的开销，所以不推荐这种写法
     */
    public static synchronized SingletonExample3 getInstance(){
        if (instance == null){
            instance = new SingletonExample3();
        }
        return instance;
    }
}
