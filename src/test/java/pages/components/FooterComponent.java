package pages.components;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$;

public class FooterComponent {
    private final SelenideElement footer = $("#t-footer");

    public FooterComponent checkContacts(String email, String phone) {
        footer
                .scrollTo()
                .shouldBe(visible)
                .shouldHave(
                        text(email),
                        text(phone)
                );
        return this;
    }

}
