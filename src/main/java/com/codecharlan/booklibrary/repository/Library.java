package com.codecharlan.booklibrary.repository;

import com.codecharlan.booklibrary.enums.Role;

import java.util.*;

public class Library {
    private List<Book> booksCatalog;


    private Integer queueOrder;
    private Map<String, Integer> booksAvailable;
    private Role role;
    public static Library instance;

    public static Library getInstance() {
        if (instance == null) {
            instance = new Library();
        }
        return instance;
    }

    public Library(Integer queueOrder, Role role) {
        this.queueOrder = queueOrder;
        this.role = role;
    }

    public Library() {
        this.booksCatalog = new ArrayList<>();
        this.booksAvailable = new HashMap<>();
    }


    public List<Book> getBooksCatalog() {
        return booksCatalog;
    }

    public void setBooksCatalog(List<Book> booksCatalog) {
        this.booksCatalog = booksCatalog;
    }


    public Role getRole() {
        return role;
    }

    public Integer getQueueOrder() {
        return queueOrder;
    }

    public Map<String, Integer> getBooksAvailable() {
        return booksAvailable;
    }

    public void setBooksAvailable(Map<String, Integer> booksAvailable) {
        this.booksAvailable = booksAvailable;
    }

    public String addBook(Book book, Integer numberOfBook, Role role) {
        if (role != Role.LIBRARIAN) {
            return "You are not authorised to make this entry";
        } else {
            booksAvailable.put(String.valueOf(book), numberOfBook);
            return book + "has been added to the store";
        }
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Library library)) return false;
        return Objects.equals(getBooksCatalog(), library.getBooksCatalog()) && Objects.equals(getQueueOrder(), library.getQueueOrder()) && Objects.equals(getBooksAvailable(), library.getBooksAvailable()) && getRole() == library.getRole();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getBooksCatalog(), getQueueOrder(), getBooksAvailable(), getRole());
    }

    @Override
    public String toString() {
        return "Library{" +
                "booksCatalog=" + booksCatalog +
                ", queueOrder=" + queueOrder +
                ", booksAvailable=" + booksAvailable +
                ", role=" + role +
                '}';
    }
}
