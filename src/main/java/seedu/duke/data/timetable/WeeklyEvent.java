package seedu.duke.data.timetable;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class WeeklyEvent extends RecurringEvent {
    private static final int TIME_STEP = 1;

    public WeeklyEvent(String title, LocalDateTime dateTime, boolean isToRemind, LocalDate endRecurrance) {
        super(title, dateTime, isToRemind, endRecurrance, RecurringEvent.WEEKLY_RECURRENCE);
    }

    public WeeklyEvent(String title, LocalDateTime dateTime, boolean isToRemind) {
        super(title, dateTime, isToRemind, RecurringEvent.WEEKLY_RECURRENCE);
    }

    @Override
    public RecurringEvent stepOneTimePeriod() {
        LocalDate date = timeStep(getDate());
        return new WeeklyEvent(getTitle(), LocalDateTime.of(date, getTime()), getToRemind());
    }

    @Override
    public LocalDate timeStep(LocalDate date) {
        return date.plusWeeks(TIME_STEP);
    }
}