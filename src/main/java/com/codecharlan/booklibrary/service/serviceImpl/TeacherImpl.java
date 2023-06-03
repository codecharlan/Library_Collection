package com.codecharlan.booklibrary.service.serviceImpl;

import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.repository.Book;
import com.codecharlan.booklibrary.repository.Library;
import com.codecharlan.booklibrary.service.PriorityQueueRequest;
import com.codecharlan.booklibrary.service.QueueRequest;
import com.codecharlan.booklibrary.subclass.LibraryCard;

public class TeacherImpl implements PriorityQueueRequest, QueueRequest {
    Library library = Library.getInstance();
    Book book = Book.getInstance();

    @Override
    public String priorityRequestBook(LibraryCard teacherCard, Book book, Role role) {
        if (library.getBooksAvailable().containsKey(String.valueOf(book)) && library.getBooksAvailable().get(String.valueOf(book)) > 0) {
            this.book.getPriorityQueue().offer(new Book(Role.TEACHER, 1));
            library.getBooksAvailable().put(String.valueOf(book), library.getBooksAvailable().get(String.valueOf(book)) - 1);
        } else {
            return (book + "is not available");
        }
        return book + " has been requested by " + teacherCard + " who is a : " + role;
    }

    @Override
    public String queueRequestBook(LibraryCard teacherCard, Book bookTitle, Role role) {
        if (library.getBooksAvailable().containsKey(String.valueOf(bookTitle)) && library.getBooksAvailable().get(String.valueOf(bookTitle)) > 0) {
            if (role == Role.TEACHER) {
                book.getQueue().offer(bookTitle);
            }
            library.getBooksAvailable().put(String.valueOf(bookTitle), library.getBooksAvailable().get(String.valueOf(bookTitle)) - 1);

        } else {
            return bookTitle + " is not available";
        }
        return bookTitle + " has been requested by " + teacherCard + " who is a : " + role;
    }

    @Override
    public String toString() {
        return "TeacherImpl{" +
                "library=" + library +
                ", book=" + book +
                '}';
    }

}

