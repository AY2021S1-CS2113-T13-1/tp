package seedu.notus.command;

import static seedu.notus.util.PrefixSyntax.PREFIX_DATETIME;
import static seedu.notus.util.PrefixSyntax.PREFIX_DELIMITER;
import static seedu.notus.util.PrefixSyntax.PREFIX_INDEX;
import static seedu.notus.util.PrefixSyntax.PREFIX_RECURRING;
import static seedu.notus.util.PrefixSyntax.PREFIX_REMIND;
import static seedu.notus.util.PrefixSyntax.PREFIX_TITLE;

//@@author brandonywl
/**
 * Edits a Note in the Notebook or an Event from the Timetable.
 */
public class EditEventCommand extends Command {

    public static final String COMMAND_WORD = "edit-e";

    public static final String COMMAND_USAGE = COMMAND_WORD + ": Edits an event in the timetable. "
            + "Parameters: " + PREFIX_DELIMITER + PREFIX_INDEX + " INDEX "
            + "[" + PREFIX_DELIMITER + PREFIX_TITLE + " TITLE] "
            + "[" + PREFIX_DELIMITER + PREFIX_DATETIME + " DATE_TIME] "
            + "[" + PREFIX_DELIMITER + PREFIX_RECURRING + " RECURRING] "
            + "[" + PREFIX_DELIMITER + PREFIX_REMIND + " REMIND]";

    private int index;

    /**
     * Constructs an EditEventCommand to edit an Event.
     *
     * @param index of the Event to be edited.
     */
    public EditEventCommand(int index) {
        this.index = index;
    }

    @Override
    public String execute() {
        return null;
    }
}
