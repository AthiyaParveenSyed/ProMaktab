package com.uuq.repository;
import com.uuq.model.Enrollment;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EnrollmentRepository extends JpaRepository<Enrollment, Long> {
	Optional<Enrollment> findByWhatsappNumberAndCourseName(String whatsappNumber, String courseName);
}

