package pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class ProductsPage {
    public ProductsPage openPageProducts() {
        open("/productsandservices");
        return this;
    }
    public ProductsPage checkHeadingProducts(String heading) {
        $$(".t-section__title")
                .findBy(exactText(heading))
                .shouldBe(visible);
        return this;
    }
}
