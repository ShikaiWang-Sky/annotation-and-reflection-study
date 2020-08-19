package com.wang.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;
import java.util.Map;

//通过反射获取泛型
public class test11 {

    public void test01(Map<String, User> map, List<User> list) {
        System.out.println("test01");
    }

    public Map<String, User> test02() {
        System.out.println("test02");
        return null;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Method method = test11.class.getMethod("test01", Map.class, List.class);

        //获得参数类型
        Type[] genericParameterTypes = method.getGenericParameterTypes();

        for (Type genericParameterType : genericParameterTypes) {
            System.out.println("#" + genericParameterType);
            //如果是泛型,执行getActualTypeArguments返回真实的类型
            if (genericParameterType instanceof ParameterizedType){
                Type[] actualTypeArguments =  ((ParameterizedType) genericParameterType).getActualTypeArguments();
                for (Type actualTypeArgument : actualTypeArguments) {
                    System.out.println("*" + actualTypeArgument);
                }
            }
        }

        method = test11.class.getMethod("test02", null);
        //获得返回类型
        Type genericReturnType = method.getGenericReturnType();

        if (genericReturnType instanceof ParameterizedType){
            Type[] actualTypeArguments =  ((ParameterizedType) genericReturnType).getActualTypeArguments();
            for (Type actualTypeArgument : actualTypeArguments) {
                System.out.println("*" + actualTypeArgument);
            }
        }
    }
}
