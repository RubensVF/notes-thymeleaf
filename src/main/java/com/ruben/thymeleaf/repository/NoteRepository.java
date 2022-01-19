package com.ruben.thymeleaf.repository;

import com.ruben.thymeleaf.model.Note;

import org.springframework.data.repository.CrudRepository;

public interface NoteRepository  extends CrudRepository<Note,Long>{
        
}
