package seedu.duke.data.notebook;

import java.util.ArrayList;
import java.util.Formatter;

import static seedu.duke.util.PrefixSyntax.PREFIX_DELIMITER;
import static seedu.duke.util.PrefixSyntax.PREFIX_TITLE;
import static seedu.duke.util.PrefixSyntax.PREFIX_TAG;
import static seedu.duke.util.PrefixSyntax.PREFIX_PIN;
import static seedu.duke.ui.Formatter.LS;
/**
 * Represents a Note. Contains all the information of a note.
 */
public class Note {

    private String title;
    private ArrayList<String> content;
    private Boolean isPinned;
    private boolean isArchived;
    private ArrayList<Tag> tags;

    /**
     * Constructs a Note object with its title, content and pinned status provided.
     *
     * @param title of the note.
     * @param content of the note.
     * @param isPinned status of the note.
     */
    public Note(String title, ArrayList<String> content, Boolean isPinned, boolean isArchived) {
        this.title = title;
        this.content = content;
        this.isPinned = isPinned;
        this.isArchived = isArchived;
        tags = new ArrayList<>();
    }

    /**
     * Constructs a Note object with its title, content, pinned status and tags provided.
     *
     * @param title of the note.
     * @param content of the note.
     * @param isPinned status of the note.
     * @param tags of the note.
     */
    public Note(String title, ArrayList<String> content, Boolean isPinned, boolean isArchived, ArrayList<Tag> tags) {
        this(title, content, isPinned, isArchived);
        this.tags = tags;
    }

    /**
     * Gets the title of note from existing data.
     *
     * @return title of the note.
     */
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public ArrayList<String> getContent() {
        return content;
    }

    public void setContent(ArrayList<String> content) {
        this.content = content;
    }

    /**
     * Gets the pinned status of a note.
     *
     * @return true if note is pinned, false otherwise.
     */
    public boolean getPinned() {
        return (isPinned);
    }

    public String getPinnedString() {
        return (isPinned ? "Y" : "N");
    }

    public void togglePinned() {
        isPinned = !isPinned;
    }

    public void setPinned(Boolean pinned) {
        isPinned = pinned;
    }

    public void toggleArchived() {
        isArchived = !isArchived;
    }

    public void setArchived(boolean archived) {
        isArchived = archived;
    }

    public ArrayList<Tag> getTags() {
        return this.tags;
    }

    public String getTagsName() {
        String tagsName = "";

        for (Tag t : tags) {
            tagsName = tagsName.concat(t.toString());
        }
        return tagsName;
    }

    public void setTags(ArrayList<Tag> tags) {
        this.tags = tags;
    }

    public String toSaveString() {
        String noteDetails = "";
        String tagDetails = "";

        for (Tag tag: this.tags) {
            tagDetails += PREFIX_DELIMITER + PREFIX_TAG + " " + tag.toSaveString() + " ";
        }
        noteDetails += PREFIX_DELIMITER + PREFIX_TITLE + " " + this.title + " "
                    + PREFIX_DELIMITER + PREFIX_PIN + " " + this.isPinned + " "
                    //+ PREFIX_DELIMITER + PREFIX_ARCHIVE + " " + this.isArchived + " "
                    + tagDetails
                    + LS;

        return noteDetails;
    }
}
