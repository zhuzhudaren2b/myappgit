package com.example.zhangzhu.myapplication.testclass;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;

/**
 * Created by zhangzhu on 2018/7/5.
 */

public class TestClass implements Parcelable{
    private String name;
    private int age;
    private List<String> list;

    protected TestClass(Parcel in) {
        name = in.readString();
        age = in.readInt();
        list = in.createStringArrayList();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeInt(age);
        dest.writeStringList(list);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<TestClass> CREATOR = new Creator<TestClass>() {
        @Override
        public TestClass createFromParcel(Parcel in) {
            return new TestClass(in);
        }

        @Override
        public TestClass[] newArray(int size) {
            return new TestClass[size];
        }
    };
}
