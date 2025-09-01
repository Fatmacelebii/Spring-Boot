package com.fatma.demo.service;

import com.fatma.demo.model.Book;
import com.fatma.demo.model.Student;
import com.fatma.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
@RequiredArgsConstructor
public class StudentService2 {

    private final StudentRepository studentRepository;

    // Tüm öğrencileri listele
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Yeni öğrenci oluştur
    public Student createStudent(Student student) {
        // Kitaplar varsa ilişkiyi kur
        if (student.getBooks() != null) {
            for (Book book : student.getBooks()) {
                book.setStudent(student);
            }
        }

        // Kaydet ve kaydedilen entity'i döndür
        return studentRepository.save(student);
    }
}

