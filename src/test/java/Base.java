import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;
import pages.GoogleBasePage;

import java.util.Map;

import static com.codeborne.selenide.Selenide.open;

public class Base {

    @BeforeClass
    public void setup() {
        System.setProperty("chromeoptions.prefs", "intl.accept_languages=en");
        Configuration.browser = "chrome";
        Configuration.remote = "http://127.0.0.1:8080/wd/hub";
        Configuration.browserSize = "1920x1080";
        Configuration.holdBrowserOpen = true;
        Configuration.browserCapabilities.setCapability("selenoid:options", Map.<String, Object>of(
                "enableVNC", true,
                "enableVideo", false
        ));
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--incognito");
        Configuration.browserCapabilities.setCapability(ChromeOptions.CAPABILITY, options);
    }

    public GoogleBasePage openGoogleBasePage() {
        var basePage = new GoogleBasePage();
        open(basePage.getUrl());
        return basePage;
    }
}
