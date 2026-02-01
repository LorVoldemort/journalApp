package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import net.engineeringdigest.journalApp.services.JournalEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/journal")
public class JournalEntryController {

    @Autowired
    JournalEntryService jes;
    @GetMapping("/get-journal")
    public List<JournalEntry> getAllJournal(Model model){
//        List<JournalEntry> li = jes.getallJournal();
//        model.addAttribute("length",li.size());
//        model.addAttribute("Journals",li);
        return jes.getallJournal();
    }

    @GetMapping("/add-journal-form")
    public String Printhello(){
        return "form";
    }

    @PostMapping("/add-journal/{ownerid}")
    public boolean createJournal(@PathVariable int ownerid,@RequestBody JournalEntry je){
        return jes.saveJournal(ownerid,je);
    }


    @GetMapping("/{id}")
    public JournalEntry getJournalById(@PathVariable int id){
        return jes.FindById(id);
    }

    @DeleteMapping("/{id}")
    public boolean deleteJournalEntryById(@PathVariable int id){
        return jes.deleteJournalById(id);
    }

    @PutMapping("/update-journal")
    public boolean updateJournalById(@RequestBody JournalEntry je){
        return jes.updateJournal(je);
    }
}
