package tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class AbdgtlBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = System.getProperty("BASE_URL", "https://abdgtl.com");
        Configuration.browser = System.getProperty("BROWSER", "chrome");
//        Configuration.browserVersion = System.getProperty("BROWSER_VERSION", "151.0");
        Configuration.browserSize = System.getProperty("BROWSER_SIZE", "1920x1080");
        Configuration.timeout = 15000;
        Configuration.pageLoadStrategy = "eager";
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
        SelenideLogger.addListener("allure", new AllureSelenide());
//        Configuration.browserCapabilities = capabilities;
//        Configuration.remote = String.format(
//                "https://%s:%s@%s",
//                System.getProperty("REMOTE_LOGIN", "user1"),
//                System.getProperty("REMOTE_PASSWORD", "1234"),
//                System.getProperty("REMOTE_URL", "selenoid.autotests.cloud/wd/hub")
//        );
    }

    @AfterEach
    void addAttachments() {
        Attach.screenshotAs("Last screenshot");
        Attach.pageSource();
        Attach.browserConsoleLogs();
//        Attach.addVideo();
        closeWebDriver();
    }
}
