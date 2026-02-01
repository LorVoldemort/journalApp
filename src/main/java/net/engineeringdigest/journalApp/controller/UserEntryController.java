package net.engineeringdigest.journalApp.controller;

import net.engineeringdigest.journalApp.Entity.JournalUser;
import net.engineeringdigest.journalApp.services.UserEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserEntryController {

    @Autowired
    UserEntryService ues;
    @GetMapping("/getalluser")
    public List<JournalUser> getAllUser(){
        return ues.getAllUsers();
    }

    @GetMapping("/get-user-by-id/{id}")
    public JournalUser getUserById(@PathVariable int id){
        return ues.getUserEntryById(id);
    }

    @PostMapping
    public boolean addUserEntry(@RequestBody JournalUser user){
        ues.addUser(user);
        return true;
    }


    @PutMapping
    public boolean updateUser(@RequestBody JournalUser user){
        return ues.updateuser(user);
    }

    @DeleteMapping
    public boolean deleteUserEntry(@PathVariable int id){
        ues.deleteUserEntry(id);
        return true;
    }
}
