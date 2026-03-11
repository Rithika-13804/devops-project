package com.library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.Label;
import com.library.dao.BookDAO;
import com.library.App;

/**
 * AddBookController
 * Handles adding new books to the library
 */
public class AddBookController {

    @FXML
    private TextField titleField;

    @FXML
    private TextField authorField;

    @FXML
    private TextField isbnField;

    @FXML
    private TextField categoryField;

    @FXML
    private Label statusLabel;

    private BookDAO bookDAO;
    private App app;

    /**
     * Initialize controller
     */
    @FXML
    public void initialize() {
        // Initialize DAO - in a real app, this would be passed from main controller
        this.bookDAO = new BookDAO();
    }

    /**
     * Handle Add Book button click
     */
    @FXML
    public void onAddBook() {
        // Get values from text fields
        String title = titleField.getText().trim();
        String author = authorField.getText().trim();
        String isbn = isbnField.getText().trim();
        String category = categoryField.getText().trim();

        // Validate input
        if (title.isEmpty() || author.isEmpty() || isbn.isEmpty() || category.isEmpty()) {
            statusLabel.setText("All fields are required!");
            statusLabel.setStyle("-fx-text-fill: #e74c3c;");
            return;
        }

        // Add book to library
        try {
            boolean success = bookDAO.addBook(title, author, isbn, category);

            if (success) {
                statusLabel.setText("Book added successfully!");
                statusLabel.setStyle("-fx-text-fill: #27ae60;");

                // Clear form fields
                clearFields();
            } else {
                statusLabel.setText("Failed to add book!");
                statusLabel.setStyle("-fx-text-fill: #e74c3c;");
            }
        } catch (Exception e) {
            statusLabel.setText("Error: " + e.getMessage());
            statusLabel.setStyle("-fx-text-fill: #e74c3c;");
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

    /**
     * Clear all text fields
     */
    private void clearFields() {
        titleField.clear();
        authorField.clear();
        isbnField.clear();
        categoryField.clear();
    }

    /**
     * Setter for BookDAO
     */
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
    }
    
    /**
     * Setter for App reference
     */
    public void setApp(App app) {
        this.app = app;
    }
}
