package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import net.engineeringdigest.journalApp.Entity.JournalUser;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.repository.UserEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class JournalEntryService {

    @Autowired
    JournalEntryRepository jer;
    @Autowired
    UserEntryRepository usr;

    public List<JournalEntry> getallJournal(){
        return jer.findAll();
    }


        public boolean saveJournal(JournalEntry je){
            if(je != null){
                jer.save(je);
                return true;
            }
            return false;
        }

    public boolean deleteJournalById(int id){
        String ids = Integer.toString(id);
        if(jer.findById(ids).orElse(null) != null){
            jer.deleteById(ids);
            return true;
        }
        else return false;
    }

    public boolean updateJournal(JournalEntry je){
        String ids = Integer.toString(je.getJournalid());
        JournalEntry oldje = jer.findById(ids).orElse(null);
        if(oldje != null){
            oldje.setTitle(je.getTitle());
            oldje.setContent(je.getContent());
            jer.save(oldje);
            return true;
        }
        else return false;
    }

    public JournalEntry FindById(int id){
        String ids = Integer.toString(id);
        return jer.findById(ids).orElse(null);
    }
}
