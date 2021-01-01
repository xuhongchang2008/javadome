package com.xhc.javabased.java_jj.code_13.demo11.StreamZX;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class StudentTest {

    public static void main(String[] args) {
        // 初始化
        List<Student> students = new ArrayList<Student>() {
            {
                add(new Student(20160001, "孔明", 20, 1, "土木工程", "武汉大学"));
                add(new Student(20160002, "伯约", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20160003, "玄德", 22, 3, "经济管理", "武汉大学"));
                add(new Student(20160004, "云长", 21, 2, "信息安全", "武汉大学"));
                add(new Student(20161001, "翼德", 21, 2, "机械与自动化", "华中科技大学"));
                add(new Student(20161002, "元直", 23, 4, "土木工程", "华中科技大学"));
                add(new Student(20161003, "奉孝", 23, 4, "计算机科学", "华中科技大学"));
                add(new Student(20162001, "仲谋", 22, 3, "土木工程", "浙江大学"));
                add(new Student(20162002, "鲁肃", 23, 4, "计算机科学", "浙江大学"));
                add(new Student(20163001, "丁奉", 24, 5, "土木工程", "南京大学"));
            }
        };

        streamCZ(students);
        streamMap(students);
    }

    private static void streamCZ(List<Student> students)
    {
        List<Student> whuStudents = students.stream()
                .filter(student -> "武汉大学".equals(student.getSchool()))
                .collect(Collectors.toList());
        printStudent(whuStudents);


        List<Student> civilStudents = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor())).limit(2)
                .collect(Collectors.toList());
        printStudent(civilStudents);

        List<Student> sortedCivilStudents = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor())).sorted((s1, s2) -> s1.getAge() - s2.getAge())
                .limit(2)
                .collect(Collectors.toList());
        printStudent(sortedCivilStudents);

        List<Student> civilStudents1 = students.stream()
                .filter(student -> "土木工程".equals(student.getMajor()))
                .skip(2)
                .collect(Collectors.toList());
        printStudent(civilStudents1);

        //anyMatch则是检测是否存在一个或多个满足指定的参数行为，如果满足则返回true，例如我们希望检测是否有来自武汉大学的学生，那么可以实现为：
        boolean hasWhu = students.stream().anyMatch(student -> "武汉大学".equals(student.getSchool()));
        System.out.println(hasWhu);

        //noneMatch用于检测是否不存在满足指定行为的元素，如果不存在则返回true，例如我们希望检测是否不存在专业为计算机科学的学生，可以实现如下：
        boolean noneCs = students.stream().noneMatch(student -> "计算机科学".equals(student.getMajor()));
        System.out.println(noneCs);

        //indFirst用于返回满足条件的第一个元素，比如我们希望选出专业为土木工程的排在第一个学生，那么可以实现如下：
        Optional<Student> optStu = students.stream().filter(student -> "土木工程".equals(student.getMajor())).findFirst();
        System.out.println(optStu.toString());

        Map<String, Map<String, List<Student>>> groups2 = students.stream().collect(
                Collectors.groupingBy(Student::getSchool,  // 一级分组，按学校
                        Collectors.groupingBy(Student::getMajor)));  // 二级分组，按专业


        Iterator<Map.Entry<String, Map<String, List<Student>>>> entries =groups2.entrySet().iterator();
        while(entries.hasNext()){
            Map.Entry<String, Map<String, List<Student>>> entry = entries.next();
            String studentkey = entry.getKey();

            Iterator<Map.Entry<String, List<Student>>> studentvalue = entry.getValue().entrySet().iterator();
            while (studentvalue.hasNext()) {
                Map.Entry<String, List<Student>> entry1 = studentvalue.next();
                System.out.println("studentkey="+studentkey+";entrykey="+entry1.getKey()+";entryvalue="+entry1.getValue());
            }
        }

        int sum = Stream.of(0,9,8,4,5,6,-1)
                .reduce(0,(e1,e2)->e1+e2);
        System.out.println(sum);

    }

    private static void printStudent(List<Student> stu)
    {
        System.out.println("============================");
        stu.forEach(s -> System.out.println(s.toString()));
    }

    private static void streamMap(List<Student> students)
    {
        List<String> names = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .map(Student::getName).collect(Collectors.toList());
        names.forEach(s -> {System.out.println(s.toString());});

        int totalAge = students.stream()
                .filter(student -> "计算机科学".equals(student.getMajor()))
                .mapToInt(Student::getAge).sum();
        System.out.println(totalAge);

        // flatMap是将一个流中的每个值都转成一个个流，然后再将这些流扁平化成为一个流
        String[] strs = {"java8", "is", "easy", "to", "use"};
        List<String[]> distinctStrs = Arrays.stream(strs)
                .map(str -> str.split(""))  // 映射成为Stream<String[]>
                .distinct()
                .collect(Collectors.toList());
        distinctStrs.forEach(strings ->
        {
            for (String str : strings) {
                System.out.println(str.toString());
                //System.out.print(str);
            }
        });
    }

}
