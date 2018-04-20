package com.example.myjavatest;

import java.io.UnsupportedEncodingException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class TestClass {

    private static ArrayList<StringItem> list = new ArrayList();

    public static void main(String[] args) {

//        int ii = 1402733340;
//        StringBuilder sb = new StringBuilder("result is ");
//        sb.append(timet(ii)).append("    end");
//        System.out.println("结果为：sss3 :"+sb);

//        insertItem();
//        System.out.println("结果为：sss3 :"+getURLEncoderString("+8618616320848"));


        switch(2){
            case 1:
                System.out.println("sss3 : 1");
                break;
            case 2:
                System.out.println("sss3 : 2");

        }
        System.out.println("sss3 : 3");
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

    class TestInnerClass{

    }
}


