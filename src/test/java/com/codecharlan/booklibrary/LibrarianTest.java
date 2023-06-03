package com.codecharlan.booklibrary;

import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.model.Librarian;
import com.codecharlan.booklibrary.repository.Book;
import com.codecharlan.booklibrary.repository.Library;
import com.codecharlan.booklibrary.subclass.Date;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class LibrarianTest {
    Library library;
    Book book;
    Librarian librarian;
    @BeforeEach
    void setUp() {
        library = Library.getInstance();
        book = Book.getInstance();
        librarian = new Librarian("Tommy", "R345678", "08086754356", "No 3, AnchorWay", new Date(4, 6, 1997), new Date(5, 7, 2023));

    }

    @Test
    void addBook() {
        String expected = book + " has been added to the Library";
        String actual = librarian.addBook(book, 3, Role.LIBRARIAN);
        Assertions.assertNotNull(actual);
        Assertions.assertEquals(expected, actual);
        Assertions.assertTrue(library.getBooksAvailable().containsKey(String.valueOf(book)));
        Assertions.assertTrue(library.getBooksAvailable().get(String.valueOf(book)) > 0);
    }

    @Test
    void givePriorityBook() {
    boolean value = book.getPriorityQueue().isEmpty();
    Assertions.assertTrue(value);
    }
}