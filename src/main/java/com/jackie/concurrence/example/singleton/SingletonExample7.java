package com.jackie.concurrence.example.singleton;

import com.jackie.concurrence.annotations.Recommend;
import com.jackie.concurrence.annotations.ThreadSafe;

/**
 * Created with IntelliJ IDEA
 * Description:
 * 枚举模式：最安全
 * @author xujj
 */
@ThreadSafe
@Recommend
public class SingletonExample7 {
    //私有构造函数
    private SingletonExample7() {

    }

    public static SingletonExample7 getInstance(){
        return Singleton.INSTANCE.getSingleton();
    }

    private enum Singleton{
        INSTANCE;

        private SingletonExample7 singleton;

        //JVM保证这个方法绝对只调用一次
        Singleton() {
            singleton = new SingletonExample7();
        }

        public SingletonExample7 getSingleton(){
            return singleton;
        }
    }
}
