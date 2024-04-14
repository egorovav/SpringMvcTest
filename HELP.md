# Getting Started

### Reference Documentation
For further reference, please consider the following sections:

* [Official Apache Maven documentation](https://maven.apache.org/guides/index.html)
* [Spring Boot Maven Plugin Reference Guide](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/)
* [Create an OCI image](https://docs.spring.io/spring-boot/docs/3.2.4/maven-plugin/reference/html/#build-image)
* [Spring Web](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#web)
* [Thymeleaf](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#web.servlet.spring-mvc.template-engines)
* [Spring Data JPA](https://docs.spring.io/spring-boot/docs/3.2.4/reference/htmlsingle/index.html#data.sql.jpa-and-spring-data)

### Guides
The following guides illustrate how to use some features concretely:

* [Building a RESTful Web Service](https://spring.io/guides/gs/rest-service/)
* [Serving Web Content with Spring MVC](https://spring.io/guides/gs/serving-web-content/)
* [Building REST services with Spring](https://spring.io/guides/tutorials/rest/)
* [Handling Form Submission](https://spring.io/guides/gs/handling-form-submission/)
* [Accessing Data with JPA](https://spring.io/guides/gs/accessing-data-jpa/)

Домашнее задание по теме HTTP, HTML, JSON, REST:

Спроектировать API интернет- магазина (GET/POST…, что принимает/возвращает).Предусмотреть следующие операции:

    Просмотр своих заказов
    - GET принимает id пользователя, возвращает ссылку на список заказов
    Просмотр товаров (простым списком)
    - GET возвращает ссылку на список товарами
    Выбор товаров в корзину
    - POST принимает id пользоваетля и список товаров, возвращает ссылку на содержимое корзины
    Заказ товаров (товары из корзины превращаются в заказ)
    - POST принимает id пользователя и список товаров, возвращает ссылку на список заказов

Домашнее задание по теме Архитектура Spring MVC:

CRUD приложение с хранением данных в БД

Необходимо:

    Создать приложение с хранением сущностей в БД (можно взять книги/жанры/авторы)
    Использовать @RestController
    Для главной сущности на должны быть доступные все CRUD операции. CRUD остальных сущностей - по желанию/необходимости.

По первому пункту можно посмотреть занятие 7 DAO на Spring JDBC (описания сущностей)

