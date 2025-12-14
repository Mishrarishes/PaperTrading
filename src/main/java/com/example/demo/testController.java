
package com.example.demo;
import java.util.HashMap;
import java.util.List;
import java.util.Arrays;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
public class testController {
    
    @Autowired
    private StudentRepository studentRepository;
    
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
}
