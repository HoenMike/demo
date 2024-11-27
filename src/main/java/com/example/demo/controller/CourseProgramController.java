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

import com.example.demo.entity.CourseProgram;
import com.example.demo.entity.CourseProgramId;
import com.example.demo.services.CourseProgramService;

@RestController
@RequestMapping("/api")
public class CourseProgramController {

    @Autowired
    private CourseProgramService courseProgramService;

    @PostMapping("/course_program")
    public CourseProgram createCourseProgram(@RequestBody CourseProgram courseProgram) {
        return courseProgramService.createCourseProgram(courseProgram);
    }

    @GetMapping("/course_programs")
    public List<CourseProgram> getAllCoursePrograms() {
        return courseProgramService.getAllCoursePrograms();
    }

    @PutMapping("/course_program/{courseId}/{programId}")
    public CourseProgram updateCourseProgram(@PathVariable Long courseId, @PathVariable Long programId, @RequestBody CourseProgram courseProgram) {
        CourseProgramId id = new CourseProgramId(courseId, programId);
        return courseProgramService.updateCourseProgram(id, courseProgram);
    }

    @DeleteMapping("/course_program/{courseId}/{programId}")
    public void deleteCourseProgram(@PathVariable Long courseId, @PathVariable Long programId) {
        CourseProgramId id = new CourseProgramId(courseId, programId);
        courseProgramService.deleteCourseProgram(id);
    }
}
