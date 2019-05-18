package code;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author: xuzhangwang
 */
public class Comparator {
    public static void main(String[] args) {

        List<Student> list = new ArrayList<Student>() {
            {
                add(new Student("扎三", 30));
                add(new Student("李四", 20));
                add(new Student("王五", 60));
            }
        };

        for (Student student : list) {
            System.out.println(student.toString());
        }
        System.out.println("=================");
        // 对用户的年龄进行排序
        Collections.sort(list, new java.util.Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
                // 升序
                return o1.getAge() - o2.getAge();
            }
        });
        for (Student student : list) {
            System.out.println(student.toString());
        }
    }
}

class Student {
    private String name;
    private int age;
    private int sno;

    public Student(String name, int age, int sno) {
        this.name = name;
        this.age = age;
        this.sno = sno;
    }

    public Student(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", sno=" + sno +
                '}';
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getSno() {
        return sno;
    }

    public void setSno(int sno) {
        this.sno = sno;
    }
}