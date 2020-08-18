package com.jackie.concurrence.example.threadLocal;

/**
 * Created with IntelliJ IDEA
 * Description:
 *
 * @author xujj
 * @date 2020-08-18
 */
public class RequestHolder {
    private final static ThreadLocal<Long> requestHolder = new ThreadLocal<>();

    /**
     * 请求进入后端，但是还没开始执行时调用
     * @param id
     */
    public static void add(Long id){
        requestHolder.set(id);
    }

    public static Long getId(){
        return requestHolder.get();
    }

    /**
     * 接口处理完之后调用
     */
    public static void remove(){
        requestHolder.remove();
    }
}
