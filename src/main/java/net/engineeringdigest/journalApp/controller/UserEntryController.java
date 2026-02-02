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

    @PostMapping("/add-user")
    public boolean addUserEntry(@RequestBody JournalUser user){
        return ues.addUser(user);
    }


    @PutMapping("/update-user")
    public boolean updateUser(@RequestBody JournalUser user){
        return ues.updateuser(user);
    }

    @DeleteMapping("/{id}")
    public boolean deleteUserEntry(@PathVariable int id){
        ues.deleteUserEntry(id);
        return true;
    }
}
