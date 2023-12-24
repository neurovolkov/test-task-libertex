package core;

import core.exception.InvalidDateFormatException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.logging.Logger;

import static core.constant.DateFormattersProvider.DATE_FORMATTERS;

public class Utils {

    public static final Logger log = Logger.getLogger("main stream");

    public static boolean isAdult(String date) {
        for (DateTimeFormatter formatter : DATE_FORMATTERS) {
            try {
                LocalDate dateOfBirth = formatter.parse(date, LocalDate::from);
                LocalDate now = LocalDate.now();
                return !now.minusYears(18).isBefore(dateOfBirth);
            } catch (RuntimeException ignore) {
            }
        }
        throw new InvalidDateFormatException("Unknown date format");
    }
}
