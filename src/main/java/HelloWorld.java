import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import thing.ThingThree;

public class HelloWorld {

    public static void main(String[] args) {
        System.out.println("Hello World");
        ApplicationContext context = new ClassPathXmlApplicationContext("config.xml");
        Cat cat1 = context.getBean("cat1",Cat.class);
        Cat cat2 = context.getBean("caterinaCatBean",Cat.class);
        Cat cat3 = context.getBean("cat2233",Cat.class);
        Cat cat4 = context.getBean("caterinaCat",Cat.class);
        Cat factory_cat = context.getBean("factory-cat",Cat.class);
        Cat instance_factory_cat = context.getBean("instanceFactoryCat",Cat.class);
        ThingThree thingThree = context.getBean("thingThree",ThingThree.class);
        
        cat1.meow();
        factory_cat.meow();
        instance_factory_cat.meow();
        System.out.println(thingThree);

    }
}