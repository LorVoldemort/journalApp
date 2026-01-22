package net.engineeringdigest.journalApp.repository;

import net.engineeringdigest.journalApp.Entity.JournalEntry;
import org.springframework.data.jpa.repository.JpaRepository;

public interface JournalEntryRepository extends JpaRepository<JournalEntry,String> {
}
