package com.fatma.demo.repository;

import com.fatma.demo.model.Book;
import com.fatma.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {


    @Repository
    public interface BookRepository extends JpaRepository<Book, Long>{

    }
}
