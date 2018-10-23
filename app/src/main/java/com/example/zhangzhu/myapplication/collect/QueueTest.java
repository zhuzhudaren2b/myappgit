package com.example.zhangzhu.myapplication.collect;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by zhangzhu on 2018/10/23.
 */

public class QueueTest {
    public QueueTest() {
        //add()和remove()方法在失败的时候会抛出异常(不推荐)
        Queue<String> queue = new LinkedList<String>();
        //添加元素
        queue.offer("a");
        queue.offer("b");
        queue.offer("c");
        queue.offer("d");
        queue.offer("e");
        for(String q : queue){
            System.out.println("zzzzz queue String : "+q);
        }
        System.out.println("zzzzz ===");
        System.out.println("zzzzz poll="+queue.poll()); //返回第一个元素，并在队列中删除
        for(String q : queue){
            System.out.println("zzzzz queue String : "+q);
        }
        System.out.println("zzzzz ===");
        System.out.println("zzzzz element="+queue.element()); //返回第一个元素
        for(String q : queue){
            System.out.println(q);
        }
        System.out.println("zzzzz ===");
        System.out.println("zzzzz peek="+queue.peek()); //返回第一个元素
        for(String q : queue){
            System.out.println("zzzzz queue String : "+q);
        }

    }
}
