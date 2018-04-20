package com.example.zhangzhu.myapplication;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class ExampleUnitTest {
    @Test
    public void addition_isCorrect() throws Exception {
        int sum = 2 + 2;
        System.out.println("结果为：" + sum);
//        assertEquals(4, sum);

    }

    /**
     * @throws Exception
     */
    @Test
    public void testMode() throws Exception {

        boolean b=true?false:true?false:true;
//        boolean b = fun3() ? fun4() : fun5();
//        System.out.println("b结果为：" + b);
        System.out.println("b结果为：");
//        assertEquals(4, sum);
    }
}