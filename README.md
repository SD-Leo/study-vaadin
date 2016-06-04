# vaadin-study
В проектах содержатся только файлы Maven.
Чтобы подключить проект в IDE небходимо его импротировать как maven проект.
* Eclipse: _File -> Import -> Maven -> Existing Maven Projects_
* IDEA: _File -> New -> Module from Existing Sources... -> Import module from external model (Maven)_

### Проект **vaadin-hello-web-scratch**
Создавался на базе Eclipse (mars 4.5) web dynamic project(3.1),
а затем ковертировался в Maven проект. Java 1.7.
Были добавлены следующие maven-зависимости:

* vaadin-server
* vaadin-themes
* vaadin-client-compiled (иначе ругался, что не найден widgetset)

Context root изменен с _vaadin-hello-web-scratch_ на _vaadin_, т.е. при запуск через Eclipse адрес будет http://localhost:8080/vaadin

Запуск web проекта настроект через web.xml. Т.е. проект собирается в war,
который нужно запускать в tomcat или jetty

Само приложение представляет из себя обычную форму авторизации

### Проект **vaadin-data-binding**
Создавался через [конструктор spring-boot](https://start.spring.io), где был выбран
Maven, Java 1.7, Vaadin. Затем импортировался в Eclipse (mars 4.5).
Context root: vaadin. Дополнительно в  pom.xml подключен springloaded для горячей подмены кода.
Для запуска необходимо выполнить в консоли команду: *mvn spring-boot:run*
Запустится веб сервер на порте *8080*

### Проект **vaadin-hello-jetty**
Проект создан из архетипа _vaadin-archetype-application_ - простое одномодульное приложение
vaadin (без web.xml), требует servlet-3.0, запускатеся с помощью jetty