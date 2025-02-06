package com.jpa.example;

import com.jpa.example.model.Student;
import com.jpa.example.repository.StudentRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class SpringDataJpa1Application {

	public static void main(String[] args) {
		ApplicationContext applicationContext = SpringApplication.run(SpringDataJpa1Application.class, args);

		Student s1 = applicationContext.getBean(Student.class);
		s1.setRollNo(1);
		s1.setName("Rahul");
		s1.setMarks(80);

		Student s2 = applicationContext.getBean(Student.class);
		s2.setRollNo(2);
		s2.setName("Raj");
		s2.setMarks(70);

		Student s3 = applicationContext.getBean(Student.class);
		s3.setRollNo(3);
		s3.setName("Rohit");
		s3.setMarks(60);

		StudentRepository studentRepository = applicationContext.getBean(StudentRepository.class);
		studentRepository.save(s1);
		studentRepository.save(s2);
		studentRepository.save(s3);

		studentRepository.findAll().forEach(System.out::println);

		Student student = studentRepository.findByRollNo(5).orElse(new Student());
		System.out.println(student);

		studentRepository.findByMarksGreaterThan(65).forEach(System.out::println);

	}

}
