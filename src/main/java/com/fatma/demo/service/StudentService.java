package com.fatma.demo.service;

import com.fatma.demo.dto.request.BookRequest;
import com.fatma.demo.dto.request.StudentRequest;
import com.fatma.demo.dto.response.BookResponse;
import com.fatma.demo.dto.response.StudentResponse;
import com.fatma.demo.model.Book;
import com.fatma.demo.model.Student;
import com.fatma.demo.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@RequiredArgsConstructor
@Service
public class StudentService {

    private final StudentRepository studentRepository;

    // Tüm öğrencileri listele
    public List<Student> getAllStudents() {
        return studentRepository.findAll();
    }

    // Yeni öğrenci oluştur
    public StudentResponse createStudent(StudentRequest request) {
        // Student nesnesi oluştur
        Student student = new Student();
        student.setName(request.getName());
        student.setEmail(request.getEmail());

        // Kitapları ekle
        if (request.getBooks() != null) {
            List<Book> books = new ArrayList<>();
            for (BookRequest b : request.getBooks()) {
                Book book = new Book();
                book.setTitle(b.getTitle());
                book.setAuthor(b.getAuthor());
                book.setStudent(student); // ilişkiyi kur
                books.add(book);
            }
            student.setBooks(books);
        }


        Student savedStudent = studentRepository.save(student);

        // Response oluştur
        List<BookResponse> bookResponses = new ArrayList<>();
        if (savedStudent.getBooks() != null) {
            for (Book book : savedStudent.getBooks()) {
                bookResponses.add(new BookResponse(
                        book.getId(),
                        book.getTitle(),
                        book.getAuthor(),
                        savedStudent.getId()
                ));
            }
        }

        StudentResponse response = new StudentResponse();
        response.setId(savedStudent.getId());       // id ekledik
        response.setName(savedStudent.getName());
        response.setEmail(savedStudent.getEmail());
        response.setBooks(bookResponses);           // books ekledik

        return response;
    }
}

