
package com.example.demo;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PutMapping;

@RestController
public class AppController {
    
    @Autowired
    private StudentRepository studentRepository;

    private static final Logger logger = LoggerFactory.getLogger(AppController.class);
    
    @GetMapping("/greeting")
    public HashMap<String, String> greeting(@RequestParam (defaultValue = "World") String name){
        HashMap<String, String> response = new HashMap<>();
        response.put("id", "1");
        response.put("content", "Hello" + " " +  name);
        return response;
    }

    @GetMapping("/students")
    public ResponseEntity<List<Student>> getStudents(@RequestParam(defaultValue = "0") int id){
        if(id != 0){
            Student student = studentRepository.findById(id).orElse(null);
            return ResponseEntity.status(200).body(Arrays.asList(student));
        }else{
            List<Student> students = studentRepository.findAll();
            return ResponseEntity.status(200).body(students);
        }
    }

    @PostMapping("/students")
    public ResponseEntity<Student> createStudent(@RequestBody StudentDto studentDto){
        Student student = Student.builder().name(studentDto.getName()).studentClass(studentDto.getStudentClass()).build();
        Student savedStudent = studentRepository.save(student);
        return ResponseEntity.status(201).body(savedStudent);
    }

    @PutMapping("/students/{id}")
    public ResponseEntity<Student> updateStudent(@PathVariable int id, @RequestBody StudentDto studentDto){
        Student student = studentRepository.findById(id).orElse(null);
        if(student == null){
            logger.error("Student does not exist with id: " + id);
            return ResponseEntity.status(404).body(null);
        }
        if(studentDto.getName() != null){
            student.setName(studentDto.getName());
        }
        if(studentDto.getStudentClass() != null){
            student.setStudentClass(studentDto.getStudentClass());
        }
        return ResponseEntity.status(202).body(studentRepository.save(student));
    }

    @DeleteMapping("/students/{id}")
    public ResponseEntity<String> deleteStudent(@PathVariable int id){
        Student student = studentRepository.findById(id).orElse(null);
        if(student == null){
            logger.error("Student does not exist with id:" + id);
            return ResponseEntity.status(404).body("Student does not exist with id:" + id);
        }
        studentRepository.delete(student);
        return ResponseEntity.status(204).body("Student deleted successfully" + id);
    }

}
