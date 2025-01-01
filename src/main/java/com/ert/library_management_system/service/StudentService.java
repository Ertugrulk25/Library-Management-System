package com.ert.library_management_system.service;

import com.ert.library_management_system.domain.Student;
import com.ert.library_management_system.exception.StudentNotFoundException;
import com.ert.library_management_system.repository.StudentRepository;

import java.util.Scanner;

public class StudentService {
    private Scanner scanner = new Scanner(System.in);
    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public void saveStudent() {
        Student student = new Student();

        System.out.println("Enter the student ID:  ");
        Long id = scanner.nextLong();
        scanner.nextLine();
        student.setId(id);

        System.out.println("Enter the student name: ");
        String name = scanner.nextLine();
        student.setName(name);

        studentRepository.save(student);

        System.out.println("Student saved successfully . Student ID:"+ student.getId());

    }

    public void deleteById(Long deleteStudentWithId) {
        Student student = studentRepository.findById(deleteStudentWithId);
        if (student != null) {
            studentRepository.delete(student);
        }else {
            System.out.println("Delete failed ");
        }
    }

    public void updateById(Long updateStudentId) {

        Student student = findById(updateStudentId);

        System.out.println("Enter new Student id ");
        Long newStudentId = scanner.nextLong();
        student.setId(newStudentId);

        System.out.println("Enter new Student name");
        String newStudent = scanner.nextLine();
        student.setName(newStudent);

        studentRepository.update(student);



    }

    private Student findById(Long updateStudentId) {
        try {
            Student foundStudent = studentRepository.findById(updateStudentId);

            if (foundStudent !=null) {
                System.out.println(foundStudent);

                return foundStudent;
            }else {//kendimiz exception oluşturduk
                throw new StudentNotFoundException("Student not foun by ID: ");
            }
        } catch (StudentNotFoundException e) {
            System.out.println(e.getMessage());
        }


        return null;
    }
}