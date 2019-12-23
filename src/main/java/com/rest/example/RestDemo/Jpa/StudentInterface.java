package com.rest.example.RestDemo.Jpa;

import org.springframework.data.jpa.repository.JpaRepository;

import com.rest.example.RestDemo.Model.Student;

public interface StudentInterface extends JpaRepository<Student, Integer> {

}
