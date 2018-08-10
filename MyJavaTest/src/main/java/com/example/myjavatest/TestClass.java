package com.example.myjavatest;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class TestClass {

    private static ArrayList<StringItem> list = new ArrayList();

    public static void main(String[] args) {

//        int ii = 1402733340;
//        StringBuilder sb = new StringBuilder("result is ");
//        sb.append(timet(ii)).append("    end");
//        System.out.println("结果为：sss3 :"+sb);

//        insertItem();
//        System.out.println("结果为：sss3 :"+getURLEncoderString("+8618616320848"));

        List<String> list = new ArrayList<>();
        list.add("a");
        list.add("b");
        list.add(null);
        list.add("c");

        for (String str: list) {
            if(str == null){
                continue;
            }
        }

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String s = it.next();
            if(s == null){
                continue;
            }
            System.out.println("结果为：sss3 :"+s);
        }

        Demo demo = new Demo();
        demo.show("good");
        demo.show(new Integer(5));

        test(demo);
        System.out.println("结果为：zzz3 :"+demo.testStr);
    }

    public static String timet(long time) {
        SimpleDateFormat sdr = new SimpleDateFormat("MM月dd日HH:mm");
        String times = sdr.format(new Date(time * 1000L));
        return times;
    }

    public static void insertItem(){
        list.add(new StringItem("1"));
        list.add(new StringItem("2"));
//        list.add(0,"3");
        System.out.println("结果为：sss3 :"+list.toString());
    }

    static class StringItem{
        StringItem(String name){
            this.name = name;
        }
        String name;
    }

    public static String getURLEncoderString(String str) {
        String result = "";
        if (null == str) {
            return "";
        }
        try {
            result = java.net.URLEncoder.encode(str, "UTF-8");
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        return result;
    }

    static class Demo{
        public String testStr;
        public <T> void show(T t) {
            System.out.println("sss4 :" + t);
        }
    }

    public static void test(Demo demo) {
        demo.testStr = "aaaa";
    }
}


