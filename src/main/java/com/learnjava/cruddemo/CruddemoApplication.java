package com.learnjava.cruddemo;

import com.learnjava.cruddemo.dao.StudentDAO;
import com.learnjava.cruddemo.entity.Student;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import java.util.List;

@SpringBootApplication
public class CruddemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(CruddemoApplication.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(StudentDAO studentDAO) {
		return runner -> queryForStudents(studentDAO);
	}

	private void queryForStudents(StudentDAO studentDAO) {
		List<Student> studentsList = studentDAO.findAll();
		studentsList.forEach(System.out::println);
	}

	private void readStudents(StudentDAO studentDAO) {
		Student myStudent = studentDAO.findById(2);
		System.out.println(myStudent);
	}

	private void createStudent(StudentDAO studentDAO) {
		// create student object
		System.out.println("Creating new student object ...");
		Student tempStudent1 = new Student("James", "Avila", "james.avila@email.com");
		Student tempStudent2 = new Student("James", "Bond", "james.avila@email.com");

		// save the student object
		System.out.println("Saving student object ...");
		studentDAO.save(tempStudent1);
		studentDAO.save(tempStudent2);

		// display id of the saved object
		System.out.println("Saved Student. Generated ID: " + tempStudent1.getId());
		System.out.println("Saved Student. Generated ID: " + tempStudent2.getId());
	}
//
//	private void createMultipleStudent(StudentDAO studentDAO) {
//		Student tempStudent1 = new Student("Teody", "Avila", "james.avila@email.com");
//		Student tempStudent2 = new Student("John", "Avila", "james.avila@email.com");
//		Student tempStudent3 = new Student("Merly", "Avila", "james.avila@email.com");
//
//		studentDAO.save(tempStudent1);
//		studentDAO.save(tempStudent2);
//		studentDAO.save(tempStudent3);
//
//		System.out.println("Saved Student. Generated ID: " + tempStudent1.getId());
//		System.out.println("Saved Student. Generated ID: " + tempStudent2.getId());
//		System.out.println("Saved Student. Generated ID: " + tempStudent3.getId());
//	}

}
