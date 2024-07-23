package com.codurance.module1.preRequisites.bestPractices.properNamingAndStructure;

import java.util.UUID;

public class Library {
    private final BookRepository repository;

    public Library(BookRepository libraryRepository) {
        this.repository = libraryRepository;
    }

    public void addBook(Book book) {
        repository.saveBook(book);
    }

    public void loanBook(UUID id) throws CannotLoanBookException {
        Book book = getBook(id);
        canLoan(book);
        book.loanBook();
        repository.saveBook(book);
    }

    public void returnBook(UUID id) throws CannotReturnBookException {
        Book bookById = getBook(id);
        canReturn(bookById);
        bookById.returnBook();
        repository.saveBook(bookById);

    }

    private void canLoan(Book book) throws CannotLoanBookException {
        if (book.isOnLoan) {
            throw new CannotLoanBookException();
        }

    }

    private void canReturn(Book book) throws CannotReturnBookException {
        if (!book.isOnLoan) {
            throw new CannotReturnBookException();
        }
        ;
    }

    public Book getBook(UUID id) {
        return repository.findBookById(id);
    }
}
