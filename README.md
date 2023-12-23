# test-task-libertex
## Реализация тестового задания для libertex

Задание:

Task 1. 
- Write a function that takes a date of birth as input (in any convenient form) and returns whether the user is 18 years old
- Write unit tests for this feature.

Task 2. On the google search engine page, check for UI:
- Search by: Name, full name. (valid search is based on the current output of your search query).
- When you hover the mouse over the input field, the corresponding tooltip is displayed (in google this is the word "Search").
- After clicking on the logo in the upper left side, an empty results area is displayed.
USE: Java 8+,  Gradle, Selenide, TestNg, GitHub

## Установка
Для запуска UI-тестов следует поочерёдно выполнить шаги:
1. Установка Docker:

   1.1. https://docs.docker.com/engine/install/

   1.2. либо https://docs.docker.com/desktop/install/windows-install/ если у вас windows

Далее гайд для Windows:

2. Установка Selenoid - https://github.com/aerokube/selenoid/blob/master/docs/quick-start-guide.adoc

   2.1. Качаем CM https://github.com/aerokube/cm/releases/tag/1.8.5

   2.2. В cmd под админом выполняем команды

```sh
./cm selenoid start --vnc
./cm selenoid-ui start
```

"./cm" - бинарник, от которого выполняем команды (в моем случае cm_windows_amd64.exe)

Итоговый результат: 

По адресу http://localhost:8080/#/ либо http://127.0.0.1:8080/#/ будет запущен интерфейс, на котором можно наблюдать ui-тесты.