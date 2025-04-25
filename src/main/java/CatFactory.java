public class CatFactory {
    int age;
    static Cat makeCat( String name, int age ){
        return new Cat(name,age);
    }
    public CatFactory(int age){

    }

    Cat makeCat (String name){
        return new Cat(name,this.age);
    }
}
