package com.wang.reflection;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

//动态的创建对象,通过反射
public class test09 {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException, NoSuchFieldException {
        //获得Class对象
        Class c1 = Class.forName("com.wang.reflection.User");

//        //构造一个对象:newInstance()
//        User user = (User)c1.newInstance();     //本质上是调用了类的无参构造器
//        System.out.println(user);
//
//        //通过构造器创建对象(如果没有写无参构造器),通过已有的构造器创建
//        /*
//        先获取类对象
//        然后获取有参构造
//        通过有参构造获取对象
//         */
//        Constructor constructor = c1.getDeclaredConstructor(String.class, int.class, int.class);
//        User user2 = (User) constructor.newInstance("wang", 001, 18);
//        System.out.println(user2);

        //通过反射调用普通方法
        User user3 = (User)c1.newInstance();
        //通过反射获取一个方法
        Method setName = c1.getDeclaredMethod("setName", String.class);

        //invoke:激活
        //方法.invoke(对象,"方法的值")
        setName.invoke(user3, "wang");
        System.out.println(user3.getName());

        //通过反射操作属性
        System.out.println("===========================");
        User user4 = (User)c1.newInstance();
        Field name = c1.getDeclaredField("name");

        //不能直接操作私有属性,我们需要关闭程序的安全监测,通过属性或方法的setAccessible(true)
        name.setAccessible(true);
        name.set(user4, "wang_sky");
        System.out.println(user4.getName());
    }
}
