package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$;

public class HeaderComponent {
    private static final String VACANCY_URL = "https://kazan.hh.ru/employer/1741901?hhtmFrom=vacancy_search_list";

    private final SelenideElement header = $("#t-header");
    private final ElementsCollection links = header.$$("a");

    public HeaderComponent clickMenuItem(String menuItem) {
        links
                .filterBy(exactText(menuItem))
                .findBy(visible)
                .click();
        return this;
    }

    public HeaderComponent checkVacancyButtons() {
        links
                .filterBy(exactText("Вперёд к вакансиям!"))
                .filterBy(visible)
                .shouldHave(size(1))
                .forEach(button ->
                        button.shouldHave(attribute("href", VACANCY_URL))
                        );
        return this;
    }
}
