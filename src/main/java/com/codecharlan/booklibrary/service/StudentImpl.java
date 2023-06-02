package com.codecharlan.booklibrary.service;

import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.repository.Book;
import com.codecharlan.booklibrary.repository.Library;
import com.codecharlan.booklibrary.subclass.LibraryCard;

import java.util.Objects;

public class StudentImpl implements PriorityQueueRequest, QueueRequest {
    Library library = Library.getInstance();
    Book book = Book.getInstance();

    @Override
    public String priorityRequestBook(LibraryCard studentCard, Book book, Role role) {
        if (library.getBooksAvailable().containsKey(String.valueOf(book)) && library.getBooksAvailable().get(String.valueOf(book)) > 0) {
            switch (role) {
                case SENIOR_STUDENT -> this.book.getPriorityQueue().offer((new Book(Role.SENIOR_STUDENT, 2)));
                case JUNIOR_STUDENT -> this.book.getPriorityQueue().offer((new Book(Role.JUNIOR_STUDENT, 3)));
            }
            library.getBooksAvailable().put(String.valueOf(book), library.getBooksAvailable().get(String.valueOf(book)) - 1);

        } else {
            return book + " is not available";
        }
        return book + " has been requested by " + studentCard + " who is a : " + role;
    }

    @Override
    public String queueRequestBook(LibraryCard studentCard, Book bookTitle, Role role) {
        if (library.getBooksAvailable().containsKey(String.valueOf(bookTitle)) && library.getBooksAvailable().get(String.valueOf(bookTitle)) > 0) {
            switch (role) {
                case SENIOR_STUDENT, JUNIOR_STUDENT -> book.getQueue().offer(bookTitle);
            }
            library.getBooksAvailable().put(String.valueOf(bookTitle), library.getBooksAvailable().get(String.valueOf(bookTitle)) - 1);

        } else {
            return bookTitle + " is not available";
        }
        return bookTitle + " has been requested by " + studentCard + " who is a : " + role;
    }

    @Override
    public String toString() {
        return "StudentImpl{" +
                "library=" + library +
                ", book=" + book +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof StudentImpl student)) return false;
        return Objects.equals(library, student.library) && Objects.equals(book, student.book);
    }

    @Override
    public int hashCode() {
        return Objects.hash(library, book);
    }


}


