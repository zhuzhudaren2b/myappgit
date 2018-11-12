package com.example.myjavatest;

/**
 * Created by zhangzhu on 2018/10/23.
 */

public class FatherAdSon {

    static {
        //static代码块只加载一次
        System.out.println("load static code");
    }

    public static void testSuperMethod() {
        FatherAdSon fs = new FatherAdSon();
        FatherAdSon.Father son = fs.new Son();
        son.test();
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
}
