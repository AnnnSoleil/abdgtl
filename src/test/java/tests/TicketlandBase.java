package tests;

import com.codeborne.selenide.Configuration;
//import helpers.Attach;
import org.junit.jupiter.api.BeforeAll;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Map;

public class TicketlandBase {
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = System.getProperty("BASE_URL", "https://www.ticketland.ru/");
        Configuration.browser = System.getProperty("BROWSER", "chrome");
//        Configuration.browserVersion = System.getProperty("BROWSER_VERSION", "151.0");
        Configuration.browserSize = System.getProperty("BROWSER_SIZE", "1920x1080");
        Configuration.timeout = 15000;
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", true
        ));
//        Configuration.browserCapabilities = capabilities;
//        Configuration.remote = String.format(
//                "https://%s:%s@%s",
//                System.getProperty("REMOTE_LOGIN", "user1"),
//                System.getProperty("REMOTE_PASSWORD", "1234"),
//                System.getProperty("REMOTE_URL", "selenoid.autotests.cloud/wd/hub")
//        );
    }
//    @AfterEach
//    void addAttachments() {
//        Attach.screenshotAs("Last screenshot");
//        Attach.pageSource();
//        Attach.browserConsoleLogs();
//        Attach.addVideo();
//        Attach.attachAsText("Some file", "Some content");
//        closeWebDriver();
//    }
}
