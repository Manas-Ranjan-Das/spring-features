import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import others.ClassWithCollections;
import others.PropertiesWrapper;
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
        Cat po3 = context.getBean("cat_p",Cat.class);
        PropertiesWrapper propertiesWrapper = context.getBean("propertiesWrapper",PropertiesWrapper.class);
        ThingThree thingThree_1 = context.getBean("thingThree_1",ThingThree.class);
        ClassWithCollections classWithCollections = context.getBean("moreComplexObject",ClassWithCollections.class);


        cat1.meow();
        factory_cat.meow();
        instance_factory_cat.meow();
        System.out.println(thingThree);
        po3.meow();
        System.out.println(propertiesWrapper.getProperties().getProperty("driver.name"));
        System.out.println(thingThree_1);
        System.out.println(classWithCollections);
    }
}