package com.example.myjavatest;

import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class TestClass {
    public static void main(String[] args) {
//        testInsert();

//        Father son = new Son();
//        son.test();

//        printArray();
    }

    public static void printArray() {
        int[] intArray = {1,2,32};
        Map map = new HashMap();
        map.put(1, "first");
        map.put(2, "second");
        System.out.println("result :"+ Arrays.toString(intArray));
        Gson gson = new Gson();
        System.out.println("result2 :"+ gson.toJson(map));
    }


    private static void testInsert() {
        List<Integer> list = new ArrayList<>();
        for (int i =1; i<= 10; i++) {
            list.add(i);
        }
        int startIndex = 2;
        int interval = 5;
        for (int j =1; j<= 5; j++) {
            String aa = "test"+j;
            insert(startIndex, interval+1, aa, list);
        }
        for (Object obj:list) {
            System.out.println("result :"+ obj.toString());
        }
    }

    public static <T extends Object> List<T> insert(int startIndex, int showInterval, String aa, List<T> list) {
        Object object = null;
        int addedAdCount = 0;
        for (int i = 0 ; i < list.size(); i++) {
            if (i == (showInterval * addedAdCount + startIndex)) {
                object = list.get(i);
                if (!(object instanceof String)) {
                    if (!list.contains(aa)) {
                        list.add(i,(T)aa);
                        System.out.println("add :"+ i);
                    } else {
                        System.out.println("ignore_add : " + i);
                    }
                    break;
                } else {
                    addedAdCount++;
                }
            }
        }
        return list;
    }

}

class Son extends Father {
    public Son() {
        System.out.println("Son create");
    }

    void go() {
        test();
    }

    @Override
    void say() {
        System.out.println("Son say ~");
    }
}

class Father {
    public Father() {
        System.out.println("Father create");
    }
    void test() {
        say();
    }
    void say() {
        System.out.println("Father say ~");
    }
}

interface Iclass<T> {
    void cut(T t);
}

abstract class MyClass<T> implements Iclass<T> {
}

class MyRealClass<Father> extends MyClass<Father> {

    @Override
    public void cut(Father f) {

    }
}


