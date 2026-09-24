package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byPlaceholder;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;


public class AbdgtlSmokeTests extends AbdgtlBase {
    @Test
    @DisplayName("Главная страница открывается")
    void mainPageShouldOpen() {
        open ("");

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
    @DisplayName("Дочерние страницы открываются из меню")
    void childPagesShouldOpenFromMenu() {
        open ("");

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
//    @Test
//    void eventCardShouldOpenEventPage() {
//        open("");
//
//        SelenideElement cookieBanner =
//                $("[aria-label='Уведомление об использовании файлов cookie']");
//
//        if (cookieBanner.isDisplayed()) {
//            cookieBanner.$("button").click();
//        }
//
//        $("[aria-label='Открыть Всё будет Челентано']")
//                .shouldBe(visible)
//                .click();
//
//        webdriver().shouldHave(urlContaining("/vsyo-budet-chelentano/"));
//
//
//        $("h1").shouldBe(visible)
//                .shouldHave(text("Всё будет Челентано"));
//    }

}
