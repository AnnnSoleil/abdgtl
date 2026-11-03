package pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;

public class TechnologiesPage {
    private static final String PATH = "/technologies";

    public TechnologiesPage openPageTechnologies() {
        open(PATH);
        return this;
    }

    public TechnologiesPage checkHeadingTechnologies(String heading) {
        $$(".t-title")
                .findBy(exactText(heading))
                .shouldBe(visible);
        return this;
    }

    public TechnologiesPage checkUrlTechnologies() {
        webdriver().shouldHave(url(baseUrl + PATH));
        return this;
    }
}
