package com.example.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.demo.entity.CourseProgram;
import com.example.demo.entity.CourseProgramId;

public interface CourseProgramRepository extends JpaRepository<CourseProgram, CourseProgramId> {
}
