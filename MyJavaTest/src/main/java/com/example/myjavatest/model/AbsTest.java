package com.example.myjavatest.model;

/**
 * Created by zhangzhu on 2019/3/20.
 */

public abstract class AbsTest implements ITest{
    @Override
    public void add() {
        System.out.println("add ....");
    }

    @Override
    public void remove() {
        System.out.println("remove ....");
    }
}
