import java.util.Properties;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Component;

import lazy.LazyBean;
import lazy.NotLazyBean;
import methodinjection.PrototypeOne;
import methodinjection.SingletonOne;
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
        
        // cat1.meow();
        // factory_cat.meow();
        // instance_factory_cat.meow();
        // System.out.println(thingThree);
        // po3.meow();
        // System.out.println(propertiesWrapper.getProperties().getProperty("driver.name"));
        // System.out.println(thingThree_1);
        // System.out.println(classWithCollections);
        // try {
        //     Thread.sleep(2000);
        // } catch (Exception e) {
        //     e.printStackTrace();
        // }
        // LazyBean lazyBean = context.getBean("lazy-bean",LazyBean.class);
        // NotLazyBean notlazyBean = context.getBean("not-lazy-bean",NotLazyBean.class);
        SingletonOne singletonOne = context.getBean("singletonOne",SingletonOne.class);
        PrototypeOne prototypeOne1 = singletonOne.genNewPrototypeBean();
        PrototypeOne prototypeOne2 = singletonOne.genNewPrototypeBean();
        
        System.out.println(prototypeOne1.index);
        System.out.println(prototypeOne2.index);
        System.out.println(prototypeOne1.index);
        

    }
}