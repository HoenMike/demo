package com.example.demo.services;

import java.util.List;

import com.example.demo.entity.Course;

public interface CourseService {

    Course createCourse(Course course);

    List<Course> getAllCourses();

    Course updateCourse(Long id, Course course);

    void deleteCourse(Long id);
}
