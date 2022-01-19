package com.ruben.thymeleaf.service;

import com.ruben.thymeleaf.repository.NoteRepository;

import java.util.List;
import java.util.Optional;

import com.ruben.thymeleaf.model.Note;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class NoteService {

    @Autowired
    private NoteRepository noteRepository;

    public List<Note> list(){
        List<Note> notes = (List<Note>) noteRepository.findAll();
        return notes;
    }

    public Optional<Note> getNoteById(Long id){
        return noteRepository.findById(id);
    }

    public Note saveNote(Note note ){
        return noteRepository.save(note);
    }
    
    public void deleteNoteById(Long id){
        noteRepository.deleteById(id);
        return ;
    }

}
