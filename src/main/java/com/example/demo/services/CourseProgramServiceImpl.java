package com.example.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.demo.entity.CourseProgram;
import com.example.demo.entity.CourseProgramId;
import com.example.demo.repository.CourseProgramRepository;

@Service
public class CourseProgramServiceImpl implements CourseProgramService {

    @Autowired
    private CourseProgramRepository courseProgramRepository;

    @Override
    public CourseProgram createCourseProgram(CourseProgram courseProgram) {
        return courseProgramRepository.save(courseProgram);
    }

    @Override
    public List<CourseProgram> getAllCoursePrograms() {
        return courseProgramRepository.findAll();
    }

    @Override
    public CourseProgram updateCourseProgram(CourseProgramId id, CourseProgram courseProgram) {
        CourseProgram existingCourseProgram = courseProgramRepository.findById(id).orElseThrow(() -> new RuntimeException("CourseProgram not found"));
        existingCourseProgram.setCourseCode(courseProgram.getCourseCode());
        existingCourseProgram.setCourseTypeId(courseProgram.getCourseTypeId());
        return courseProgramRepository.save(existingCourseProgram);
    }

    @Override
    public void deleteCourseProgram(CourseProgramId id) {
        courseProgramRepository.deleteById(id);
    }
}
