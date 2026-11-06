package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class MainPage {
    private final ElementsCollection links = $$("a");

    public MainPage openPage() {
        open("");
        return this;
    }

    public MainPage checkHeading(String heading) {
        $$("h1, h2, h3, .tn-atom")
                .findBy(exactText(heading))
                .shouldBe(visible);
        return this;
    }

    public MainPage checkSlogan(String textSearch, String textSlogan) {
        $$(".tn-atom")
                .filterBy(text(textSearch))
                .findBy(visible)
                .scrollTo()
                .shouldHave(text(textSlogan));
        return this;
    }

    public MainPage checkLegalLink(String linkText, String href) {

        links
                .filterBy(exactText(linkText))
                .shouldHave(size(1))
                .first()
                .scrollTo()
                .shouldBe(visible)
                .shouldHave(attribute(
                        "href",
                        href));
        return this;
    }

    public MainPage checkUrl() {
        webdriver().shouldHave(url(baseUrl + "/"));
        return this;
    }

    public MainPage checkVacancyButtons(String href) {
        links
                .filterBy(exactText("Вперёд к вакансиям!"))
                .filterBy(visible)
                .shouldHave(size(2))
                .forEach(button ->
                        button.shouldHave(attribute("href", href))
                );
        return this;
    }
}
