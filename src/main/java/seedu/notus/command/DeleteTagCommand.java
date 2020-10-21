package seedu.notus.command;

import seedu.notus.data.notebook.Tag;
import seedu.notus.ui.Formatter;

import java.util.ArrayList;

import static seedu.notus.util.PrefixSyntax.PREFIX_DELIMITER;
import static seedu.notus.util.PrefixSyntax.PREFIX_TAG;

/**
 * Deletes an existing Tag.
 */
public class DeleteTagCommand extends Command {

    public static final String COMMAND_WORD = "delete-t";

    public static final String COMMAND_USAGE = COMMAND_WORD + ": Deletes a tag. Parameters: "
            + PREFIX_DELIMITER + PREFIX_TAG + " TAG "
            + "[" + PREFIX_DELIMITER + PREFIX_TAG + " TAG1...]";

    public static final String COMMAND_SUCCESSFUL_MESSAGE = "Deleted the tag! ";
    public static final String COMMAND_UNSUCCESSFUL_MESSAGE = "The tag does not exist! ";
    public static final String HEADER_DELETE_TAG = "Deleting tags...";

    private ArrayList<Tag> tags;

    /**
     * Constructs a DeleteNoteCommand to delete tag(s).
     */
    public DeleteTagCommand(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    @Override
    public String execute() {
        ArrayList<String> executedMessage = tagManager.deleteTag(tags, COMMAND_SUCCESSFUL_MESSAGE,
                COMMAND_UNSUCCESSFUL_MESSAGE);
        executedMessage.add(0, HEADER_DELETE_TAG);
        return Formatter.formatString(executedMessage, true);
    }
}
