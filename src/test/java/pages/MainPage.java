package pages;

import com.codeborne.selenide.ElementsCollection;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Selenide.$$;

public class MainPage {
    private final ElementsCollection links = $$("a");

    public MainPage checkLegalLink(String linkText, String href) {

        links
                .filterBy(exactText(linkText))
                .shouldHave(size(1))
                .first()
                .shouldBe(visible)
                .shouldHave(attribute(
                        "href",
                        href));
        return this;
    }
}
