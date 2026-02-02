package net.engineeringdigest.journalApp.services;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import net.engineeringdigest.journalApp.Entity.JournalUser;
import net.engineeringdigest.journalApp.repository.JournalEntryRepository;
import net.engineeringdigest.journalApp.repository.UserEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;


import java.util.List;

@Component
public class UserEntryService {

    @Autowired
    UserEntryRepository uer;
    @Autowired
    JournalEntryRepository jer;


    public List<JournalUser> getAllUsers(){
        return uer.findAll();
    }

    public JournalUser getUserEntryById(int id){
        JournalUser usr = uer.findById(id).orElse(null);
        if(usr != null){
            return usr;
        }
        return null;
    }

    public boolean addUser(@RequestBody JournalUser usr){
        if(usr != null){
            uer.save(usr);
            return true;
        }
        else return false;
    }

    public boolean updateuser(@RequestBody JournalUser newuser){

        JournalUser olduser = uer.findById(newuser.getUserid()).orElse(null);
        if(olduser != null){
            olduser.setName(newuser.getName());
            olduser.setDept(newuser.getDept());
            uer.save(olduser);
            return true;
        }
        else return false;
    }

    public void deleteUserEntry(int id){
        uer.deleteById(id);
    }
}
