package javacode;

import java.util.Scanner;
import java.util.TreeMap;

/**
 * @author xuzhangwang
 * @date 2019/7/24
 */
public class CompareTest {
    public static void main(String[] args) {
        TreeMap<Person, String> map = new TreeMap<>();
        map.put(new Person("张三", 22), "张三");
        map.put(new Person("李四", 19), "李四");
        map.put(new Person("王五",30), "王五");
        map.put(new Person("赵四", 4), "招生");

        for (Person person : map.keySet()) {
            System.out.println(person.getName() + " " + person.getAge());
        }
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        System.out.println(i);
    }
}

class Person implements Comparable<Person> {

    private String name;
    private int age;

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person() { }

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public int compareTo(Person o) {
        if (this.age > o.getAge()) {
            return 1;
        } else if (this.age < o.getAge()) {
            return -1;
        }
        return 0;
    }
}
