package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;


public class AbdgtlSmokeTests extends AbdgtlBase {
    @Test
    @DisplayName("Тест 1. Главная страница открывается")
    void mainPageShouldOpen() {
        open("");

        webdriver().shouldHave(urlStartingWith(baseUrl));
        $$(".tn-atom")
                .filterBy(text("Мы разрабатываем цифровые экосистемы"))
                .findBy(visible)
                .shouldHave(text(
                        "Мы разрабатываем цифровые экосистемы и внедряем новые технологичные " +
                                "продукты для удобства клиентов банка"
                ));
    }

    @Test
    @DisplayName("Тест 2. Дочерние страницы открываются из меню")
    void childPagesShouldOpenFromMenu() {
        open("");

        $$("a")
                .filterBy(exactText("О Нас"))
                .findBy(visible)
                .click();
        webdriver().shouldHave(
                url("https://abdgtl.com/"));

        $$("a")
                .filterBy(exactText("Блог"))
                .findBy(visible)
                .click();
        webdriver().shouldHave(
                url("https://abdgtl.com/blog"));

        $$("a")
                .filterBy(exactText("Технологии"))
                .findBy(visible)
                .click();
        webdriver().shouldHave(
                url("https://abdgtl.com/technologies"));

        $$("a")
                .filterBy(exactText("Продукты и услуги"))
                .findBy(visible)
                .click();
        webdriver().shouldHave(
                url("https://abdgtl.com/productsandservices"));
    }

    @Test
    @DisplayName("Тест 3. На основных страницах отображаются ожидаемые заголовки")
    void pagesShouldHaveExpectedHeadings() {
        open("");

        $$("h1, h2, h3, .tn-atom")
                .findBy(exactText("Все по-взрослому"))
                .shouldBe(visible);

        open("/blog");

        $$(".t-section__title")
                .findBy(exactText("Даем шума"))
                .shouldBe(visible);

        open("/technologies");

        $$(".t-title")
                .findBy(exactText("Технологический радар AB Digital"))
                .shouldBe(visible);

        open("/productsandservices");

        $$(".t-section__title")
                .findBy(exactText("Продукты"))
                .shouldBe(visible);
    }


    @Test
    @DisplayName("Тест 4. Кнопка вакансий содержит корректную ссылку")
    void vacancyButtonsShouldHaveCorrectLink() {
        open("");

        $$("a")
                .filterBy(exactText("Вперёд к вакансиям!"))
                .filterBy(visible)
                .shouldHave(size(2))
                .forEach(button->button.shouldBe(attribute("href", "https://kazan.hh.ru/employer/1741901?hhtmFrom=vacancy_search_list")));
    }

    @Test
    @DisplayName("Тест 5. Футер отображается")
    void footerShouldBeVisible() {
        open("");

        $("#t-footer")
                .shouldBe(visible)
                .shouldHave(
                        text("info@abdgtl.com"),
                        text("+7(843) 294-72-61")
                );

    }
}
