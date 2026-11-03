package pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Configuration.baseUrl;
import static com.codeborne.selenide.Selenide.*;
import static com.codeborne.selenide.WebDriverConditions.url;


public class BlogPage {
    private static final String PATH = "/blog";

    public BlogPage openPageBlog() {
        open(PATH);
        return this;
    }

    public BlogPage checkHeadingBlog(String heading) {
        $$(".t-section__title")
                .findBy(exactText(heading))
                .shouldBe(visible);
        return this;
    }

    public BlogPage checkUrlBlog() {
        webdriver().shouldHave(url(baseUrl + PATH));
        return this;
    }
}
