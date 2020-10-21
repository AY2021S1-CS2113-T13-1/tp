package seedu.notus.command;

import org.junit.jupiter.api.Test;
import seedu.notus.data.timetable.DailyEvent;
import seedu.notus.data.timetable.Event;
import seedu.notus.data.timetable.Timetable;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Driver class of AddEventCommandTest to ensure that adding an event to a timetable is correct. Variables point to the
 * same object in memory.
 */
class AddEventCommandTest {
    private static final String TEST_TITLE = "CS2113 Tutorial";
    private static final LocalDateTime TEST_DATE_TIME = LocalDateTime.of(2020, 8, 27, 13,0);
    private static final boolean TEST_REMINDER = true;
    private static final ArrayList<Integer> TEST_TIME_PERIODS = new ArrayList<>(List.of(1,3));
    private static final ArrayList<String> TEST_TIME_UNITS
            = new ArrayList<>(List.of(Event.REMINDER_DAY, Event.REMINDER_DAY));

    private final Event event = new DailyEvent(TEST_TITLE, TEST_DATE_TIME,
            TEST_REMINDER, TEST_TIME_PERIODS, TEST_TIME_UNITS);

    private static final Timetable TIMETABLE = new Timetable();



    private AddEventCommand command = new AddEventCommand(event);

    /**
     * Test adding an event to an empty timetable and check if it is referencing the same Event in the heap.
     */
    @Test
    void execute_singleEvent_success() {
        command.setData(null, TIMETABLE, null, null);
        command.execute();
        assertTrue(command.timetable.getEvent(0) == (event));
    }
}