# vaadin-study
В проектах сохранены файлы Eclipse для простоты импорта, но в общем так делать низя.

### Проект **vaadin-from-scratch-dynamic**
Создавался на базе Eclipse (mars 4.5) web dynamic project(3.1),  а затем ковертировался в Maven проект. Java 1.7.
Были добавлены следующие maven-зависимости

* vaadin-server
* vaadin-themes
* vaadin-client-compiled (иначе ругался, что не найден widgetset)

Context root изменен с *vaadin-from-scratch-dynamic* на *vaadin*, т.е. при запуск через Eclipse адрес будет http://localhost:8080/vaadin

Запуск web проекта настроект через web.xml

Само приложение представляет из себя обычную форму авторизации

### Проект **vaadin-data-binding**
Создавался через [конструктор spring-boot](https://start.spring.io), где был выбран Maven, Java 1.7, Vaadin. Затем импортировался в Eclipse (mars 4.5). Context root: vaadin. Дополнительно в  pom.xml подключен springloaded для горячей подмены кода.
Для запуска необходимо выполнить в консоли команду: *mvn spring-boot:run*
Запустится веб сервер на порте *8080*