package note;

import java.time.LocalDate;

public class Note {

    private String title;
    private String bodyText;
    private LocalDate created;
    private LocalDate updated;

    public Note(String title, String bodyText, LocalDate created, LocalDate updated) {
        this.title = title;
        this.bodyText = bodyText;
        this.created = created;
        this.updated = updated;
    }

    public String getTitle() {
        return title;
    }

    public String getBodyText() {
        return bodyText;
    }

    public LocalDate getCreated() {
        return created;
    }

    public LocalDate getUpdated() {
        return updated;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setBodyText(String bodyText) {
        this.bodyText = bodyText;
    }

    public void setCreated(LocalDate created) {
        this.created = created;
    }

    public void setUpdated(LocalDate updated) {
        this.updated = updated;
    }

    @Override
    public String toString() {
        return "Note{" +
                "title='" + title + '\'' +
                ", bodyText='" + bodyText + '\'' +
                ", created=" + created +
                ", updated=" + updated +
                '}';
    }
}
