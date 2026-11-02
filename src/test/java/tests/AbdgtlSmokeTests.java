package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.MainPage;
import pages.components.FooterComponent;
import pages.components.HeaderComponent;

import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;


public class AbdgtlSmokeTests extends AbdgtlBase {

    private final HeaderComponent header = new HeaderComponent();
    private final FooterComponent footer = new FooterComponent();
    private final MainPage mainPage = new MainPage();

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

        header.clickMenuItem("О Нас");
        webdriver().shouldHave(url(baseUrl + "/"));

        header.clickMenuItem("Блог");
        webdriver().shouldHave(url(baseUrl + "/blog"));

        header.clickMenuItem("Технологии");
        webdriver().shouldHave(url(baseUrl + "/technologies"));

        header.clickMenuItem("Продукты и услуги");
        webdriver().shouldHave(url(baseUrl + "/productsandservices"));

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

        header.checkVacancyButtons();

    }

    @Test
    @DisplayName("Тест 5. Футер отображается")
    void footerShouldBeVisible() {
        String email = "info@abdgtl.com";
        String phone = "+7(843) 294-72-61";

        open("");

        footer.checkContacts(email, phone);

    }

    @Test
    @DisplayName("Тест 6. Ссылки на юридические документы отображаются и содержат корректные адреса")
    void legalDocumentLinksShouldBeAvailable() {
        String textPolice = "Политика обработки персональных данных";
        String hrefPolice = "https://static.abdt.ru/docs/privacy_policy.pdf";
        String textUser = "Пользовательское соглашение использования сайта";
        String hrefUser = "https://static.abdt.ru/docs/user_agreement_for_site_use.pdf";

        open("");

        mainPage.checkLegalLink(textPolice, hrefPolice);

        mainPage.checkLegalLink(textUser, hrefUser);

    }
}
