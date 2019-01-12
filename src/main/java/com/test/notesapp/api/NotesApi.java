package com.test.notesapp.api;

import com.test.notesapp.models.Note;
import com.test.notesapp.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/notes")
public class NotesApi {

    private final NoteService noteService;

    @Autowired
    public NotesApi(NoteService noteService) {
        this.noteService = noteService;
    }

    @GetMapping("/")
    public List<Note> getAllNotes() {
        return noteService.getAllNotes();
    }

    @PostMapping("/add")
    public String addNote(@RequestBody Note note) {
        System.out.println(note);
        boolean added = noteService.addNote(note);
        return added? "added" : "some error occurred";
    }

    @PostMapping("/update")
    public String updateNote(@RequestBody Note note) {
        boolean updated = noteService.updateNote(note);
        return updated? "updated" : "some error occurred";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteNote(@PathVariable Long id) {
        noteService.deleteNote(id);
        return "note deleted successfully";
    }
}
