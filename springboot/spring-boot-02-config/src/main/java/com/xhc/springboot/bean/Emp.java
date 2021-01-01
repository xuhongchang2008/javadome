package com.xhc.springboot.bean;

import com.xhc.springboot.config.YamlPropertySourceFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.validation.annotation.Validated;

import java.util.Date;
import java.util.List;
import java.util.Map;

/**
 * @ConfigurationProperties 告诉SpringBoot将配置文件中的对应属性值，映射到这个组件类中，
 * 进行一一绑定
 *  prefix = "emp" ： 配置文件中的前缀名，配置了哪个前缀就会与下面的所有属性进行一一映射
 *
 *
 *  @PropertySource ： 加载局部配置文件，
 * @Title: Emp
 * @Description: com.xhc.springboot.bean
 * @Auther: www.xhc.com
 * @Version: 1.0
 */

//@PropertySource(value = {"classpath:application.properties"})
@Validated
//@Component
//@PropertySource(value = {"classpath:emp.yml"},factory = YamlPropertySourceFactory.class)
@PropertySource(value = {"classpath:emp.properties"})
@ConfigurationProperties(prefix = "emp")
public class Emp {

    /***
     * 类似于Spring框架中使用配置文件中的数据注入方式
     *  <bean class="Emp">
     *      <property name="lastName" value="字面量/#{SpEL} spring表达式/${key}从配置文件中获取"></property>
     *  </bean>
     */
//    @Value("${emp.last-name}")
//    @Email
    private String lastName;
//    @Value("#{10*2}")
    private Integer age;
//    @Value("8000")
    private Double salary;
    private Boolean boss;
    private Date birthday;

    //@Value("emp.map")
    private Map map;
    private List list;

    private Forte forte;

    @Override
    public String toString() {
        return "Emp{" +
                "lastName='" + lastName + '\'' +
                ", age=" + age +
                ", salary=" + salary +
                ", boss=" + boss +
                ", birthday=" + birthday +
                ", map=" + map +
                ", list=" + list +
                ", forte=" + forte +
                '}';
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }

    public Boolean getBoss() {
        return boss;
    }

    public void setBoss(Boolean boss) {
        this.boss = boss;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public Map getMap() {
        return map;
    }

    public void setMap(Map map) {
        this.map = map;
    }

    public List getList() {
        return list;
    }

    public void setList(List list) {
        this.list = list;
    }

    public Forte getForte() {
        return forte;
    }

    public void setForte(Forte forte) {
        this.forte = forte;
    }
}
