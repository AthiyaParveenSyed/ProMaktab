package com.uuq.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "enrollments")
public class Enrollment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String whatsappNumber;
    
    private String courseName;
    private LocalDateTime enrollmentDateTime;

    // Constructor
    public Enrollment() {}

    public Enrollment(String name, String whatsappNumber, String courseName, LocalDateTime enrollmentDateTime ) {
    	this.name = name;
        this.whatsappNumber = whatsappNumber;
        this.courseName = courseName;
        this.enrollmentDateTime = enrollmentDateTime;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public String getWhatsappNumber() { return whatsappNumber; }
    public void setWhatsappNumber(String whatsappNumber) { this.whatsappNumber = whatsappNumber; }

    public String getCourseName() { return courseName; }
    public void setCourseName(String courseName) { this.courseName = courseName; }

    public LocalDateTime getEnrollmentDateTime() { return enrollmentDateTime; }
    public void setEnrollmentDateTime(LocalDateTime enrollmentDateTime) { this.enrollmentDateTime = enrollmentDateTime; }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}

