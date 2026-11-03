package tests;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pages.BlogPage;
import pages.MainPage;
import pages.ProductsPage;
import pages.TechnologiesPage;
import pages.components.FooterComponent;
import pages.components.HeaderComponent;

import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.webdriver;
import static com.codeborne.selenide.WebDriverConditions.urlStartingWith;


public class AbdgtlSmokeTests extends AbdgtlBase {

    private final HeaderComponent header = new HeaderComponent();
    private final FooterComponent footer = new FooterComponent();
    private final MainPage mainPage = new MainPage();
    private final BlogPage blogPage = new BlogPage();
    private final TechnologiesPage technologiesPage = new TechnologiesPage();
    private final ProductsPage productsPage = new ProductsPage();

    @Test
    @DisplayName("Тест 1. Главная страница открывается")
    void mainPageShouldOpen() {
        String textSearch = "Мы разрабатываем цифровые экосистемы";
        String textSlogan = "Мы разрабатываем цифровые экосистемы и внедряем новые технологичные продукты для удобства клиентов банка";
        mainPage.openPage()
                .checkingSlogan(textSearch, textSlogan);

        webdriver().shouldHave(urlStartingWith(baseUrl));
    }

    @Test
    @DisplayName("Тест 2. Дочерние страницы открываются из меню")
    void childPagesShouldOpenFromMenu() {

        mainPage.openPage();

        header.clickMenuItem("О Нас");
        mainPage.checkUrl();

        header.clickMenuItem("Блог");
        blogPage.checkUrlBlog();

        header.clickMenuItem("Технологии");
        technologiesPage.checkUrlTechnologies();

        header.clickMenuItem("Продукты и услуги");
        productsPage.checkUrlProducts();
    }

    @Test
    @DisplayName("Тест 3. На основных страницах отображаются ожидаемые заголовки")
    void pagesShouldHaveExpectedHeadings() {
        mainPage.openPage()
                .checkingHeading("Все по-взрослому");

        blogPage.openPageBlog()
                .checkHeadingBlog("Даем шума");

        technologiesPage.openPageTechnologies()
                .checkHeadingTechnologies("Технологический радар AB Digital");

        productsPage.openPageProducts()
                .checkHeadingProducts("Продукты");
    }


    @Test
    @DisplayName("Тест 4. Кнопка вакансий содержит корректную ссылку")
    void vacancyButtonsShouldHaveCorrectLink() {
        mainPage.openPage();

        header.checkVacancyButtons();

    }

    @Test
    @DisplayName("Тест 5. Футер отображается")
    void footerShouldBeVisible() {
        String email = "info@abdgtl.com";
        String phone = "+7(843) 294-72-61";

        mainPage.openPage();

        footer.checkContacts(email, phone);
    }

    @Test
    @DisplayName("Тест 6. Ссылки на юридические документы отображаются и содержат корректные адреса")
    void legalDocumentLinksShouldBeAvailable() {
        String textPolicy = "Политика обработки персональных данных";
        String hrefPolicy = "https://static.abdt.ru/docs/privacy_policy.pdf";
        String textUser = "Пользовательское соглашение использования сайта";
        String hrefUser = "https://static.abdt.ru/docs/user_agreement_for_site_use.pdf";

        mainPage.openPage()
                .checkLegalLink(textPolicy, hrefPolicy)
                .checkLegalLink(textUser, hrefUser);
    }
}
