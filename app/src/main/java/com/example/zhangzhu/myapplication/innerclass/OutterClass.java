package com.example.zhangzhu.myapplication.innerclass;

/**
 * Created by zhangzhu on 2018/10/23.
 */

public class OutterClass {
    int outData;
    InnerClass innerClass;

    public void createMethodInnerClass() {
        //局部内部类只在该方法中有效，无法被外部类之外的类访问。无需访问符和static修饰符。
        class ClassInMethod {
            int a;
            int b;
        }
        ClassInMethod  uc = new ClassInMethod ();
        uc.a = 1;
        uc.b = 2;
    }

    public InnerClass getSomethingNew() {
        innerClass = new InnerClass();//外部类访问内部类，必须创建一个内部类的实例
        innerClass.getInData();
        return innerClass;
    }

    public class InnerClass {
        int inData;
        int outData;
        public int getInData() {
            return inData;
        }
        public int getOutData() {
            return outData;//可以无条件获取外部类的成员变量及方法
        }
    }

    public void test() {
        //内部类和外部类成员变量或方法同名时会发生隐藏，需要这样访问外部类变量
        OutterClass oc = new OutterClass();
        OutterClass.this.outData = 1;

        //创建静态内部类对象的一般形式为：  外部类类名.内部类类名 xxx = new 外部类类名.内部类类名()
        //创建成员内部类对象的一般形式为：  外部类类名.内部类类名 xxx = 外部类对象名.new 内部类类名()
        OutterClass.InnerClass oic = oc.new InnerClass();//内部实例必须通过outclass实例创建
        oic.getOutData();

        //匿名内部类，应该是平时我们编写代码时用得最多的，在编写事件监听的代码时使用匿名内部类不但方便，而且使代码更加容易维护
        //匿名内部类无构造方法
    }
}
