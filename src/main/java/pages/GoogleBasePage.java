package pages;

import com.codeborne.selenide.SelenideElement;

import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$x;

public class GoogleBasePage {

    private final String url = "https://www.google.com";
    private final SelenideElement searchField = $("[name='q']");
    private final SelenideElement googleLangEnButton = $x("//a[contains(@href, 'google.com/setprefs') and text()='English']");

    private final SelenideElement googleLogoImg = $x("//img[@alt='Google' and number(@width) > 200]");

    public String getUrl() {
        return url;
    }

    public SelenideElement getGoogleLogo() {
        return googleLogoImg;
    }

    public GoogleResultsPage doSearch(String value) {
        searchField.setValue(value).pressEnter();
        return new GoogleResultsPage();
    }

    public GoogleBasePage hoverCursorOnSearchField() {
        searchField.hover();
        return this;
    }

    public GoogleBasePage setEnglishLanguage() {
        googleLangEnButton.click();
        return this;
    }

    public String getTooltipText() {
        return searchField.getAttribute("title");
    }

}
