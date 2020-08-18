package com.jackie.concurrence.example.immutable;

import com.google.common.collect.Maps;
import com.jackie.concurrence.annotations.NotThreadSafe;
import lombok.extern.slf4j.Slf4j;

import java.util.Map;

/**
 * Created with IntelliJ IDEA
 * Description:
 * final
 *
 * @author xujj
 * @date 2020-08-17
 */
@Slf4j
@NotThreadSafe
public class ImmutableExample1 {
    private final static Integer a = 1;
    private final static String b = "2";
    private final static Map<Integer, Integer> map = Maps.newHashMap();

    static {
        map.put(1, 2);
        map.put(3, 4);
        map.put(5, 6);
    }

    public static void main(String[] args) {
        map.put(1, 3);
        log.info("{}", map.get(1));
    }

    private void test(final int a){
        //a不允许修改
        //a = 1;
    }
}
