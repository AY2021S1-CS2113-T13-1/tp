package seedu.duke.data.notebook;

import java.util.ArrayList;

/**
 * Represents a Note. Contains all the information of a note.
 */
public class Note {

    private String title;
    private ArrayList<String> content;
    private Boolean isPinned;
    private ArrayList<Tag> tags;

    /**
     * Constructs a Note object with its title, content and pinned status provided.
     *
     * @param title of the note.
     * @param content of the note.
     * @param isPinned status of the note.
     */
    public Note(String title, ArrayList<String> content, Boolean isPinned) {
        this.title = title;
        this.content = content;
        this.isPinned = isPinned;
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
    public Note(String title, ArrayList<String> content, Boolean isPinned, ArrayList<Tag> tags) {
        this(title, content, isPinned);
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

    public String getPinned() {
        return (isPinned ? "Y" : "N");
    }

    public void togglePinned() {
        isPinned = !isPinned;
    }

    public void setPinned(Boolean pinned) {
        isPinned = pinned;
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
}
