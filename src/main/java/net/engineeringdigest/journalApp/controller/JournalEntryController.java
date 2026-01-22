package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import net.engineeringdigest.journalApp.services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    JournalEntryService jes;

    @GetMapping("/getJournal")
    public List<JournalEntry> getAllJournal(){
        return jes.getallJournal();
    }

    @PostMapping("/add-journal")
    public boolean createJournal(@RequestBody JournalEntry je){
        jes.saveJournal(je);
        return true;
    }

    @GetMapping("/{id}")
    public void getJournalById(@PathVariable long id){

    }

    @DeleteMapping("/{id}")
    public void deleteJournalEntryById(@PathVariable long id){

    }

    @PutMapping("/{id}")
    public void updateJournalById(@RequestBody JournalEntry je){

    }
}
