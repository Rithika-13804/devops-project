package com.library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.library.model.Book;
import com.library.model.Student;
import com.library.dao.BookDAO;
import com.library.dao.IssueRecordDAO;
import com.library.util.StudentManager;
import com.library.App;

/**
 * IssueReturnController
 * Handles issuing and returning books
 */
public class IssueReturnController {

    @FXML
    private ComboBox<String> bookComboBox;

    @FXML
    private ComboBox<String> studentComboBox;

    @FXML
    private ComboBox<String> returnBookComboBox;

    @FXML
    private ComboBox<String> returnStudentComboBox;

    @FXML
    private Label issueStatusLabel;

    @FXML
    private Label returnStatusLabel;

    @FXML
    private Button issueBtn;

    @FXML
    private Button returnBtn;

    private BookDAO bookDAO;
    private IssueRecordDAO issueRecordDAO;
    private StudentManager studentManager;
    private App app;

    /**
     * Initialize controller
     */
    @FXML
    public void initialize() {
        this.bookDAO = new BookDAO();
        this.issueRecordDAO = new IssueRecordDAO();
        this.studentManager = new StudentManager();

        loadComboBoxes();
    }

    /**
     * Load available books and students into combo boxes
     */
    private void loadComboBoxes() {
        // Load available books for issuing
        ObservableList<String> availableBooks = FXCollections.observableArrayList();
        for (Book book : bookDAO.getAvailableBooks()) {
            availableBooks.add(book.getBookId() + " - " + book.getTitle());
        }
        bookComboBox.setItems(availableBooks);

        // Load all books for returning
        ObservableList<String> allBooks = FXCollections.observableArrayList();
        for (Book book : bookDAO.getAllBooks()) {
            allBooks.add(book.getBookId() + " - " + book.getTitle());
        }
        returnBookComboBox.setItems(allBooks);

        // Load students
        ObservableList<String> students = FXCollections.observableArrayList();
        for (Student student : studentManager.getAllStudents()) {
            students.add(student.getStudentId() + " - " + student.getName());
        }
        studentComboBox.setItems(students);
        returnStudentComboBox.setItems(students);
    }

    /**
     * Handle Issue Book button click
     */
    @FXML
    public void onIssueBook() {
        String selectedBook = bookComboBox.getValue();
        String selectedStudent = studentComboBox.getValue();

        if (selectedBook == null || selectedStudent == null) {
            issueStatusLabel.setText("Please select both book and student!");
            issueStatusLabel.setStyle("-fx-text-fill: #e74c3c;");
            return;
        }

        try {
            // Extract IDs from combo box values
            int bookId = Integer.parseInt(selectedBook.split(" - ")[0]);
            int studentId = Integer.parseInt(selectedStudent.split(" - ")[0]);

            // Issue the book
            boolean issueSuccess = issueRecordDAO.issueBook(bookId, studentId, 14); // 14 days borrow period
            boolean updateSuccess = bookDAO.issueBook(bookId);

            if (issueSuccess && updateSuccess) {
                issueStatusLabel.setText("Book issued successfully!");
                issueStatusLabel.setStyle("-fx-text-fill: #27ae60;");
                loadComboBoxes(); // Refresh combo boxes
            } else {
                issueStatusLabel.setText("Failed to issue book!");
                issueStatusLabel.setStyle("-fx-text-fill: #e74c3c;");
            }
        } catch (Exception e) {
            issueStatusLabel.setText("Error: " + e.getMessage());
            issueStatusLabel.setStyle("-fx-text-fill: #e74c3c;");
        }
    }

    /**
     * Handle Return Book button click
     */
    @FXML
    public void onReturnBook() {
        String selectedBook = returnBookComboBox.getValue();
        String selectedStudent = returnStudentComboBox.getValue();

        if (selectedBook == null || selectedStudent == null) {
            returnStatusLabel.setText("Please select both book and student!");
            returnStatusLabel.setStyle("-fx-text-fill: #e74c3c;");
            return;
        }

        try {
            // Extract IDs
            int bookId = Integer.parseInt(selectedBook.split(" - ")[0]);
            int studentId = Integer.parseInt(selectedStudent.split(" - ")[0]);

            // Return the book
            boolean returnSuccess = issueRecordDAO.returnBook(bookId, studentId);
            boolean updateSuccess = bookDAO.returnBook(bookId);

            if (returnSuccess && updateSuccess) {
                returnStatusLabel.setText("Book returned successfully!");
                returnStatusLabel.setStyle("-fx-text-fill: #27ae60;");
                loadComboBoxes(); // Refresh combo boxes
            } else {
                returnStatusLabel.setText("Book was not issued to this student!");
                returnStatusLabel.setStyle("-fx-text-fill: #e74c3c;");
            }
        } catch (Exception e) {
            returnStatusLabel.setText("Error: " + e.getMessage());
            returnStatusLabel.setStyle("-fx-text-fill: #e74c3c;");
        }
    }

    /**
     * Handle Back button click
     */
    @FXML
    public void onBack() {
        if (app != null) {
            app.showDashboard();
        }
    }

    // Setters for DAOs
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
        loadComboBoxes();
    }

    public void setIssueRecordDAO(IssueRecordDAO issueRecordDAO) {
        this.issueRecordDAO = issueRecordDAO;
    }
    
    /**
     * Setter for App reference
     */
    public void setApp(App app) {
        this.app = app;
    }
}

