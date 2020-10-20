package seedu.duke.command;

import seedu.duke.data.notebook.Notebook;
import seedu.duke.data.notebook.TagManager;
import seedu.duke.data.timetable.Timetable;
import seedu.duke.storage.StorageManager;

/**
 * Represents an executable command.
 */
public abstract class Command {

    protected Notebook notebook;
    protected Notebook archivedNotebook;
    protected Timetable timetable;
    protected TagManager tagManager;
    protected StorageManager storageManager;

    protected Command() {
    }

    /**
     * Executes the command and returns the result. Method to be implemented by child class.
     *
     * @return result of the command execution.
     */
    public abstract String execute();

    /**
     * Sets the data that the command will operate on.
     *
     * @param notebook referenced Notebook data.
     * @param archivedNotebook referenced archived Notebook data.
     * @param timetable referenced Timetable data.
     * @param tagManager referenced TagManager.
     */
    public void setData(Notebook notebook, Notebook archivedNotebook, Timetable timetable, TagManager tagManager, StorageManager storageManager) {
        this.notebook = notebook;
        this.archivedNotebook = archivedNotebook;
        this.timetable = timetable;
        this.tagManager = tagManager;
        this.storageManager = storageManager;
    }
}
