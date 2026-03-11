package com.library.dao;

import com.library.model.Book;
import java.util.ArrayList;
import java.util.List;

/**
 * BookDAO - Data Access Object for Book operations
 * Handles all book-related database operations using ArrayList
 */
public class BookDAO {
    private List<Book> books;
    private int nextBookId;

    // Constructor - Initialize ArrayList
    public BookDAO() {
        this.books = new ArrayList<>();
        this.nextBookId = 1;
        // Add sample data
        initializeSampleData();
    }

    /**
     * Initialize sample books for demonstration
     */
    private void initializeSampleData() {
        books.add(new Book(nextBookId++, "Effective Java", "Joshua Bloch", 
                          "978-0134685991", "Programming", true));
        books.add(new Book(nextBookId++, "Clean Code", "Robert Martin", 
                          "978-0132350884", "Programming", true));
        books.add(new Book(nextBookId++, "Design Patterns", "Gang of Four", 
                          "978-0201633610", "Programming", true));
    }

    /**
     * Add a new book to the library
     */
    public boolean addBook(String title, String author, String isbn, String category) {
        Book book = new Book(nextBookId++, title, author, isbn, category, true);
        return books.add(book);
    }

    /**
     * Get all books from the library
     */
    public List<Book> getAllBooks() {
        return new ArrayList<>(books);
    }

    /**
     * Get a book by ID
     */
    public Book getBookById(int bookId) {
        for (Book book : books) {
            if (book.getBookId() == bookId) {
                return book;
            }
        }
        return null;
    }

    /**
     * Get books by author
     */
    public List<Book> getBooksByAuthor(String author) {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.getAuthor().equalsIgnoreCase(author)) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Get available books
     */
    public List<Book> getAvailableBooks() {
        List<Book> result = new ArrayList<>();
        for (Book book : books) {
            if (book.isAvailable()) {
                result.add(book);
            }
        }
        return result;
    }

    /**
     * Mark a book as issued (unavailable)
     */
    public boolean issueBook(int bookId) {
        Book book = getBookById(bookId);
        if (book != null && book.isAvailable()) {
            book.setAvailable(false);
            return true;
        }
        return false;
    }

    /**
     * Mark a book as returned (available)
     */
    public boolean returnBook(int bookId) {
        Book book = getBookById(bookId);
        if (book != null && !book.isAvailable()) {
            book.setAvailable(true);
            return true;
        }
        return false;
    }

    /**
     * Delete a book from the library
     */
    public boolean deleteBook(int bookId) {
        return books.removeIf(book -> book.getBookId() == bookId);
    }

    /**
     * Update book details
     */
    public boolean updateBook(int bookId, String title, String author, 
                              String isbn, String category) {
        Book book = getBookById(bookId);
        if (book != null) {
            book.setTitle(title);
            book.setAuthor(author);
            book.setIsbn(isbn);
            book.setCategory(category);
            return true;
        }
        return false;
    }

    /**
     * Get total book count
     */
    public int getTotalBooks() {
        return books.size();
    }

    /**
     * Get available book count
     */
    public int getAvailableCount() {
        int count = 0;
        for (Book book : books) {
            if (book.isAvailable()) {
                count++;
            }
        }
        return count;
    }
}
