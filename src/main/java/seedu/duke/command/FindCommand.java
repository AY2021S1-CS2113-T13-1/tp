package seedu.duke.command;

import seedu.duke.data.notebook.Note;
import seedu.duke.ui.InterfaceManager;

import java.util.ArrayList;
import java.util.stream.Collectors;

import static seedu.duke.util.PrefixSyntax.SUFFIX_INDEX;

/**
 * Finds Notes in the Notebook.(Possible to add find in event too)
 */
public class FindCommand extends Command {

    public static final String COMMAND_WORD = "find-n";

    public static final String COMMAND_USAGE = COMMAND_WORD + ": Finds a note. Parameters: KEYWORDS";

    private static final String COMMAND_UNSUCCESSFUL_MESSAGE = "There are no matching notes. "
            + "Please try another search query.";
    private static final String COMMAND_SUCCESSFUL_MESSAGE = "Here are the matching notes in your list:";

    private String keywords;

    /**
     * Constructs a FindCommand to find Notes in the Notebook given the keyword.
     *
     * @param keywords to look for in the Notebook.
     */
    public FindCommand(String keywords) {
        this.keywords = keywords;
    }

    /**
     * Filters and finds notes that has the title containing the user inputted keyword.
     * Stores the filtered notes in an ArrayList of Note
     *
     * @return String containing the filtered list of notes
     */
    @Override
    public String execute() {
        StringBuilder notes = new StringBuilder();

        ArrayList<Note> filteredNotes = (ArrayList<Note>) notebook.getNotes().stream()
                .filter((s) -> s.getTitle().contains(keywords))
                .collect(Collectors.toList());

        for (int i = 0; i < filteredNotes.size(); i++) {
            notes.append(i + 1)
                    .append(SUFFIX_INDEX)
                    .append(filteredNotes.get(i).getTitle())
                    .append(filteredNotes.get(i).getTagsName())
                    .append(InterfaceManager.LS);
        }

        if (filteredNotes.isEmpty()) {
            return COMMAND_UNSUCCESSFUL_MESSAGE;
        }
        return COMMAND_SUCCESSFUL_MESSAGE + InterfaceManager.LS + notes;
    }
}
