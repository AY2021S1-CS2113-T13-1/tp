package seedu.duke.command;

/**
 * Lists all the Tags.
 */
public class ListTagCommand extends Command {

    public static final String COMMAND_WORD = "list-t";

    @Override
    public String execute() {
        return tagManager.listTags();
    }
}
