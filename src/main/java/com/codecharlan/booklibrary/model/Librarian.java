package com.codecharlan.booklibrary.model;

import com.codecharlan.booklibrary.enums.Role;
import com.codecharlan.booklibrary.model.Employee;
import com.codecharlan.booklibrary.repository.Book;
import com.codecharlan.booklibrary.repository.Library;
import com.codecharlan.booklibrary.subclass.Date;

public class Librarian extends Employee {

    Library library = Library.getInstance();
    Book book = Book.getInstance();

    public Librarian(String employeeName, String employeeId, String employeePhoneNumber, String employeeAddress, Date employeeDateOfBirth, Date employeeHireDate) {
        super(employeeName, employeeId, employeePhoneNumber, employeeAddress, employeeDateOfBirth, employeeHireDate);
    }

    public String addBook(Book bookTitle, Integer numberOfBook, Role role) {
        if (role != Role.LIBRARIAN) {
            return "You are not authorised to make this entry";
        } else {
            library.getBooksAvailable().put(String.valueOf(bookTitle), numberOfBook);
            return bookTitle + " has been added to the Library";
        }
    }
    public String givePriorityBook(Role role) {
        if (role == Role.LIBRARIAN) {
            if (book.getPriorityQueue().isEmpty()) {
                return "No books requested";
            }
            Book request = book.getPriorityQueue().poll();
            Role person = request.getRole();

            if (person.equals(Role.TEACHER)) {
                book.getPriorityQueue().remove(Role.TEACHER);
                return book + " taken by a Teacher";
            }

            if (person.equals(Role.SENIOR_STUDENT)) {
                book.getPriorityQueue().remove(Role.SENIOR_STUDENT);
                return book + " taken by a Senior Student";
            }

            if (person.equals(Role.JUNIOR_STUDENT)) {
                book.getPriorityQueue().remove(Role.JUNIOR_STUDENT);
                return book + "taken by a Junior Student";
            }

            return "No books requested";
        } else {
            return " You are not authorised to give out books";
        }
    }

    public String giveQueueBook(Role role, Book book) {
        if (book.getQueue().isEmpty()) {
            return "No books requested";
        }

        if (role == Role.TEACHER) {
            book.getQueue().remove(book);
            return "Book taken by a Teacher";
        }

        if (role == Role.SENIOR_STUDENT) {
            book.getQueue().remove(book);
            return "Book taken by a Senior Student";
        }

        if (role == Role.JUNIOR_STUDENT) {
            book.getQueue().remove(book);
            return "Book taken by a Junior Student";
        }

        return "No books requested";
    }


    @Override
    public String toString() {
        return "Librarian{" +
                "library=" + library +
                ", book=" + book +
                "} " + super.toString();
    }
}
