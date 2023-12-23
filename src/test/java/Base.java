import com.codeborne.selenide.Configuration;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.BeforeClass;

import java.util.Map;

public class Base {

    @BeforeClass
    public void setup() {
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
}
