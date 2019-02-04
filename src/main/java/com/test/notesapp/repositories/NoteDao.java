package com.test.notesapp.repositories;


import com.test.notesapp.repositories.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao extends JpaRepository<NoteEntity, Long> {

    @Query("SELECT ne FROM NoteEntity ne WHERE ne.title = ?1")
    NoteEntity findByTitle(String title);
}
