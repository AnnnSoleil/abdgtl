package tests;

import com.codeborne.selenide.SelenideElement;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.CollectionCondition.sizeGreaterThan;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selectors.byPlaceholder;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.WebDriverConditions.urlContaining;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;


public class AbdgtlSmokeTests extends AbdgtlBase {
    @Test
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
//    @Test
//    void mainPageShouldDisplayMainElements() {
//        open ("");
//
//        SelenideElement cookieBanner =
//                $("[aria-label='Уведомление об использовании файлов cookie']");
//
//        if (cookieBanner.isDisplayed()) {
//            cookieBanner.$("button").click();
//        }
//
//        $(byPlaceholder("Найти событие, артиста или место"))
//                .shouldBe(visible);
//
//        $$("img.tl-image__image[alt]")
//                .shouldBe(sizeGreaterThan(0))
//                .first()
//                .shouldBe(visible);
//    }
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
