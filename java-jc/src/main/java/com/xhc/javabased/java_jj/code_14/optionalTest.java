package com.xhc.javabased.java_jj.code_14;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class optionalTest {

    public static void main(String[] args){
        String name=null;

        Optional<String> opt;
        // opt = Optional.of(name); //不可为空
        //opt = Optional.ofNullable(name); //可为空

        opt = Optional.of("wuyi");
        System.out.println("isPresent："+opt.isPresent());//isPresent（） 方法检查其中是否存在值


        opt = Optional.ofNullable(name);
        opt.ifPresent(s ->{System.out.println(s);});//如果值存在，就执行使用该值的方法调用，否则什么也不做

        String name1= Optional.ofNullable(name).orElse("你好orElse"); //如果有值则将其返回，否则返回一个默认值
        System.out.println(name1+"orElse");

        name1 = Optional.ofNullable(name).orElseGet(() -> "你好orElseGet");//如果不存在Optional值，则不需要返回值，而是返回 Supplier 接口生成的值
        System.out.println(name1+"orElseGet");

//        name1 = (String) Optional.ofNullable(null).orElseThrow(IllegalArgumentException::new);
//        System.out.println(name1+"orElseThrow");

        opt = Optional.ofNullable(name);
        name1 = opt.get();
        System.out.println(name1+"get");

        Integer year = 2016;
        Optional<Integer> yearOptional = Optional.of(year);
        //如果值存在并且满足提供的谓词，就返回包含该值的 Optional 对象，否则返回一个空的 Optional 对象。
        boolean is2016 = yearOptional.filter(y -> y == 2016).isPresent();
        System.out.println(is2016);
        boolean is2017 = yearOptional.filter(y -> y == 2017).isPresent();
        System.out.println(is2017);

        List<String> companyNames = Arrays.asList(
                "paypal", "oracle", "", "microsoft", "", "apple");
        Optional<List<String>> listOptional = Optional.of(companyNames);

        String password = " password ";
        Optional<String> passOpt = Optional.of(password);
        boolean correctPassword = passOpt.filter(pass -> pass.equals("password")).isPresent();


        correctPassword = passOpt.map(String::trim).filter(pass -> pass.equals("password")).isPresent();

        Person person = new Person("john", 26);
        Optional<Person> personOptional = Optional.of(person);

        Optional<String> nameOptionalWrapper = personOptional.map(Person::getName); //使用map（）从 Optional对象中提取和转换值

        name1 = nameOptionalWrapper.orElse("");

        System.out.println(name1);



    }
}


