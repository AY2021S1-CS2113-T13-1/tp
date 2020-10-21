package seedu.notus.command;

import seedu.notus.data.timetable.Reminder;
import seedu.notus.ui.Formatter;

import java.util.ArrayList;

/**
 * Returns all the reminders that should occur today.
 */
public class RemindCommand extends Command {

    public static final String COMMAND_WORD = "remind-e";

    public static final String COMMAND_USAGE = COMMAND_WORD + ": Shows the reminders for today.";

    /**
     * Default constructor of RemindEvent. No arguments are expected as we are only looking at reminders today.
     */
    public RemindCommand() {

    }

    @Override
    public String execute() {
        ArrayList<Reminder> reminders = timetable.getReminders();
        StringBuilder result = new StringBuilder("Reminders:" + Formatter.LS);
        if (reminders.size() == 0) {
            result.append("No reminders today!");
        }
        String lineSep = "";
        for (Reminder reminder : reminders) {
            result.append(lineSep).append(reminder.toString());
            lineSep = Formatter.LS;
        }
        return result.toString();
    }
}
