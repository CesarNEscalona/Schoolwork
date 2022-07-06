package note;

import java.time.LocalDate;

public class NoteBuilder {
    private String title;
    private String bodyText;
    private LocalDate created;
    private LocalDate updated;

    public NoteBuilder() {
        //do nothing...
    }

    public NoteBuilder setTitle(String title) {
        this.title = title;
        return this;
    }

    public NoteBuilder setBodyText(String bodyText) {
        this.bodyText = bodyText;
        return this;
    }

    public NoteBuilder setCreated(LocalDate created) {
        this.created = created;
        return this;
    }

    public NoteBuilder setUpdated(LocalDate updated) {
        this.updated = updated;
        return this;
    }

    public Note createNote() {
        return new Note(title, bodyText, created, updated);
    }

}