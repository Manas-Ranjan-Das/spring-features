

public class Cat {
    public String name;
    public int age;

    public Cat(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Cat(){
        
    }

    public void meow() {
        System.out.println(name + " says meow!");
    }
    public void purr() {
        System.out.println(name + " is purring.");
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setName(String name) {
        this.name = name;
    }

}
