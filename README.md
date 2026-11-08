# Автотесты для сайта [AB Digital](https://abdgtl.com)

UI-автотесты на Java с запуском в Jenkins, отчётами Allure, тест-менеджментом
в Allure TestOps, связью с Jira и уведомлениями в Telegram.

## Содержание

- [Технологии и инструменты](#технологии-и-инструменты)
- [Что проверяется](#что-проверяется)
- [Запуск из терминала](#запуск-из-терминала)
- [Сборка в Jenkins](#сборка-в-jenkins)
- [Отчёт Allure](#отчёт-allure)
- [Allure TestOps](#allure-testops)
- [Интеграция с Jira](#интеграция-с-jira)
- [Уведомления в Telegram](#уведомления-в-telegram)
- [Видео прогона в Selenoid](#видео-прогона-в-selenoid)

## Технологии и инструменты

<p align="center">
<a href="https://www.jetbrains.com/idea/"><img src="images/logo/Intelij_IDEA.svg" width="50" height="50" alt="IntelliJ IDEA" title="IntelliJ IDEA"/></a>
<a href="https://www.java.com/"><img src="images/logo/Java.svg" width="50" height="50" alt="Java" title="Java"/></a>
<a href="https://github.com/"><img src="images/logo/Github.svg" width="50" height="50" alt="GitHub" title="GitHub"/></a>
<a href="https://junit.org/junit5/"><img src="images/logo/JUnit5.svg" width="50" height="50" alt="JUnit 5" title="JUnit 5"/></a>
<a href="https://gradle.org/"><img src="images/logo/Gradle.svg" width="50" height="50" alt="Gradle" title="Gradle"/></a>
<a href="https://selenide.org/"><img src="images/logo/Selenide.svg" width="50" height="50" alt="Selenide" title="Selenide"/></a>
<a href="https://aerokube.com/selenoid/"><img src="images/logo/Selenoid.svg" width="50" height="50" alt="Selenoid" title="Selenoid"/></a>
<a href="https://github.com/allure-framework/allure2"><img src="images/logo/Allure.svg" width="50" height="50" alt="Allure Report" title="Allure Report"/></a>
<a href="https://qameta.io/"><img src="images/logo/Allure2.svg" width="50" height="50" alt="Allure TestOps" title="Allure TestOps"/></a>
<a href="https://www.jenkins.io/"><img src="images/logo/Jenkins.svg" width="50" height="50" alt="Jenkins" title="Jenkins"/></a>
<a href="https://www.atlassian.com/software/jira"><img src="images/logo/Jira.svg" width="50" height="50" alt="Jira" title="Jira"/></a>
<a href="https://telegram.org/"><img src="images/logo/Telegram.svg" width="50" height="50" alt="Telegram" title="Telegram"/></a>
</p>

- Тесты написаны на **Java** с **Selenide** и **JUnit 5**, сборщик **Gradle**.
- Архитектура: **PageObject** и компоненты (шапка и футер сайта).
- Удалённо тесты запускаются в **Selenoid**, сборка в **Jenkins**.
- После каждого теста в отчёт **Allure** прикладываются скриншот, код страницы,
  логи браузера и видео.
- Ручные и автоматические тест-кейсы собраны в **Allure TestOps**, ручные связаны
  с задачей в **Jira**.
- После сборки бот присылает результаты в **Telegram**.

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

## Запуск из терминала

Локальный запуск в браузере на компьютере:

```bash
./gradlew clean test
```

Удалённый запуск в Selenoid:

```bash
./gradlew clean test \
  "-DBASE_URL=https://abdgtl.com" \
  "-DBROWSER=chrome" \
  "-DBROWSER_SIZE=1920x1080" \
  "-DREMOTE_URL=<адрес Selenoid>" \
  "-DREMOTE_LOGIN=<логин>" \
  "-DREMOTE_PASSWORD=<пароль>"
```

Открыть отчёт Allure после прогона:

```bash
./gradlew allureServe
```

### Параметры запуска

| Ключ | Что задаёт | По умолчанию |
|---|---|---|
| `BASE_URL` | адрес тестируемого сайта | `https://abdgtl.com` |
| `BROWSER` | браузер | `chrome` |
| `BROWSER_SIZE` | размер окна браузера | `1920x1080` |
| `REMOTE_URL` | адрес Selenoid без `https://`; если не задан, тесты идут локально | — |
| `REMOTE_LOGIN` | логин для Selenoid | — |
| `REMOTE_PASSWORD` | пароль для Selenoid | — |

Логин и пароль не хранятся в коде: их передают при запуске, а в Jenkins они
задаются в настройках сборки.

## Сборка в Jenkins

Сборка запускается кнопкой **Build with Parameters**. После неё формируется отчёт
Allure, результаты отправляются в Allure TestOps и приходит уведомление в Telegram.

<p align="center">
<img src="images/screenshots/jenkins.jpg" alt="Сборка в Jenkins" width="950"/>
</p>

### Параметры сборки

- `REMOTE_URL`: адрес Selenoid
- `REMOTE_LOGIN`: логин для Selenoid
- `REMOTE_PASSWORD`: пароль для Selenoid (скрытый параметр)
- `TELEGRAM_TOKEN`: токен бота для уведомлений (скрытый параметр)

Остальные настройки (`BASE_URL`, `BROWSER`, `BROWSER_SIZE`) берутся по умолчанию.

## Отчёт Allure

### Тесты, шаги и вложения

Каждый шаг теста записан в отчёт. В конце теста прикладываются скриншот,
код страницы, логи браузера и видео.

<p align="center">
<img src="images/screenshots/allure-report.jpg" alt="Тест в отчёте Allure" width="950"/>
</p>

### Графики

<p align="center">
<img src="images/screenshots/allure-graphs.png" alt="Графики в отчёте Allure" width="950"/>
</p>

## Allure TestOps

### Дашборд

6 автоматических и 4 ручных теста, автоматизация 60 %.

<p align="center">
<img src="images/screenshots/testops-dashboard.png" alt="Дашборд Allure TestOps" width="950"/>
</p>

### Ручной тест-кейс

Шаги с ожидаемым результатом и связь с задачей в Jira.

<p align="center">
<img src="images/screenshots/testops-manual.png" alt="Ручной тест-кейс в Allure TestOps" width="950"/>
</p>

### Автоматический тест

Шаги подтягиваются из кода автоматически.

<p align="center">
<img src="images/screenshots/testops-test.jpg" alt="Автотест в Allure TestOps" width="950"/>
</p>

### Запуск тест-плана

В одном запуске ручные и автоматические тесты: автотесты запускаются из TestOps
через Jenkins, результаты ручных отмечаются вручную.

<p align="center">
<img src="images/screenshots/testops-launch.jpg" alt="Запуск тест-плана в Allure TestOps" width="950"/>
</p>

## Интеграция с Jira

Ручные тест-кейсы связаны с задачей и видны прямо на её странице.

<p align="center">
<img src="images/screenshots/jira.jpg" alt="Задача в Jira со связанными тест-кейсами" width="950"/>
</p>

## Уведомления в Telegram

После сборки бот присылает результаты прогона и ссылку на отчёт.

<p align="center">
<img src="images/screenshots/telegram.jpg" alt="Уведомление в Telegram" width="550"/>
</p>

## Видео прогона в Selenoid

<p align="center">
<img src="images/video/selenoid.gif" alt="Прогон теста в Selenoid" width="950"/>
</p>
