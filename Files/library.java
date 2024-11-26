package com.example.library;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Library {
    private Map<String, Book> books;
    private Map<String, Member> members;
    private Map<String, Loan> loans;
    private Map<String, Double> fines;

    public Library() {
        books = new HashMap<>();
        members = new HashMap<>();
        loans = new HashMap<>();
        fines = new HashMap<>();
    }

    // Add a new book to the library
    public void addBook(String isbn, String title, String author, int copies) {
        if (books.containsKey(isbn)) {
            books.get(isbn).addCopies(copies);
        } else {
            books.put(isbn, new Book(isbn, title, author, copies));
        }
    }

    // Register a new member
    public void addMember(String memberId, String name) {
        if (members.containsKey(memberId)) {
            System.out.println("MEMBER_ALREADY_EXISTS");
        } else {
            members.put(memberId, new Member(memberId, name));
        }
    }

    // Issue a book to a member
    public void issueBook(String isbn, String memberId) {
        if (!books.containsKey(isbn)) {
            System.out.println("BOOK_NOT_FOUND");
            return;
        }
        if (!members.containsKey(memberId)) {
            System.out.println("MEMBER_NOT_FOUND");
            return;
        }

        Book book = books.get(isbn);
        Member member = members.get(memberId);

        if (book.getCopies() <= 0) {
            System.out.println("NO_COPIES_AVAILABLE");
            return;
        }

        book.issueCopy();
        loans.put(isbn + "-" + memberId, new Loan(book, member));
        System.out.println("BOOK_ISSUED");
    }

    // Return a book
    public void returnBook(String isbn, String memberId) {
        String loanKey = isbn + "-" + memberId;
        if (!loans.containsKey(loanKey)) {
            System.out.println("LOAN_NOT_FOUND");
            return;
        }

        Loan loan = loans.remove(loanKey);
        loan.getBook().returnCopy();
        System.out.println("BOOK_RETURNED");
    }

    // Calculate fines for overdue books
    public void calculateFines(String isbn, String memberId, int overdueDays) {
        String loanKey = isbn + "-" + memberId;
        if (!loans.containsKey(loanKey)) {
            System.out.println("LOAN_NOT_FOUND");
            return;
        }

        double fine = overdueDays * 2.0; // $2 per day
        fines.put(loanKey, fine);
        System.out.println("FINE_CALCULATED: " + fine);
    }

    // View all books
    public void viewBooks() {
        for (Book book : books.values()) {
            System.out.println(book);
        }
    }

    // View all members
    public void viewMembers() {
        for (Member member : members.values()) {
            System.out.println(member);
        }
    }

    // View all loans
    public void viewLoans() {
        for (Loan loan : loans.values()) {
            System.out.println(loan);
        }
    }

    // View all fines
    public void viewFines() {
        for (Map.Entry<String, Double> entry : fines.entrySet()) {
            System.out.println("Loan: " + entry.getKey() + ", Fine: $" + entry.getValue());
        }
    }

    // Get member loan history
    public void getMemberLoanHistory(String memberId) {
        for (Loan loan : loans.values()) {
            if (loan.getMember().getId().equals(memberId)) {
                System.out.println(loan);
            }
        }
    }

    // Update member details
    public void updateMember(String memberId, String newName) {
        if (!members.containsKey(memberId)) {
            System.out.println("MEMBER_NOT_FOUND");
            return;
        }
        members.get(memberId).setName(newName);
        System.out.println("MEMBER_UPDATED");
    }

    // Update book details
    public void updateBook(String isbn, String newTitle, String newAuthor) {
        if (!books.containsKey(isbn)) {
            System.out.println("BOOK_NOT_FOUND");
            return;
        }
        Book book = books.get(isbn);
        book.setTitle(newTitle);
        book.setAuthor(newAuthor);
        System.out.println("BOOK_UPDATED");
    }

    // Get overdue loans
    public void getOverdueLoans(int overdueDaysThreshold) {
        for (Map.Entry<String, Loan> entry : loans.entrySet()) {
            if (entry.getValue().isOverdue(overdueDaysThreshold)) {
                System.out.println(entry.getValue());
            }
        }
    }
}

class Book {
    private String isbn;
    private String title;
    private String author;
    private int copies;

    public Book(String isbn, String title, String author, int copies) {
        this.isbn = isbn;
        this.title = title;
        this.author = author;
        this.copies = copies;
    }

    public void issueCopy() { copies--; }
    public void returnCopy() { copies++; }
    public int getCopies() { return copies; }
    public void setTitle(String title) { this.title = title; }
    public void setAuthor(String author) { this.author = author; }

    @Override
    public String toString() {
        return "Book{" + "isbn='" + isbn + '\'' + ", title='" + title + '\'' + ", author='" + author + '\'' + ", copies=" + copies + '}';
    }
}

class Member {
    private String id;
    private String name;

    public Member(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public void setName(String name) { this.name = name; }

    @Override
    public String toString() {
        return "Member{" + "id='" + id + '\'' + ", name='" + name + '\'' + '}';
    }
}

class Loan {
    private Book book;
    private Member member;

    public Loan(Book book, Member member) {
        this.book = book;
        this.member = member;
    }

    public Book getBook() { return book; }
    public Member getMember() { return member; }

    public boolean isOverdue(int threshold) {
        return true;
    }

    @Override
    public String toString() {
        return "Loan{" + "book=" + book + ", member=" + member + '}';
    }
}
