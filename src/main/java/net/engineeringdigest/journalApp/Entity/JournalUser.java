package net.engineeringdigest.journalApp.Entity;
import java.util.*;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

@Entity
@Table(name = "journal_user")
public class JournalUser {
        @Id
        private int userid;
        private String name;
        private String dept;

        @OneToOne(mappedBy = "ownerid",cascade = CascadeType.ALL)
        @JsonIgnore
        private JournalEntry journalentry;
//        private List<JournalEntry> Journals = new ArrayList<>();

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDept() {
        return dept;
    }

    public void setDept(String dept) {
        this.dept = dept;
    }

    public JournalEntry getJournalentry() {
        return journalentry;
    }

    public void setJournalentry(JournalEntry journalentry) {
        this.journalentry = journalentry;
    }


//    public List<JournalEntry> getUserJournalEntries() {
//        return Journals;
//    }
//
//    public void setUserJournalEntries(List<JournalEntry> Journals) {
//        this.Journals = Journals;
//    }
}
