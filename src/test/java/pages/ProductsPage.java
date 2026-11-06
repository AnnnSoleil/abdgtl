package pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ProductsPage {
    private static final String PATH = "/productsandservices";

    public ProductsPage openPage() {
        open(PATH);
        return this;
    }

    public ProductsPage checkHeading(String heading) {
        $$(".t-section__title")
                .findBy(exactText(heading))
                .shouldBe(visible);
        return this;
    }

    public ProductsPage checkUrl() {
        webdriver().shouldHave(url(baseUrl + PATH));
        return this;
    }
}
