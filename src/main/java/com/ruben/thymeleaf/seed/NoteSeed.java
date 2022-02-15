package com.ruben.thymeleaf.seed;

import com.ruben.thymeleaf.model.Note;
import com.ruben.thymeleaf.service.NoteService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class NoteSeed implements CommandLineRunner {
    
    @Autowired 
    private NoteService nService;

    @Override
    public void run(String... args) throws Exception {
        Note noteSeed = new Note("Demo", "Demo note");
        nService.saveNote(noteSeed);
        Note noteSeed2 = new Note("Demo2", "Demo note 2");
        nService.saveNote(noteSeed2);
    }

        

}
