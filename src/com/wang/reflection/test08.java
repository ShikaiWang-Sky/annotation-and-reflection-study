package com.wang.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//获取类的信息
public class test08 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        Class c1 = Class.forName("com.wang.reflection.User");

//        User user = new User();
//        Class c1 = user.getClass();

        //获得类的名字
        System.out.println(c1.getName());       //获得包名 + 类名
        System.out.println(c1.getSimpleName()); //获得类名

        //获得类的属性
        System.out.println("==============================");
        Field[] fields = c1.getFields();    //getFields()只能找到public属性
        //fields.for    -->     遍历数组的快捷键

        fields = c1.getDeclaredFields();    //getDeclaredFields()找到全部的属性
        for (Field field : fields) {
            System.out.println(field);
        }

        //获得指定属性的值
        System.out.println("===========================");
        Field name = c1.getDeclaredField("name");
        System.out.println(name);

        //获得类的方法
        System.out.println("=======================");
        Method[] methods = c1.getMethods();     //getMethods()获得本类及其父类的public方法
        for (Method method : methods) {
            System.out.println("正常的:" + method);
        }
        methods = c1.getDeclaredMethods();      //getDeclaredMethods()获得本类的所有方法
        for (Method method : methods) {
            System.out.println("getDeclaredMethods:" + method);
        }

        //获得指定方法
        //注意,要写获得方法的参数类型,无参数则为null,否则写参数的类(参数类型.class)  ---->   这是由于Java存在重载的特性
        System.out.println("=======================");
        Method getName = c1.getMethod("getName", null);
        Method setName = c1.getMethod("setName", String.class);
        System.out.println(getName);
        System.out.println(setName);

        //获得指定的构造器
        System.out.println("=======================");
        Constructor[] constructors = c1.getConstructors();
        for (Constructor constructor : constructors) {
            System.out.println(constructor);
        }
        constructors = c1.getDeclaredConstructors();
        for (Constructor constructor : constructors) {
            System.out.println("#" + constructor);
        }

        //获得指定的构造器
        Constructor constructor = c1.getConstructor(String.class, int.class, int.class);
        System.out.println(constructor);

    }
}
