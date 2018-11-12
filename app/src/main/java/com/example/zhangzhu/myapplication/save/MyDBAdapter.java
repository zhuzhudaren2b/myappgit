package com.example.zhangzhu.myapplication.save;
//
///**
// * Created by zhangzhu on 2018/11/10.
// */
//
public class MyDBAdapter {
//    public void save(Person p)
//    {
//        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
//        db.execSQL("INSERT INTO person(name,phone) values(?,?)",
//                new String[]{p.getName(),p.getPhone()});
//    }
//
//    public void delete(Integer id)
//    {
//        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
//        db.execSQL("DELETE FROM person WHERE personid = ?",
//                new String[]{id});
//    }
//
//    public void update(Person p)
//    {
//        SQLiteDatabase db = dbOpenHelper.getWritableDatabase();
//        db.execSQL("UPDATE person SET name = ?,phone = ? WHERE personid = ?",
//                new String[]{p.getName(),p.getPhone(),p.getId()});
//    }
//
//    public Person find(Integer id)
//    {
//        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
//        Cursor cursor =  db.rawQuery("SELECT * FROM person WHERE personid = ?",
//                new String[]{id.toString()});
//        //存在数据才返回true
//        if(cursor.moveToFirst())
//        {
//            int personid = cursor.getInt(cursor.getColumnIndex("personid"));
//            String name = cursor.getString(cursor.getColumnIndex("name"));
//            String phone = cursor.getString(cursor.getColumnIndex("phone"));
//            return new Person(personid,name,phone);
//        }
//        cursor.close();
//        return null;
//    }
//
//    public List<Person> getScrollData(int offset,int maxResult)
//    {
//        List<Person> person = new ArrayList<Person>();
//        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
//        Cursor cursor =  db.rawQuery("SELECT * FROM person ORDER BY personid ASC LIMIT= ?,?",
//                new String[]{String.valueOf(offset),String.valueOf(maxResult)});
//        while(cursor.moveToNext())
//        {
//            int personid = cursor.getInt(cursor.getColumnIndex("personid"));
//            String name = cursor.getString(cursor.getColumnIndex("name"));
//            String phone = cursor.getString(cursor.getColumnIndex("phone"));
//            person.add(new Person(personid,name,phone)) ;
//        }
//        cursor.close();
//        return person;
//    }
//
//    public long getCount()
//    {
//        SQLiteDatabase db = dbOpenHelper.getReadableDatabase();
//        Cursor cursor =  db.rawQuery("SELECT COUNT (*) FROM person",null);
//        cursor.moveToFirst();
//        long result = cursor.getLong(0);
//        cursor.close();
//        return result;
//    }
}
