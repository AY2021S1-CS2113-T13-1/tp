package seedu.duke.data.timetable;

import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Test Driver to test all functionality of DailyEvent Class.
 */
class DailyEventTest {
    private static final String TEST_TITLE = "CS2113 Tutorial";
    private static final LocalDateTime TEST_DATE_TIME = LocalDateTime.of(2020, 8, 27, 13,0);
    private static final boolean TEST_REMINDER = true;
    private static final ArrayList<Integer> TEST_TIME_PERIODS = new ArrayList<>(List.of(1,3));
    private static final ArrayList<String> TEST_TIME_UNITS
            = new ArrayList<>(List.of(Event.REMINDER_DAY, Event.REMINDER_DAY));
    private final DailyEvent event = new DailyEvent(TEST_TITLE, TEST_DATE_TIME,
            TEST_REMINDER, TEST_TIME_PERIODS, TEST_TIME_UNITS);

    /**
     * Tests if the time-step for DailyEvent is still correct (1 day).
     */
    @Test
    void assertTimeStep() {
        LocalDate dateTime = LocalDate.now();
        assertEquals(dateTime.plusDays(1), event.timeStep(dateTime));
    }

    /**
     * Tests if the event reoccurs when it should.
     */
    @Test
    void assertToReoccur() {
        LocalDate startDate = TEST_DATE_TIME.toLocalDate();
        LocalDate testDate = event.timeStep(startDate);
        LocalDate testFutureDate = event.timeStep(testDate);
        assertTrue(event.toReoccur(testDate));
        assertTrue(event.toReoccur(testFutureDate));
    }

    /**
     * Tests if the event reoccurs 8 times in 1 week and 1 day.
     */
    @Test
    void assertGetRecurrences() {
        LocalDate startDate = TEST_DATE_TIME.toLocalDate();
        LocalDate endDate = startDate.plusWeeks(1);
        assertEquals(8, (event.getRecurrences(startDate, endDate).size()));
    }
}