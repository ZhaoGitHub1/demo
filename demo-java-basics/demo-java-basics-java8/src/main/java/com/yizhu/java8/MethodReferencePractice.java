package com.yizhu.java8;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Supplier;

/**
* @author 逸竹
* @Description 方法引用实践
* @Date 21:56 2018/8/26
* @Param
* @return
**/
public class MethodReferencePractice {
    public static void main(String[] args) {
        // 方法引用::引用构造函数
        PersonFactory factory = new PersonFactory(Person::new);
//等价于PersonFactory factory = new PersonFactory(()->new Person());

        List<Person> personList = new ArrayList<Person>();

        Person p1 = factory.getPerson();
        p1.setName("c");
        personList.add(p1);
        Person p2 = factory.getPerson();
        p2.setName("b");
        personList.add(p2);
        Person p3 = factory.getPerson();
        p3.setName("a");
        personList.add(p3);

        Person[] persons1 = personList.toArray(new Person[personList.size()]);
        System.out.print("排序前: ");
        printArray(persons1);

        // 方法引用::引用静态方法
        Arrays.sort(persons1, MethodReferencePractice::myCompare);
//等价于Arrays.sort(persons1, (p11,p22)->myCompare(p11, p22));
        System.out.print("排序后: ");
        printArray(persons1);
        System.out.println();

        Person[] persons2 = personList.toArray(new Person[personList.size()]);
        System.out.print("排序前: ");
        printArray(persons2);

        // 方法引用::引用特定对象的实例方法(可调用私有方法)
        Arrays.sort(persons2, p1::compare);
//等价于Arrays.sort(persons2, (p11,p22)->p11.compare(p11,p22));
        System.out.print("排序后: ");
        printArray(persons2);
        System.out.println();

        Person[] persons3 = personList.toArray(new Person[personList.size()]);
        System.out.print("排序前: ");
        printArray(persons3);

        // 方法引用::引用特定类型的任意对象的实例方法
        Arrays.sort(persons3, Person::compareTo);
//等价于Arrays.sort(persons3, (p11,p22)->p11.compareTo(p22));
        System.out.print("排序后: ");
        printArray(persons3);


        System.out.println("------------------------------------------------------------------------------------");
        System.out.println("排序前: ");
        personList.forEach(System.out::println);
        personList.sort(Comparator.comparing(Person::getName));
        System.out.println("排序后: ");
        personList.forEach(System.out::println);
    }

    public static void printArray(Person[] persons) {
        for (Person p : persons) {
            System.out.print(p.name + "  ");
        }
        System.out.println();
    }

    public static int myCompare(Person p1, Person p2) {
        return p1.getName().compareTo(p2.getName());
    }

    static class Person {
        private String name;

        public Person() {
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        private int compare(Person p1, Person p2) {
            return p1.getName().compareTo(p2.getName());
        }

        public int compareTo(Person p) {
            return this.getName().compareTo(p.getName());
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }

    static class PersonFactory {
        private Supplier<Person> supplier;

        public PersonFactory(Supplier<Person> supplier) {
            this.supplier = supplier;
        }

        public Person getPerson() {
            return supplier.get();
        }
    }
}
