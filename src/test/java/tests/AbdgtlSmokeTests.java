package tests;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Tag;
import org.junit.jupiter.api.Test;
import pages.BlogPage;
import pages.MainPage;
import pages.ProductsPage;
import pages.TechnologiesPage;
import pages.components.FooterComponent;
import pages.components.HeaderComponent;

@Owner("AnnnSoleil")
@Tag("smoke")
@Link(value = "abdgtl.com", url = "https://abdgtl.com")
public class AbdgtlSmokeTests extends AbdgtlBase {

    private final HeaderComponent header = new HeaderComponent();
    private final FooterComponent footer = new FooterComponent();
    private final MainPage mainPage = new MainPage();
    private final BlogPage blogPage = new BlogPage();
    private final TechnologiesPage technologiesPage = new TechnologiesPage();
    private final ProductsPage productsPage = new ProductsPage();

    @Test
    @Feature("Главная страница")
    @Story("Открытие главной страницы")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("Тест 1. Главная страница открывается")
    void mainPageShouldOpen() {
        String textSearch = "Мы разрабатываем цифровые экосистемы";
        String textSlogan = "Мы разрабатываем цифровые экосистемы и внедряем новые технологичные продукты для удобства клиентов банка";
        mainPage.openPage()
                .checkUrl()
                .checkSlogan(textSearch, textSlogan);

    }

    @Test
    @Feature("Навигация")
    @Story("Переход по пунктам меню")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тест 2. Дочерние страницы открываются из меню")
    void childPagesShouldOpenFromMenu() {

        mainPage.openPage();

        header.clickMenuItem("О Нас");
        mainPage.checkUrl();

        header.clickMenuItem("Блог");
        blogPage.checkUrl();

        header.clickMenuItem("Технологии");
        technologiesPage.checkUrl();

        header.clickMenuItem("Продукты и услуги");
        productsPage.checkUrl();
    }

    @Test
    @Feature("Навигация")
    @Story("Отображение заголовков основных страниц")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тест 3. На основных страницах отображаются ожидаемые заголовки")
    void pagesShouldHaveExpectedHeadings() {
        mainPage.openPage()
                .checkHeading("Все по-взрослому");

        blogPage.openPage()
                .checkHeading("Даем шума");

        technologiesPage.openPage()
                .checkHeading("Технологический радар AB Digital");

        productsPage.openPage()
                .checkHeading("Продукты");
    }


    @Test
    @Feature("Главная страница")
    @Story("Кнопки вакансий ведут на hh.ru")
    @Severity(SeverityLevel.CRITICAL)
    @DisplayName("Тест 4. Кнопка вакансий содержит корректную ссылку")
    void vacancyButtonsShouldHaveCorrectLink() {
        String vacancyUrl = "https://kazan.hh.ru/employer/1741901?hhtmFrom=vacancy_search_list";

        mainPage.openPage()
                .checkVacancyButtons(vacancyUrl);

        header.checkVacancyButton();
    }

    @Test
    @Feature("Футер")
    @Story("Футер отображается")
    @Severity(SeverityLevel.NORMAL)
    @DisplayName("Тест 5. Футер отображается")
    void footerShouldBeVisible() {
        String email = "info@abdgtl.com";
        String phone = "+7(843) 294-72-61";

        mainPage.openPage();

        footer.checkContacts(email, phone);
    }

    @Test
    @Feature("Юридические документы")
    @Story("Отображаются правильные ссылки на юридические документы")
    @Severity(SeverityLevel.CRITICAL)
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
