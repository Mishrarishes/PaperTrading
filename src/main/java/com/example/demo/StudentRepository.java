package com.example.demo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Integer> {
    // You can add custom query methods here if needed
    // Example: List<Student> findByStudentClass(int studentClass);
}

