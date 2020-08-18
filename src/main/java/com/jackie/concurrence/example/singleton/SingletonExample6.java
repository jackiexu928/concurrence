package com.jackie.concurrence.example.singleton;

import com.jackie.concurrence.annotations.ThreadSafe;

/**
 * Created with IntelliJ IDEA
 * Description:饿汉模式
 * 单例实例在类装载时进行创建
 * 缺点：如果构造方法中存在过多的处理，会导致这个类在加载的时候特别慢，因此可能会引起性能问题
 * 如果使用饿汉模式，只进行类加载，却没有实际调用，会造成资源浪费
 *
 * 因此在使用饿汉模式时要注意：
 * 1.私有构造函数在实现的时候没有太多的处理
 * 2.在实际过程中肯定会被使用，不会造成资源的浪费
 * @author xujj
 * @date 2020-08-04
 */
@ThreadSafe
public class SingletonExample6 {
    /**
     * 如果我们想保证一个类只能被初始化一次，
     * 那么首先要保证的是这个类不能随便new一个新的对象出来
     * 因此，这里默认的构造方法必须是私有的，不允许外面直接调用
     */
    private SingletonExample6() {

    }
    //单例对象
    private static SingletonExample6 instance = null;

    /**
     * 静态域和静态代码块要注意顺序，顺序不同，执行的结果会有所不同。
     */
    static {
        instance = new SingletonExample6();
    }

    /**
     * 静态的工厂方法
     */
    public static SingletonExample6 getInstance(){
        return instance;
    }

    public static void main(String[] args) {
        System.out.println(getInstance().hashCode());
        System.out.println(getInstance().hashCode());
    }
}
