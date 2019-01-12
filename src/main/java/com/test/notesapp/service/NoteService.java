package com.test.notesapp.service;

import com.test.notesapp.models.Note;
import com.test.notesapp.repositories.NoteDao;
import com.test.notesapp.repositories.entities.NoteEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Date;
import java.time.Instant;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class NoteService {

    private final NoteDao noteDao;

    @Autowired
    public NoteService(NoteDao noteDao) {
        this.noteDao = noteDao;
    }

    private static Note apply(NoteEntity noteEntity) {
        return Note.builder()
                .content(noteEntity.getContent())
                .id(noteEntity.getId())
                .title(noteEntity.getTitle())
                .time(noteEntity.getTime().getTime())
                .build();
    }

    public List<Note> getAllNotes() {
        List<NoteEntity> noteEntities = noteDao.findAll();
        return convertEntitiesToNotes(noteEntities);
    }

    private List<Note> convertEntitiesToNotes(List<NoteEntity> noteEntities) {
        return noteEntities.stream().map(NoteService::apply).collect(Collectors.toList());
    }

    public boolean addNote(Note note) {
        NoteEntity noteEntity = NoteEntity.builder()
                .title(note.getTitle())
                .content(note.getContent())
                .time(Date.from(Instant.now()))
                .build();

        noteDao.save(noteEntity);
        return true;
    }

    public void deleteNote(Long id) {
        noteDao.deleteById(id);
    }

    public boolean updateNote(Note note) {
        long id = note.getId();

        NoteEntity noteEntity = NoteEntity.builder()
                .id(id)
                .title(note.getTitle())
                .content(note.getContent())
                .time(Date.from(Instant.now()))
                .build();

        noteDao.save(noteEntity);

        return true;
    }
}
