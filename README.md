# Автотесты для сайта [AB Digital](https://abdgtl.com)

UI-автотесты на Java с запуском в Jenkins, отчётами Allure, тест-менеджментом
в Allure TestOps, связью с Jira и уведомлениями в Telegram.

## Содержание

- [Технологии](#технологии)
- [Что проверяется](#что-проверяется)
- [Запуск тестов](#запуск-тестов)
- [Jenkins](#jenkins)
- [Allure Report](#allure-report)
- [Allure TestOps](#allure-testops)
- [Jira](#jira)
- [Уведомления в Telegram](#уведомления-в-telegram)

## Технологии

Java · Gradle · JUnit 5 · Selenide · Selenoid · Jenkins · Allure Report ·
Allure TestOps · Jira · Telegram

Архитектура тестов: PageObject и компоненты.

## Что проверяется

**Автоматические тесты**

- открытие главной страницы
- переход на дочерние страницы через меню
- заголовки основных страниц
- ссылки кнопок вакансий
- контакты в футере
- ссылки на юридические документы

**Ручные тесты**

- переход по кнопке «Вперёд к вакансиям!»
- открытие документа «Политика обработки персональных данных»
- отображение главной страницы на мобильной ширине экрана
- возврат на главную кнопкой «Назад» браузера

## Запуск тестов

Локально:

```bash
./gradlew clean test
./gradlew allureServe
```

Удалённо через Selenoid:

```bash
./gradlew clean test "-DREMOTE_URL=<адрес>" "-DREMOTE_LOGIN=<логин>" "-DREMOTE_PASSWORD=<пароль>"
```

## Jenkins

Сборка запускается с параметрами. После неё формируется отчёт Allure
и отправляется уведомление в Telegram.

![Сборка в Jenkins](images/screenshots/jenkins.jpg)

## Allure Report

Отчёт содержит шаги теста и вложения: скриншот, код страницы, логи браузера и видео.

![Отчёт Allure](images/screenshots/allure-report.jpg)

## Allure TestOps

В одном тест-плане собраны ручные и автоматические тесты. Автотесты запускаются
из TestOps через Jenkins, результаты ручных отмечаются в том же запуске.

![Запуск с ручными и автоматическими тестами](images/screenshots/testops-launch.jpg)

![Шаги автотеста в TestOps](images/screenshots/testops-test.jpg)

## Jira

Ручные тест-кейсы связаны с задачей в Jira и видны прямо на её странице.

![Задача в Jira со связанными тест-кейсами](images/screenshots/jira.jpg)

## Уведомления в Telegram

После сборки бот присылает сообщение с результатами.

![Уведомление в Telegram](images/screenshots/telegram.jpg)
