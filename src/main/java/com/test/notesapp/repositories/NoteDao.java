package com.test.notesapp.repositories;


import com.test.notesapp.repositories.entities.NoteEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface NoteDao extends JpaRepository<NoteEntity, Long> {

}
