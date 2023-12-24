import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class GoogleWebTests extends Base {

    @Test(description = "Checking search by name and full name", priority = 1)
    public void checkingSearchResults() {
        var name = "Winston Churchill";
        var fullName = "Winston Leonard Spencer Churchill";

        var googleResultsPage = openGoogleBasePage().doSearch(name);
        var resultByName = googleResultsPage.getMainTitleText();

        var resultByFullName = googleResultsPage
                .clickOnGoogleLogo()
                .doSearch(fullName)
                .getMainTitleText();
        assertEquals(resultByName, resultByFullName);
    }

    @Test(description = "Checking for empty screen after clicking on Google logo", priority = 2)
    public void checkingEmptyResultsAreaAfterGoogleLogoClick() {
        var text = "Random text";
        var googleLogo = openGoogleBasePage()
                .doSearch(text)
                .checkGoogleResultsPage()
                .clickOnGoogleLogo()
                .getGoogleLogo();
        assertTrue(googleLogo.isDisplayed());
    }


    @Test(description = "Checking tooltip text above search field", priority = 3)
    public void checkingTooltipOnGoogleSearchField() {
        var tooltipText = openGoogleBasePage()
                .setEnglishLanguage()
                .hoverCursorOnSearchField()
                .getTooltipText();
        assertEquals("Search", tooltipText);
    }
}
