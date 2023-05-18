package com.akentech.cruddemo;

import com.akentech.cruddemo.dao.StudentDAO;
import com.akentech.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.security.PublicKey;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}
	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO){
		return runner -> {
			// createStudent(studentDAO);
			// createMultipleStudents(studentDAO);
			// readStudent(studentDAO);
			// queryForStudents(studentDAO);
			// queryForStudentsByLastName(studentDAO);
			updateStudent(studentDAO);
		};
	}

	private void updateStudent(StudentDAO studentDAO) {

		// Retrieve student based on id : Primary key
			int studentId = 1;
			System.out.println("Getting student with id : " + studentId);
			Student myStudent = studentDAO.findById(studentId);

		// Change first name to "Scooby"
			System.out.println("Updating student...");
			myStudent.setFirstName("Scooby");

		// Update the student
			studentDAO.update(myStudent);

		// Display the updated student
			System.out.println("Updated student : " + myStudent);
	}

	private void queryForStudentsByLastName(StudentDAO studentDAO) {

		// Get a list of students
		List<Student> theStudents = studentDAO.findByLastName("Mouse");

		// Display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void queryForStudents(StudentDAO studentDAO) {
		// Get list of students
		List<Student> theStudents = studentDAO.findAll();

		// Display list of students
		for (Student tempStudent : theStudents){
			System.out.println(tempStudent);
		}
	}

	private void readStudent(StudentDAO studentDAO) {
		// Create student object
		System.out.println("Creating new student object....");
		Student tempStudent = new Student("Glen", "Mba", "glenmba@gmail.com");

		// Save student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		// Display id of the saved student
		int theId = tempStudent.getId();
		System.out.println("Saved student Generated id: " + theId);

		// Retrieve student based on the id : Primary key
		System.out.println("Retrieving student with id: " + theId);
		Student myStudent = studentDAO.findById(theId);

		// Display student
		System.out.println("Found the student: " + myStudent);
	}


	private void createMultipleStudents(StudentDAO studentDAO) {

		//Create multiple student objects
		System.out.println("Creating 3 student object...");
		Student tempStudent1 = new Student("Edwin", "Black", "eblack@gmail.com");
		Student tempStudent2 = new Student("Kenrique", "Mouse", "Kmouse@gmail.com");
		Student tempStudent3 = new Student("Micky", "White", "mickywhite@gmail.com");

		//Save student objects
		System.out.println("Saving the students...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);
		studentDAO.save(tempStudent3);

	}
	private void createStudent(StudentDAO studentDAO) {

		//Create the student object
		System.out.println("Creating new student object...");
		Student tempStudent = new Student("Paul", "Doe", "pauldoe@gmail.com");

		//Save the student object
		System.out.println("Saving the student...");
		studentDAO.save(tempStudent);

		//Display id of the saved student
		System.out.println("Saved student . Generated id: " + tempStudent.getId());
	}

}