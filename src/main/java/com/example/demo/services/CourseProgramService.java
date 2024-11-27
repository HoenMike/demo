package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.CourseProgram;
import com.example.demo.entity.CourseProgramId;

public interface CourseProgramService {

    CourseProgram createCourseProgram(CourseProgram courseProgram);

    List<CourseProgram> getAllCoursePrograms();

    CourseProgram updateCourseProgram(CourseProgramId id, CourseProgram courseProgram);

    void deleteCourseProgram(CourseProgramId id);
}
