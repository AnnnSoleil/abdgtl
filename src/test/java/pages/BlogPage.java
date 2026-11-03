package pages;

import static com.codeborne.selenide.Condition.exactText;
import static com.codeborne.selenide.Condition.visible;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class BlogPage {

        public BlogPage openPageBlog() {
            open("/blog");
            return this;
        }
        public BlogPage checkHeadingBlog(String heading) {
            $$(".t-section__title")
                    .findBy(exactText(heading))
                    .shouldBe(visible);
            return this;
        }
    }
