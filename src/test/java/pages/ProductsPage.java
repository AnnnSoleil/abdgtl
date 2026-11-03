package pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class ProductsPage {
    private static final String PATH = "/productsandservices";

    public ProductsPage openPageProducts() {
        open(PATH);
        return this;
    }

    public ProductsPage checkHeadingProducts(String heading) {
        $$(".t-section__title")
                .findBy(exactText(heading))
                .shouldBe(visible);
        return this;
    }

    public ProductsPage checkUrlProducts() {
        webdriver().shouldHave(url(baseUrl + PATH));
        return this;
    }
}
