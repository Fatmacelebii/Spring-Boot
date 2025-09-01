package com.fatma.demo.controller;

import com.fatma.demo.model.Student;
import com.fatma.demo.service.StudentService2;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/students")
@RequiredArgsConstructor
public class StudentController2 {

    private final StudentService2 studentService;

    // Yeni öğrenci oluştur
    @PostMapping("/create")
    public Student createStudent(@RequestBody Student student) {
        return studentService.createStudent(student);
    }

    // Tüm öğrencileri listele
    @GetMapping("/list")
    public List<Student> getAllStudents() {
        return studentService.getAllStudents();
    }
}

