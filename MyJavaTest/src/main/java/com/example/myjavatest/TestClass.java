package com.example.myjavatest;

import com.example.myjavatest.producecomsumer.Consumer;
import com.example.myjavatest.producecomsumer.Producer;
import com.example.myjavatest.producecomsumer.PublicResource;
import com.google.gson.Gson;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class TestClass {

    public static void main(String[] args) {

        initTest();

    }

    private static void initTest() {
//        testPC();

//        testInsert();

//        FatherAdSon.testSuperMethod();

//        MyExceptionTest.test();
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

    public static <T> List<T> insert(int startIndex, int showInterval, String aa, List<T> list) {
        Object object = null;
        int addedAdCount = 0;
        for (int i = 0 ; i < list.size(); i++) {
            if (i == (showInterval * addedAdCount + startIndex)) {
                System.out.println("insert aa: "+aa+", i :"+ i);
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

    public static void testPC() {
        PublicResource p = new PublicResource();
        new Thread(new Producer(p, "生产者 1 号")).start();
//        new Thread(new Producer(p, "生产者 2 号")).start();
        new Thread(new Consumer(p, "消费者 1 号")).start();
    }
}


