package com.codecharlan.booklibrary.service;

import com.codecharlan.booklibrary.Librarian;
import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.repository.Book;
import com.codecharlan.booklibrary.repository.Library;
import com.codecharlan.booklibrary.subclass.Date;
import com.codecharlan.booklibrary.subclass.LibraryCard;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.util.Assert;

import static org.junit.jupiter.api.Assertions.*;

class StudentImplTest {
    StudentImpl studentimpl;
    Date  studentTakeBookDate;
    Date studentReturnBookDate;
    Library library;
    Book book;

    LibraryCard studentCard;
    Role role;
    LibraryCard teacherCard;
    Date teacherTakeBookDate;
    Date teacherReturnBookDate;
    Librarian librarian;
    @BeforeEach
    void setUp() {
        studentimpl = new StudentImpl();
        library = Library.getInstance();
        book = Book.getInstance();
        studentTakeBookDate = new Date(12, 03, 2023);
        studentReturnBookDate = new Date(02, 04, 2023);
        teacherTakeBookDate = new Date(15, 05, 2023);
        teacherReturnBookDate = new Date(3, 06, 2023);
        studentCard = new LibraryCard("DecaSchool", "Adaoma", "A12345", "rtobe@gmail.com", "07034567890", studentTakeBookDate, studentReturnBookDate);
        teacherCard = new LibraryCard("DecaSchool", "Ifeoma", "A67890", "ifyone@gmail.com", "07034466772", teacherTakeBookDate, teacherReturnBookDate);
        librarian = new Librarian("Tommy", "R345678", "08086754356", "No 3, AnchorWay", new Date(4, 6, 1997), new Date(5, 7, 2023));
        librarian.addBook(book, 7, Role.LIBRARIAN);

    }

    @Test
    void priorityRequestBook() {
        String actual = studentimpl.priorityRequestBook(studentCard, book, Role.JUNIOR_STUDENT);
        String expected = book + " has been requested by " + studentCard + " who is a : " + Role.JUNIOR_STUDENT;
        boolean value = library.getBooksAvailable().values().toString() != null;
        Assertions.assertNotNull(actual);
        Assertions.assertTrue(value);
        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(library.getBooksAvailable().containsKey(String.valueOf(book)));
        Assertions.assertTrue(library.getBooksAvailable().get(String.valueOf(book)) > 0);

    }

    @Test
    void queueRequestBook() {
        String actual = studentimpl.queueRequestBook(studentCard, book, Role.SENIOR_STUDENT);
        String expected = book + " has been requested by " + studentCard + " who is a : " + Role.SENIOR_STUDENT;
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(library.getBooksAvailable().containsKey(String.valueOf(book)));
        Assertions.assertTrue(library.getBooksAvailable().get(String.valueOf(book)) > 0);
    }
}