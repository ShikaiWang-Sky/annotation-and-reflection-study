package com.wang.reflection;

import java.sql.SQLOutput;

//测试类什么时候会初始化
public class test06 {

    static {
        System.out.println("Main类被加载");
    }

    public static void main(String[] args) throws ClassNotFoundException {
        //1.主动引用:先初始化父类再初始化子类(当虚拟机启动,先初始化main方法所在的类)
        //Son son = new Son();

        //2.反射也会产生主动引用
        //Class.forName("com.wang.reflection.Son");

        //不会产生类的引用的方法:子类调用父类的静态变量,不会导致子类被初始化
        //System.out.println(Son.b);

        //通过数组定义类引用,不会触发此类的初始化
        //Son[] array = new Son[5];

        //引用常量(final)不会触发此类的初始化
        System.out.println(Son.M);

    }

}

class Father {

    static int b = 2;

    static {
        System.out.println("父类被加载");
    }
}

class Son extends Father {

    static {
        System.out.println("子类被加载");
        m = 300;
    }

    static int m = 100;
    static final int M = 1;
}
