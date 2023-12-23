import core.exception.InvalidDateFormatException;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import static core.Utils.isAdult;
import static java.time.LocalDate.now;
import static org.testng.Assert.assertEquals;

public class AgeTests {

    @DataProvider(name = "correctDateProvider")
    public Object[][] dateProvider() {
        return new Object[][]{
                {String.valueOf(now().minusYears(18)), true},
                {"12.12.1950", true},
                {"12.12.2020", false},
                {"12 12 1950", true},
                {"12 12 2020", false},
                {"12/12/1950", true},
                {"12/12/2020", false},
                {"12-12-1950", true},
                {"12-12-2020", false},
                {"1950.12.12", true},
                {"2020.12.12", false},
                {"1950 12 12", true},
                {"2020 12 12", false},
                {"1950/12/12", true},
                {"2020/12/12", false},
                {"1950-12-12", true},
                {"2020-12-12", false}
        };
    }

    @Test(dataProvider = "correctDateProvider")
    public void checkIsAdult(String date, boolean expectedResult) {
        boolean result = isAdult(date);
        assertEquals(result, expectedResult, "Unexpected result for date: " + date);
    }

    @Test(expectedExceptions = InvalidDateFormatException.class)
    public void checkInvalidDate() {
        isAdult("20201212");
    }
}