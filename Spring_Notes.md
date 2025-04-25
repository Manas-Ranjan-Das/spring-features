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

> Keep in mind that, to make this work out of the box, your code must be compiled with the -parameters flag enabled so that Spring can look up the parameter name from the constructor. If you cannot or do not want to compile your code with the -parameters flag, you can use the @ConstructorProperties JDK annotation to explicitly name your constructor arguments. The sample class would then have to look as follows:

### Dependency Injection 
```xml
<bean id = "thingOne" class="thing.ThingOne">
	<property name="size" value="12"></property>
</bean>

<bean id="thingTwo" class="thing.ThingTwo">
	<constructor-arg name="mass" value="23"></constructor-arg>
</bean>

<bean id="thingThree" class="thing.ThingThree">
	<constructor-arg index="0" ref="thingOne"></constructor-arg>
	<property name="thingTwo" ref="thingTwo"></property>
</bean>
```
### Depenency Resolution Process

1. The ApplicationContext is created and initialized with configuration metadata that describes all the beans. Configuration metadata can be specified by XML, Java code, or annotations.

2. For each bean, its dependencies are expressed in the form of properties, constructor arguments, or arguments to the static-factory method (if you use that instead of a normal constructor). These dependencies are provided to the bean, when the bean is actually created.

3. Each property or constructor argument is an actual definition of the value to set, or a reference to another bean in the container.

4. Each property or constructor argument that is a value is converted from its specified format to the actual type of that property or constructor argument. By default, Spring can convert a value supplied in string format to all built-in types, such as int, long, String, boolean, and so forth.

### Using p-namepace
```xml
<beans xmlns="http://www.springframework.org/schema/beans"
	xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
	xmlns:p="http://www.springframework.org/schema/p"
	xsi:schemaLocation="http://www.springframework.org/schema/beans
	https://www.springframework.org/schema/beans/spring-beans.xsd">

	<bean id="myDataSource" class="org.apache.commons.dbcp.BasicDataSource"
		destroy-method="close"
		p:driverClassName="com.mysql.jdbc.Driver"
		p:url="jdbc:mysql://localhost:3306/mydb"
		p:username="root"
		p:password="misterkaoli"/>

</beans>
```

### configure a java.util.Properties instance
```xml
<bean id="mappings"
	class="org.springframework.context.support.PropertySourcesPlaceholderConfigurer">

	<!-- typed as a java.util.Properties -->
	<property name="properties">
		<value>
			jdbc.driver.className=com.mysql.jdbc.Driver
			jdbc.url=jdbc:mysql://localhost:3306/mydb
		</value>
	</property>
</bean>
```
### idref Element
```xml
<bean id="theTargetBean" class="..."/>

<bean id="theClientBean" class="...">
	<property name="targetName">
		<idref bean="theTargetBean"/>
	</property>
</bean>
```

This form is preferable to the second, because using the idref tag lets the container validate at deployment time that the referenced, named bean actually exists. In the second variation, no validation is performed on the value that is passed to the targetName property of the client bean. Typos are only discovered (with most likely fatal results) when the client bean is actually instantiated. If the client bean is a prototype bean, this typo and the resulting exception may only be discovered long after the container is deployed.

### Inner Beans
```xml
<bean id="outer" class="...">
	<!-- instead of using a reference to a target bean, simply define the target bean inline -->
	<property name="target">
		<bean class="com.example.Person"> <!-- this is the inner bean -->
			<property name="name" value="Fiona Apple"/>
			<property name="age" value="25"/>
		</bean>
	</property>
</bean>
```

### Collections
```xml
<bean id="moreComplexObject" class="example.ComplexObject">
	<!-- results in a setAdminEmails(java.util.Properties) call -->
	<property name="adminEmails">
		<props>
			<prop key="administrator">administrator@example.org</prop>
			<prop key="support">support@example.org</prop>
			<prop key="development">development@example.org</prop>
		</props>
	</property>
	<!-- results in a setSomeList(java.util.List) call -->
	<property name="someList">
		<list>
			<value>a list element followed by a reference</value>
			<ref bean="myDataSource" />
		</list>
	</property>
	<!-- results in a setSomeMap(java.util.Map) call -->
	<property name="someMap">
		<map>
			<entry key="an entry" value="just some string"/>
			<entry key="a ref" value-ref="myDataSource"/>
		</map>
	</property>
	<!-- results in a setSomeSet(java.util.Set) call -->
	<property name="someSet">
		<set>
			<value>just some string</value>
			<ref bean="myDataSource" />
		</set>
	</property>
</bean>
```