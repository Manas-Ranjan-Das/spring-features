package test;

public class Cat {
    public String name;
    public int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void meow() {
        System.out.println(name + " says meow!");
    }
    public void purr() {
        System.out.println(name + " is purring.");
    }
}
