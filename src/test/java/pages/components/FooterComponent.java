package pages.components;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.CollectionCondition.size;
import static com.codeborne.selenide.Condition.*;
import static com.codeborne.selenide.Condition.attribute;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;

public class FooterComponent {
    private final SelenideElement footer = $("#t-footer");
    private final ElementsCollection links = footer.$$("a");

    public FooterComponent checkContacts(String email,String phone){
        footer
                .shouldBe(visible)
                .shouldHave(
                        text(email),
                        text(phone)
                );
        return this;
    }

}
