package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntryService {

    @Autowired
    JournalEntryRepository jer;

    public List<JournalEntry> getallJournal(){
        return jer.findAll();
    }

    public void saveJournal(JournalEntry je){
        jer.save(je);
    }
}
