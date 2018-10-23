package com.example.myjavatest;

/**
 * Created by zhangzhu on 2018/10/23.
 */

public class MyExceptionTest {
    public void regist(int num) throws MyException {
        if (num < 0) {
            throw new MyException("人数为负值，不合理", 10000);
        }
        System.out.println("登记人数:" + num);
    }

    public void manager() {
        try {
            regist(-10);
        } catch(MyException e) {
            System.out.println("登记失败，出错类型码: " + e.getId());
//            e.printStackTrace();
        }
        System.out.println("操作结束");
    }

    public static void test() {
        MyExceptionTest t = new MyExceptionTest();
        t.manager();
    }
}
