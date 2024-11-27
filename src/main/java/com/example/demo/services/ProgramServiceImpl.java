package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.Program;
import com.example.demo.repository.ProgramRepository;

@Service
public class ProgramServiceImpl implements ProgramService {

    @Autowired
    private ProgramRepository programRepository;

    @Override
    public Program createProgram(Program program) {
        return programRepository.save(program);
    }

    @Override
    public List<Program> getAllPrograms() {
        return programRepository.findAll();
    }

    @Override
    public Program updateProgram(Long id, Program program) {
        Program existingProgram = programRepository.findById(id).orElseThrow(() -> new RuntimeException("Program not found"));
        existingProgram.setName(program.getName());
        existingProgram.setDuration(program.getDuration());
        existingProgram.setVersion(program.getVersion());
        existingProgram.setMajorId(program.getMajorId());
        existingProgram.setProgramTypeId(program.getProgramTypeId());
        existingProgram.setValidFrom(program.getValidFrom());
        return programRepository.save(existingProgram);
    }

    @Override
    public void deleteProgram(Long id) {
        programRepository.deleteById(id);
    }
}
