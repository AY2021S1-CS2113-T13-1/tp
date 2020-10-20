package seedu.duke.command;

import seedu.duke.data.notebook.Note;
import seedu.duke.data.notebook.Tag;
import seedu.duke.ui.Formatter;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import java.util.Objects;
import java.util.stream.Collectors;

import static seedu.duke.util.PrefixSyntax.PREFIX_DELIMITER;
import static seedu.duke.util.PrefixSyntax.PREFIX_TAG;
import static seedu.duke.util.PrefixSyntax.SUFFIX_INDEX;

/**
 * Lists all the Notes in the Notebook.
 */
public class ListNoteCommand extends Command {

    public static final String COMMAND_WORD = "list-n";

    public static final String COMMAND_USAGE = COMMAND_WORD + ": Lists all the notes in the Notebook. Parameters: "
            + "[" + PREFIX_DELIMITER + PREFIX_TAG + " TAG "
            + PREFIX_DELIMITER + PREFIX_TAG + " TAG1...] "
            + "[/sort up OR down]";

    public static final String COMMAND_SUCCESSFUL_MESSAGE = "Here are the list of notes: " + Formatter.LS;
    public static final String COMMAND_UNSUCCESSFUL_MESSAGE_INVALID_TAG = "Your tags return no result."
            + " Please try an alternative tag or check your spellings";
    public static final String COMMAND_UNSUCCESSFUL_MESSAGE_EMPTY_NOTEBOOK = "The notebook is empty!";

    private ArrayList<String> tags;
    private boolean isSorted;
    private boolean isArchived;
    private Boolean isAscendingOrder;

    /**
     * Constructs a ListCommand to list all the Notes in the Notebook in a sorted order.
     *
     * @param isAscendingOrder determines the order of the sorting of the Notes.
     */
    public ListNoteCommand(Boolean isAscendingOrder) {
        this.tags = null;
        this.isSorted = true;
        this.isArchived = false;
        this.isAscendingOrder = isAscendingOrder;
    }

    /**
     * Constructs a ListNoteCommand to list all the Notes in the Notebook in the default order.
     */
    public ListNoteCommand() {
        this.tags = null;
        this.isSorted = false;
        this.isArchived = false;
        this.isAscendingOrder = null;
    }

    /**
     * Constructs a ListNoteCommand to list all the Notes in the Archived Notebook.
     */
    public ListNoteCommand(boolean isArchived) {
        this.tags = null;
        this.isSorted = false;
        this.isArchived = true;
        this.isAscendingOrder = null;
    }

    /**
     * Constructs a ListNoteCommand to list all the Notes in the Notebook that has the tag(s).
     *
     * @param tags tags of the Notes.
     */
    public ListNoteCommand(ArrayList<String> tags) {
        this.isSorted = false;
        this.isArchived = false;
        this.isAscendingOrder = null;
        this.tags = tags;
    }

    /**
     * Constructs a ListNoteCommand to list all the Notes in the Notebook, that has the tag(s), in a sorted order.
     *
     * @param isAscendingOrder order of the sort.
     * @param tags tags of the Notes.
     */
    public ListNoteCommand(Boolean isAscendingOrder, ArrayList<String> tags) {
        this.isAscendingOrder = isAscendingOrder;
        this.isSorted = true;
        this.isArchived = false;
        this.tags = tags;
    }

    /**
     * Sorts the notes in alphabetical order and returns them if there is a up (A-Z) / down (Z-A) command.
     * If tags exist, maps the tags to the HashMap and gets the corresponding notes
     * For each tag, there will be an ArrayList of the respective notes.
     * The method will then merge the notes in the ArrayLists into 1 large ArrayList.
     * ArrayList is then sorted and returned for the respective up/down commands
     *
     * @return noteString String containing the (filtered) notes (un)sorted
     */
    @Override
    public String execute() {
        StringBuilder noteString = new StringBuilder();
        StringBuilder pinnedNotesSorted;
        StringBuilder unpinnedNotesSorted;
        ArrayList<Note> notes = new ArrayList<>();
        ArrayList<Note> pinnedNotes = new ArrayList<>();
        ArrayList<Note> archivedNotes;
        ArrayList<Note> unpinnedNotes = new ArrayList<>();

        if (isArchived) {
            archivedNotes = new ArrayList<>(archivedNotebook.getNotes());
            noteString = getNoteString(archivedNotes);

            return noteString.toString();
        }

        for (int i = 0; i < notebook.getNotes().size(); i++) {
            String pinnedNoteStatus = notebook.getNotes().get(i).getPinned();
            if (pinnedNoteStatus.equals("Y")) {
                pinnedNotes.add(notebook.getNotes().get(i));
            } else {
                unpinnedNotes.add(notebook.getNotes().get(i));
            }
        }

        // Takes the notes in the notebook and sorts them according to title, alphabetically (a-z)
        ArrayList<Note> sortedNotes = (ArrayList<Note>) notebook.getNotes().stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(a -> a.getTitle().toLowerCase()))
                .collect(Collectors.toList());

        if (tags == null) {
            if (isAscendingOrder == null && pinnedNotes.isEmpty()) {
                noteString = getNoteString(notebook.getNotes());
            } else if (isAscendingOrder == null) {
                noteString.append("Pinned Notes")
                        .append(Formatter.LS)
                        .append(getNoteString(pinnedNotes))
                        .append(Formatter.LS)
                        .append("Unpinned Notes")
                        .append(Formatter.LS)
                        .append(getNoteString(unpinnedNotes));
            } else if (pinnedNotes.isEmpty()) {
                noteString = getSortedString(sortedNotes);
            } else {
                pinnedNotesSorted = getSortedString(pinnedNotes);
                unpinnedNotesSorted = getSortedString(unpinnedNotes);
                noteString.append("Pinned Notes")
                        .append(Formatter.LS)
                        .append(pinnedNotesSorted)
                        .append(Formatter.LS)
                        .append("Unpinned Notes")
                        .append(Formatter.LS)
                        .append(unpinnedNotesSorted);
            }

            if (noteString.toString().isBlank()) {
                return Formatter.LS + COMMAND_UNSUCCESSFUL_MESSAGE_EMPTY_NOTEBOOK;
            }
            return Formatter.LS + COMMAND_SUCCESSFUL_MESSAGE + noteString.toString();
        }

        // Obtaining ArrayList<String> of tags and parsing it to get an ArrayList<Tag> of tags
        Map<Tag, ArrayList<Note>> tagMap = tagManager.getTagMap();
        ArrayList<Tag> tagList = new ArrayList<>();

        for (String tag : tags) {
            Tag currentTag = tagManager.getTag(tag);

            if (currentTag != null) {
                tagList.add(currentTag);
            }
        }

        // If the user inputted tags does not match any of the existing tags.
        if (tagList.isEmpty()) {
            return Formatter.LS + COMMAND_UNSUCCESSFUL_MESSAGE_INVALID_TAG;
        }

        // Based on user inputted tags, will store the respective values in an ArrayList
        // E.g. if user input 2 tags, CS2113 and important, will have 2 ArrayList
        //      1 for the values corresponding to CS2113 and the other for important tag
        List<ArrayList<Note>> values = tagList.stream()
                .map(tagMap::get)
                .collect(Collectors.toList());

        for (ArrayList<Note> value : values) {
            for (Note note : value) {
                // Account for duplicates.
                // In case an item has both CS2113 and Important tag
                if (!notes.contains(note)) {
                    notes.add(note);
                }
            }
        }

        // Checking for empty notes List
        if (notes.isEmpty()) {
            return Formatter.LS + COMMAND_UNSUCCESSFUL_MESSAGE_INVALID_TAG;
        }

        // Sort the tagged notes
        ArrayList<Note> sortedTaggedNotes = (ArrayList<Note>) notes.stream()
                .filter(Objects::nonNull)
                .sorted(Comparator.comparing(a -> a.getTitle().toLowerCase()))
                .collect(Collectors.toList());

        if (isAscendingOrder == null) {
            noteString = getNoteString(notes);
        } else {
            noteString = getSortedString(sortedTaggedNotes);
        }
        return Formatter.LS + COMMAND_SUCCESSFUL_MESSAGE + noteString.toString();
    }

    /**
     * Method compiles the ArrayList items and appends the items to a String.
     * The ArrayList has already been sorted
     * Method returns either top to bottom or bottom to top to account for ascending/descending sorting
     *
     * @param sortedNotes ArrayList of notes that were already sorted
     * @return noteString String containing the notes sorted either ascending ot descending
     */
    public StringBuilder getSortedString(ArrayList<Note> sortedNotes) {
        StringBuilder noteStrBuilder = new StringBuilder();

        if (!isAscendingOrder) {
            Collections.reverse(sortedNotes);
            noteStrBuilder = getNoteString(sortedNotes);
        } else if (isAscendingOrder) {
            noteStrBuilder = getNoteString(sortedNotes);
        }
        return noteStrBuilder;
    }

    /**
     * Method compiles the ArrayList items and appends the items to a String.
     *
     * @param notesList ArrayList of notes to obtain note title/tags from
     * @return noteString StringBuilder containing the notes ready to be printed
     */
    public StringBuilder getNoteString(ArrayList<Note> notesList) {
        StringBuilder noteString = new StringBuilder();

        for (int i = 0; i < notesList.size(); i++) {
            noteString.append(i + 1).append(SUFFIX_INDEX)
                    .append(notesList.get(i).getTitle())
                    .append(" ")
                    .append(notesList.get(i).getTagsName())
                    .append(Formatter.LS);
        }

        return noteString;
    }
}