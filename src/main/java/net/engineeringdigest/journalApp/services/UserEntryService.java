package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import net.engineeringdigest.journalApp.Entity.JournalUser;
import net.engineeringdigest.journalApp.repository.UserEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Component
public class UserEntryService {

    @Autowired
    UserEntryRepository uer;


    public List<JournalUser> getAllUsers(){
        return uer.findAll();
    }

    public JournalUser getUserEntryById(int id){
        JournalUser usr = uer.findById(Integer.toString(id)).orElse(null);
        if(usr != null){
            return usr;
        }
        return null;
    }

    public void addUser(@RequestBody JournalUser usr){
        JournalEntry journal = usr.getJournalentry();
        journal.setOwnerid(usr);
        uer.save(usr);
    }

    public boolean updateuser(@RequestBody JournalUser newuser){
        String ids = Integer.toString(newuser.getUserid());
        JournalUser olduser = uer.findById(ids).orElse(null);
        if(olduser != null){
            olduser.setName(newuser.getName());
            olduser.setDept(newuser.getDept());
            uer.save(olduser);
            return true;
        }
        else return false;
    }

    public void deleteUserEntry(int id){
        uer.deleteById(Integer.toString(id));
    }
}
