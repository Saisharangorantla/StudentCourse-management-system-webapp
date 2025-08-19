package com.example.StudentCrouse.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.StudentCrouse.models.Enrollment;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {}
