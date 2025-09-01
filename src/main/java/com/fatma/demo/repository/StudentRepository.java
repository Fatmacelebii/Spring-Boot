package com.fatma.demo.repository;

import com.fatma.demo.model.Book;
import com.fatma.demo.model.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long> {

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {}
}
