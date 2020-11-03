package seedu.notus.data.timetable;

import seedu.notus.data.tag.Tag;
import seedu.notus.data.tag.TaggableObject;
import seedu.notus.ui.Formatter;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;

//@@author brandonywl
/**
 * Represents an Event. Contains all the information of an Event.
 */
public class Event extends TaggableObject implements Comparable<Event> {
    public static final String REMINDER_DAY = "day";
    public static final String REMINDER_WEEK = "week";

    private String title;
    private LocalDateTime startDateTime;
    private LocalDateTime endDateTime;
    private Boolean isToRemind;
    private Boolean isRecurring;
    private HashMap<String, ArrayList<Integer>> reminderPeriods = new HashMap<>();
    private ArrayList<Tag> tags = new ArrayList<>();


    /**
     * Creates an Event object with its title, date and time provided.
     *
     * @param title Title of the event.
     * @param startDateTime Start DateTime of the event.
     */
    public Event(String title, LocalDateTime startDateTime) {
        this.title = title;
        this.startDateTime = startDateTime;
        this.isToRemind = false;
        this.isRecurring = false;
    }

    /**
     * Creates an Event object with its title, date, time, isToRemind and isRecurring provided.
     *
     * @param title Title of the event.
     * @param startDateTime Start DateTime of the event.
     * @param isToRemind Whether the event requires a reminder.
     * @param isRecurring Whether the event will re-occur.
     */
    public Event(String title, LocalDateTime startDateTime, boolean isToRemind, boolean isRecurring) {
        this(title, startDateTime);
        this.isToRemind = isToRemind;
        this.isRecurring = isRecurring;
    }

    /**
     * Creates an Event object with its title, date, time, isToRemind, isRecurring, reminder periods and tags provided.
     *
     * @param title Title of event.
     * @param startDateTime Start DateTime of event.
     * @param isToRemind Whether the event requires a reminder.
     * @param isRecurring Whether the event will reoccur.
     * @param reminderPeriods When the reminders will be given.
     * @param tags Tags of the event.
     */
    public Event(String title, LocalDateTime startDateTime, boolean isToRemind, boolean isRecurring,
                  HashMap<String, ArrayList<Integer>> reminderPeriods, ArrayList<Tag> tags) {
        this(title, startDateTime, isToRemind, isRecurring);
        this.reminderPeriods = reminderPeriods;
        this.tags = tags;
    }

    /**
     * Creates an Event object with its title, date, time, isToRemind, isRecurring as well as reminder periods provided.
     *
     * @param title Title of event.
     * @param startDateTime Start DateTime of event.
     * @param isToRemind Whether the event requires a reminder.
     * @param isRecurring Whether the event will reoccur.
     * @param reminderPeriods When the reminders will be given.
     */
    public Event(String title, LocalDateTime startDateTime, boolean isToRemind, boolean isRecurring,
                 HashMap<String, ArrayList<Integer>> reminderPeriods) {
        this(title, startDateTime, isToRemind, isRecurring);
        this.reminderPeriods = reminderPeriods;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getStartDateTime() {
        return startDateTime;
    }

    public void setStartDateTime(LocalDateTime dateTime) {
        startDateTime = dateTime;
    }

    public LocalDate getStartDate() {
        return startDateTime.toLocalDate();
    }

    public LocalTime getStartTime() {
        return startDateTime.toLocalTime();
    }

    public LocalDateTime getEndDateTime() {
        return endDateTime;
    }

    public void setEndDateTime(LocalDateTime dateTime) {
        endDateTime = dateTime;
    }

    public LocalDate getEndDate() {
        return endDateTime.toLocalDate();
    }


    public LocalTime getEndTime() {
        return endDateTime.toLocalTime();
    }

    public String getDateTime() {
        return startDateTime.toLocalDate().toString() + " " + startDateTime.toLocalTime().toString();
    }

    public boolean getIsToRemind() {
        return isToRemind;
    }

    public void setIsToRemind(boolean isToRemind) {
        this.isToRemind = isToRemind;
    }

    public HashMap<String, ArrayList<Integer>> getReminderPeriods() {
        return this.reminderPeriods;
    }

    public void setReminderPeriods(HashMap<String, ArrayList<Integer>> reminderPeriods) {
        this.reminderPeriods = reminderPeriods;
    }

    public boolean getRecurring() {
        return isRecurring;
    }

    public ArrayList<String> getReminderPeriodsString() {
        ArrayList<String> periods = new ArrayList<>();

        ArrayList<Integer> dayRepeatPeriod = reminderPeriods.get(REMINDER_DAY);
        ArrayList<Integer> weekRepeatPeriod = reminderPeriods.get(REMINDER_WEEK);
        if (dayRepeatPeriod != null) {
            dayRepeatPeriod.sort(Integer::compareTo);
            for (Integer unit: dayRepeatPeriod) {
                periods.add(unit + "-day");
            }
        }

        if (weekRepeatPeriod != null) {
            weekRepeatPeriod.sort(Integer::compareTo);
            for (Integer unit : weekRepeatPeriod) {
                periods.add(unit + "-week");
            }
        }
        return periods;
    }

    /**
     * Get all the reminder dates from that this Event would have.
     *
     * @return An ArrayList of Dates that reminders of this event should show.
     */

    public ArrayList<LocalDate> getReminderDates() {
        ArrayList<LocalDate> dates = new ArrayList<>();
        if (!isToRemind) {
            return dates;
        }
        for (String unit : reminderPeriods.keySet()) {
            ArrayList<Integer> timePeriodsInUnit = reminderPeriods.get(unit);
            LocalDate date = this.startDateTime.toLocalDate();
            for (Integer timePeriod : timePeriodsInUnit) {
                switch (unit) {
                case REMINDER_DAY:
                    date = this.startDateTime.toLocalDate().plusDays(-timePeriod);
                    break;
                case REMINDER_WEEK:
                    date = this.startDateTime.toLocalDate().plusWeeks(-timePeriod);
                    break;
                default:
                    break;
                }
                dates.add(date);
            }
        }
        dates.sort(LocalDate::compareTo);
        return dates;
    }

    /**
     * Converts an Event to a format for a reminder.
     *
     * @return Reduced String representation of an Event.
     */
    public String toReminderString() {
        String titleString = "Event: " + title;
        String dateString = "Date: " + startDateTime.toLocalDate().toString()
                + "\tTime: " + startDateTime.toLocalTime().toString();
        return titleString + Formatter.LS + dateString;
    }

    @Override
    public String toString() {
        String titleString = "Event: " + title;
        String dateString = "Date: " + startDateTime.toLocalDate().toString()
                + "\tTime: " + startDateTime.toLocalTime().toString();
        String remindString = "Reminder: " + isToRemind;
        String repeatingString = "Repeating: " + isRecurring;
        String lineSeparator = Formatter.LS;
        return titleString + lineSeparator + dateString + lineSeparator + remindString
                + lineSeparator + repeatingString;
    }

    @Override
    public int compareTo(Event o) {
        return startDateTime.compareTo(o.startDateTime);
    }
}
