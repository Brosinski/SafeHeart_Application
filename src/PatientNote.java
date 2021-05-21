import java.util.Date;

public class PatientNote {
    private String noteContent;
    private Date noteDate;

    public PatientNote(String noteContent,Date noteDate) {
        this.noteContent = noteContent;
        this.noteDate =noteDate;
    }

    public String getNoteContent() {
        return noteContent;
    }

    public void setNoteContent(String noteContent) {
        this.noteContent = noteContent;
    }


    public Date getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Date noteDate) {
        this.noteDate = noteDate;
    }


}
