# Spring

## IoC Container

![spring container diiagram](https://docs.spring.io/spring-framework/reference/_images/container-magic.png)

```xml
<?xml version="1.0" encoding="UTF-8"?>
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
		https://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="..." class="..."> 
		<!-- collaborators and configuration for this bean go here -->
	</bean>

	<bean id="..." class="...">
		<!-- collaborators and configuration for this bean go here -->
	</bean>

	<!-- more bean definitions go here -->

</beans>
```

| Layer                        | Description                     |
|------------------------------|---------------------------------|
| Web Layer (Controller, ViewResolver) | Spring MVC Config           |
| Service Layer                | Beans                          |
| DAO Layer                    | Repositories                   |
| DataSource & ORM Config      | Configuration for DataSource & ORM |
| Transaction Management       | Handles transactions           |
| AOP & Security Layer         | Aspect-Oriented Programming & Security |
| Core Bean Config             | Core Bean Configuration        |


## Beans
```xml
<bean id="cat1" class="Cat" >
    <property name="name" value="Caterina"></property>
    <property name="age" value="13"></property>
</bean>
```
note : 
> With component scanning in the classpath, Spring generates bean names for unnamed components, following the rules described earlier: essentially, taking the simple class name and turning its initial character to lower-case. However, in the (unusual) special case when there is more than one character and both the first and second characters are upper case, the original casing gets preserved. These are the same rules as defined by java.beans.Introspector.decapitalize (which Spring uses here).

```xml

    <!-- Property Based Instanciation-->
    <bean id="cat1" class="Cat" name = "caterinaCatBean caterinaCat" >
         <property name="name" value="Caterina"></property>
         <property name="age" value="13"></property>
    </bean>
    <alias name="caterinaCatBean" alias="cat2233" />
	
    <!-- Static Factory Method Based -->
    <bean id = "factory-cat" class="CatFactory" factory-method="makeCat">
        <constructor-arg name="name" value="Catousky" ></constructor-arg>
        <constructor-arg name="age" value="23"></constructor-arg>
    </bean>

    <!-- Instance factory Based-->
    <bean id="catFactory" class="CatFactory">
        <constructor-arg name="age" value="3"></constructor-arg>
    </bean>

    <bean id="instanceFactoryCat" factory-bean="catFactory" factory-method="makeCat">
        <constructor-arg name="name" value="Instaousky"></constructor-arg>
    </bean>
```

### Determining a Bean’s Runtime Type
The recommended way to find out about the actual runtime type of a particular bean is a `BeanFactory.getType` call for the specified bean name. This takes all of the above cases into account and returns the type of object that a `BeanFactory.getBean` call is going to return for the same bean name.

### Constructor argument type matching
```xml
<bean id="exampleBean" class="examples.ExampleBean">
	<constructor-arg index="0" type="int" name="years" value="7500000"/>
	<constructor-arg index="1" type="java.lang.String" name="ultimateAnswer" value="42"/>
</bean>
```