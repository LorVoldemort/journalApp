package net.engineeringdigest.journalApp.Entity;

import jakarta.persistence.*;

@Entity
@Table(name = "journal_entry")
public class JournalEntry {
    @Id
    private int journalid;
    private String title;
    private String content;

    @OneToOne
    @JoinColumn(name = "userId",nullable = false)
    private JournalUser ownerid;

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getJournalid() {
        return journalid;
    }

    public void setJournalid(int journalid) {
        this.journalid = journalid;
    }

    public JournalUser getOwnerid() {
        return ownerid;
    }

    public void setOwnerid(JournalUser ownerid) {
        this.ownerid = ownerid;
    }
}
