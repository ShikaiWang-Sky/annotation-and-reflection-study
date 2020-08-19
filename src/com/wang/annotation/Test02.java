package com.wang.annotation;

import java.lang.annotation.*;

//测试元注解
@MyAnnotation
public class Test02 {

    @MyAnnotation
    public void test() {

    }
}

//定义一个注解
//Target 表示我们的注解可以用在哪些地方
//METHOD：方法     TYPE：类
@Target(value = {ElementType.METHOD, ElementType.TYPE})

//Retention 表示我们的注解在什么地方还有效
//RUNTIME > CLASS > SOURCE
@Retention(value = RetentionPolicy.RUNTIME)

//Documented 表示我们的注解生成在Javadoc中
@Documented

//Inherited 子类可以继承父类的注解
@Inherited

@interface MyAnnotation {

}

