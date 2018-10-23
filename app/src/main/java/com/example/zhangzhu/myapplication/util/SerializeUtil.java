package com.example.zhangzhu.myapplication.util;

import android.content.Context;

import com.example.zhangzhu.myapplication.MyApplication;
import com.example.zhangzhu.myapplication.testclass.Son;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OptionalDataException;
import java.io.StreamCorruptedException;

/**
 * Created by zhangzhu on 2018/9/30.
 */

public class SerializeUtil {

    public static void testWrite() {
        Son son = new Son();
        son.name = "hello";
        SerializeUtil.write("test.cache", son);
    }

    public static void testRead() {
        Son son = (Son) SerializeUtil.read("test.cache");
        DialerToast.showMessage(MyApplication.context, son.name, 1);
    }

    public static boolean write(String targetFileName, Object object) {
        boolean ret = false;
        ObjectOutputStream writer = null;
        try {
            writer = new ObjectOutputStream(MyApplication.context
                    .openFileOutput(targetFileName, Context.MODE_PRIVATE));
            if (writer != null) {
                writer.writeObject(object);
                ret = true;
            }
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    // Ignore;
                }
            }
        }
        return ret;
    }

    public static Object read(String targetFileName) {
        Object ret = null;
        ObjectInputStream reader = null;
        try {
            reader = new ObjectInputStream(MyApplication.context
                    .openFileInput(targetFileName));
            if (reader != null) {
                ret = reader.readObject();
            }
        } catch (FileNotFoundException e) {
            // that's OK.
            // do nothing.
        } catch (StreamCorruptedException e) {
        } catch (OptionalDataException e) {
        } catch (ClassNotFoundException e) {
        } catch (IOException e) {
        }catch (IllegalArgumentException e) {
        } catch (ArrayIndexOutOfBoundsException e) {
        } catch (IndexOutOfBoundsException e) {
        } catch (ClassCastException e) {
        } finally {
            if (reader != null) {
                try {
                    reader.close();
                } catch (IOException e) {
                    // ignore;
                }
            }
        }
        return ret;
    }
}
