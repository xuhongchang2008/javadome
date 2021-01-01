package com.xhc.javabased.java_jj.code_02.demo03.Generic.ZJdemo;

public class GenericTest {
    
    public static void main(String[] args) {
        showA();
        showB();
    }

    private static void showA()
    {
        //泛型的类型参数只能是类类型（包括自定义类），不能是简单类型
        //传入的实参类型需与泛型的类型参数类型相同，即为Integer.
        Generic<Integer>genericInteger=new Generic<>(123456);

        //传入的实参类型需与泛型的类型参数类型相同，即为String.
        Generic<String> genericString = new Generic<>("key_vlaue");
        System.out.println("泛型测试，key is " + genericInteger.getKey());
        System.out.println("泛型测试，key is " + genericString.getKey());

        genericInteger.showKeyValue1(new Generic<String>("?=是类型实参，而不是类型形参"));

        double doubleValue= genericInteger.showKeyName(new Generic<>(86232.0843));
        System.out.println("泛型测试，doubleValue " + doubleValue);

        Generic<Long> genericlong = new Generic<>(8304534534L);
        genericlong.printMsg("111",222,"aaaa","2323.4", 5.555E01);
    }

    private static void showB()
    {
        FruitGenerator fruitGenerator=new FruitGenerator();
        System.out.println(fruitGenerator.next());

        Generic<String> generic1 = new Generic<String>("11111");
        Generic<Integer> generic2 = new Generic<Integer>(2222);
        Generic<Number> generic3 = new Generic<Number>(4455.5);


        generic1.showKeyExtendsValue(generic2);
        generic3.showKeySupersValue(generic3);
        Integer integer = generic3.showGenericKeyName(new Generic<Integer>(33333));
        System.out.println("泛型测试，integer " + integer);

    }

}
