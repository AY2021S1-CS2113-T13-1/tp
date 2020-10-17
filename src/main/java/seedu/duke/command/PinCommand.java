package seedu.duke.command;

import seedu.duke.data.notebook.Note;
import seedu.duke.ui.Formatter;

import static seedu.duke.util.PrefixSyntax.PREFIX_DELIMITER;
import static seedu.duke.util.PrefixSyntax.PREFIX_INDEX;
import static seedu.duke.util.PrefixSyntax.PREFIX_TITLE;

/**
 * Pins or unpins a Note in the Notebook.
 */
public class PinCommand extends Command {

    public static final String COMMAND_WORD = "pin-n";

    public static final String COMMAND_USAGE = COMMAND_WORD + ": Pins or unpins a note. Parameters: "
            + "[" + PREFIX_DELIMITER + PREFIX_INDEX + " INDEX] "
            + "[" + PREFIX_DELIMITER + PREFIX_TITLE + " TITLE]";

    public static final String COMMAND_UNSUCCESSFUL_MESSAGE = "This note does not exists in the notebook";

    private int index;
    private String title;
    private boolean isPinByIndex;

    /**
     * Constructs a PinCommand to pin or unpin a Note in the Notebook by the index.
     *
     * @param index of the Note.
     */
    public PinCommand(int index) {
        this.index = index;
        this.title = null;
        this.isPinByIndex = true;
    }

    /**
     * Constructs a PinCommand to pin or unpin a Note in the Notebook by the title.
     *
     * @param title of the Note.
     */
    public PinCommand(String title) {
        this.title = title;
        this.isPinByIndex = false;
    }

    @Override
    public String execute() {
        Note note = null;
        if (isPinByIndex) {
            try {
                note = notebook.getNotes().get(index);
            } catch (IndexOutOfBoundsException exception) {
                return Formatter.formatNote(COMMAND_UNSUCCESSFUL_MESSAGE);
            }
        } else {
            for (Note notes : notebook.getNotes()) {
                if (notes.getTitle().equalsIgnoreCase(title)) {
                    note = notes;
                }
            }
        }

        if (note == null) {
            return Formatter.formatNote(COMMAND_UNSUCCESSFUL_MESSAGE);
        }

        note.togglePinned();
        return Formatter.formatNote(note.getTitle() + " pinned: " + note.getPinned());
    }
}
