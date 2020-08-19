package com.wang.reflection;

public class test05 {
    public static void main(String[] args) {
        A a = new A();
        System.out.println(A.m);

        /*
        1.加载到内存,会产生一个类对应的Class对象
        2.链接,链接结束后m被初始化为0
        3.初始化
            <clinit>(){
                   System.out.println("A类静态代码块初始化");
                   m = 300;
                   m = 100;
                   }
             合并静态代码(static)
             合并静态代码的顺序遵循写代码时的顺序
             此时m=100
         */
    }
}
/*
静态代码块优先于构造块执行
构造块优先于方法调用执行
 */
class A {

    static {
        System.out.println("A类静态代码块初始化");
        m = 300;
    }

    static int m = 100;

    public A() {
        System.out.println("A类的无参构造初始化");
    }
}
