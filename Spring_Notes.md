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


