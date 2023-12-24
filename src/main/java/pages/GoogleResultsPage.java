package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.WebDriverRunner.url;

public class GoogleResultsPage {

    private final String urlPart = "https://www.google.com/search?";

    private final SelenideElement mainTitle = $("[data-attrid='title'][role='heading'][aria-level='2']");
    private final SelenideElement googleLogoImg = $(".logo");

    public String getUrlPart() {
        return urlPart;
    }

    public GoogleResultsPage checkGoogleResultsPage() {
        assert url().contains(getUrlPart());
        return new GoogleResultsPage();
    }

    public String getMainTitleText() {
        return mainTitle.getText();
    }

    public GoogleBasePage clickOnGoogleLogo() {
        googleLogoImg.click();
        return new GoogleBasePage();
    }

}
