package pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class TechnologiesPage {

    public TechnologiesPage openPageTechnologies() {
        open("/technologies");
        return this;
    }
    public TechnologiesPage checkHeadingTechnologies(String heading) {
        $$(".t-title")
                .findBy(exactText(heading))
                .shouldBe(visible);
        return this;
    }
}


