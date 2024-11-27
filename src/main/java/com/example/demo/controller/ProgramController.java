package com.example.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Program;
import com.example.demo.services.ProgramService;

@RestController
@RequestMapping("/api")
public class ProgramController {

    @Autowired
    private ProgramService programService;

    @PostMapping("/program")
    public Program createProgram(@RequestBody Program program) {
        return programService.createProgram(program);
    }

    @GetMapping("/programs")
    public List<Program> getAllPrograms() {
        return programService.getAllPrograms();
    }

    @PutMapping("/program/{id}")
    public Program updateProgram(@PathVariable Long id, @RequestBody Program program) {
        return programService.updateProgram(id, program);
    }

    @DeleteMapping("/program/{id}")
    public void deleteProgram(@PathVariable Long id) {
        programService.deleteProgram(id);
    }
}
