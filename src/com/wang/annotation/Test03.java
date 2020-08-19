package com.wang.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

//自定义注解
public class Test03 {
    //注解可以显式赋值，如果没有默认值，我们就必须给注解赋值
    @MyAnnotation2(name = "wang", age = 18, id = 1, schools = {"WPI","NEU"})
    private void test() {}

    //如果注解只有一个值，同时该值使用value命名，则此时注解上可以省略value =
    @MyAnnotation3("wang")
    public void test2() {}
}

@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation2{
    //注解的参数：参数的类型 + 参数名();
    String name() default "";
    int age() default 0;
    int id() default -1;    //如果默认值为-1，代表不存在

    String[] schools() default {"NYU","TAMU"};

}

@Target({ElementType.ANNOTATION_TYPE,ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
@interface MyAnnotation3{
    String value();
}
