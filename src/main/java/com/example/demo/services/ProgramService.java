package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Program;

public interface ProgramService {

    Program createProgram(Program program);

    List<Program> getAllPrograms();

    Program updateProgram(Long id, Program program);

    void deleteProgram(Long id);
}
