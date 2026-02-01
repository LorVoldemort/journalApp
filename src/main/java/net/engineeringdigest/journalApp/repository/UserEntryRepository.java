package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.Entity.JournalUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserEntryRepository extends JpaRepository<JournalUser,String> {
}
