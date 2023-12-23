import org.testng.annotations.Test;

import static com.codeborne.selenide.Selenide.*;

public class GoogleWebTests extends Base {

    @Test
    public void test1() {
        open("https://www.google.com");
        $("textarea[type='search']").setValue("Volkov Oleg").pressEnter();
    }
}
