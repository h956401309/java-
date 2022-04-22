package com.chao.hu;


import org.springframework.stereotype.Component;

@Component(value = "stu")
public class Student {
    private int age;
    private String name;
    private String Grade;


    public Student() {
    }

    public Student(int age, String name, String grade) {
        this.age = age;
        this.name = name;
        Grade = grade;
    }


    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGrade() {
        return Grade;
    }

    public void setGrade(String grade) {
        Grade = grade;
    }


    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", Grade='" + Grade + '\'' +
                '}';
    }
}
