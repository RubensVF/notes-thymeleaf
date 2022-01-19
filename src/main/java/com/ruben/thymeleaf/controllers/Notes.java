package com.ruben.thymeleaf.controllers;

import java.util.Optional;

import com.ruben.thymeleaf.model.Note;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.ui.Model;
import com.ruben.thymeleaf.service.*;
@Controller
public class Notes {
    

    @Autowired
    private NoteService noteservice;

    @GetMapping({"/","/home"})
    public String index(Model model){

        model.addAttribute("notes", noteservice.list());
        return "index";
    }

    @GetMapping("/noteform")
    public String newNote(Model model){

        Note note = new Note();
        model.addAttribute("note",note);
        return "newnote";
    }   

    @PostMapping("/newnote")
    public String addNote(@ModelAttribute("note") Note note){
        noteservice.saveNote(note);
        return "redirect:/home";    
    }

    @GetMapping("/edit")
    public String edit(@RequestParam(name = "id") Long id, Model model){
        Optional<Note> note = noteservice.getNoteById(id);
        if(note.isPresent()){
            model.addAttribute("note", note.get());       
            return "editnote";
        }
        return "redirect:/home"; 
    }

    @PostMapping("/editnote")
    public String editNote(Note note){
        noteservice.saveNote(note);
        return "redirect:/home";
    }

    @GetMapping("/delete")
    public String deleteNote(@RequestParam(name = "id") Long id){
        noteservice.deleteNoteById(id);
        return "redirect:/";
    }
}
