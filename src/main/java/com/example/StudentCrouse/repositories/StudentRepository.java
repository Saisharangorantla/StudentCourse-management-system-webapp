package com.example.StudentCrouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentCrouse.models.Student;

public interface StudentRepository extends JpaRepository<Student, Long> {}
