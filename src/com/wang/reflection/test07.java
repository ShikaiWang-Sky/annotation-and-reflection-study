package com.wang.reflection;

public class test07 {
    public static void main(String[] args) throws ClassNotFoundException {

        //获取系统类的加载器
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader);

        //获取系统类加载器的父类加载器-->扩展类加载器
        ClassLoader parent = systemClassLoader.getParent();
        System.out.println(parent);

        //获取扩展类加载器的父类加载器-->根加载器(c/c++)
        ClassLoader parentParent = parent.getParent();
        System.out.println(parentParent);

        //测试当前类是哪个加载器加载的-->系统类加载器
        ClassLoader classLoader = Class.forName("com.wang.reflection.test07").getClassLoader();
        System.out.println(classLoader);

        //测试JDK内部类是谁加载的-->根加载器
        ClassLoader classLoader1 = Class.forName("java.lang.Object").getClassLoader();
        System.out.println(classLoader1);

        //如何获得系统类加载器可以加载的路径

        System.out.println(System.getProperty("java.class.path"));
    }
}
