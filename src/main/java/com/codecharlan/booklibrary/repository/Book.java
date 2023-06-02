package com.codecharlan.booklibrary.repository;

import com.codecharlan.booklibrary.enums.Role;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;

public class Book implements Comparable<Book> {
    private String bookTitle;
    private String author;
    private String publisher;
    private Integer ISBN;
    private String category;
    private Role role;
    private Integer priority;
    private Queue<Book> queue;
    private PriorityQueue<Book> priorityQueue;

    public static Book instance;

    public static Book getInstance() {
        if (instance == null) {
            instance = new Book("Properties of Matter", "A.A.Juliet", "J.J Thaut Ltd", 000 - 2345, "Science");
        }
        return instance;
    }

    public Book(Role role) {
        this.role = role;
    }

    public Book(Role role, Integer priority) {
        this.role = role;
        this.priority = priority;
    }


    public Book(String bookTitle, String author, String publisher, Integer ISBN, String category) {
        this.bookTitle = bookTitle;
        this.author = author;
        this.publisher = publisher;
        this.ISBN = ISBN;
        this.category = category;
        this.queue = new LinkedList<>();
        priorityQueue = new PriorityQueue<>();
    }

    public Role getRole() {
        return role;
    }

    public void setBookTitle(String bookTitle) {
        this.bookTitle = bookTitle;
    }

    public String getBookTitle() {
        return bookTitle;
    }

    public PriorityQueue<Book> getPriorityQueue() {
        return priorityQueue;
    }

    public Queue<Book> getQueue() {
        return queue;
    }

    public void setQueue(Queue<Book> queue) {
        this.queue = queue;
    }

    @Override
    public int compareTo(Book that) {
        if (this.priority != that.priority) {
            if (this.priority == 1) {
                return -1;
            } else if (that.priority == 1) {
                return 1;
            } else if (this.priority == 2) {
                return -1;
            } else if (that.priority == 2) {
                return 1;
            } else if (this.priority == 3) {
                return -1;
            } else if (that.priority == 3) {
                return 1;
            }
        }
        return Integer.compare(this.priority, that.priority);
    }

    @Override
    public String toString() {
        return "Book{" +
                "bookTitle='" + bookTitle + '\'' +
                ", author='" + author + '\'' +
                ", publisher='" + publisher + '\'' +
                ", ISBN=" + ISBN +
                ", category='" + category + '\'' +
                '}';
    }
}
