package com.library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.library.dao.BookDAO;
import com.library.App;
import com.library.util.SessionManager;

/**
 * DashboardController
 * Handles the main dashboard view and navigation
 */
public class DashboardController {

    @FXML
    private Label welcomeLabel;

    @FXML
    private Label totalBooksLabel;

    @FXML
    private Label availableBooksLabel;

    @FXML
    private Label issuedBooksLabel;

    // DAO instance for accessing book data
    private BookDAO bookDAO;
    
    // Reference to main App for navigation
    private App app;
    
    // Session manager for user session
    private SessionManager sessionManager;

    /**
     * Initialize controller - called when FXML is loaded
     */
    @FXML
    public void initialize() {
        // Create DAO instance
        this.bookDAO = new BookDAO();
        this.sessionManager = SessionManager.getInstance();

        // Set welcome message with current user
        updateWelcomeMessage();

        // Update statistics
        updateStatistics();
    }

    /**
     * Update welcome message with current logged-in user
     */
    private void updateWelcomeMessage() {
        String currentUser = sessionManager.getCurrentUser();
        if (currentUser != null && !currentUser.isEmpty()) {
            welcomeLabel.setText("Welcome, " + currentUser + "! 👤");
        } else {
            welcomeLabel.setText("Welcome to Library Management System");
        }
    }

    /**
     * Update dashboard statistics
     */
    private void updateStatistics() {
        int totalBooks = bookDAO.getTotalBooks();
        int availableBooks = bookDAO.getAvailableCount();
        int issuedBooks = totalBooks - availableBooks;

        totalBooksLabel.setText(String.valueOf(totalBooks));
        availableBooksLabel.setText(String.valueOf(availableBooks));
        issuedBooksLabel.setText(String.valueOf(issuedBooks));
    }

    /**
     * Called when Add Book button is clicked
     */
    @FXML
    public void onAddBookClicked() {
        if (app != null) {
            app.showAddBook();
        }
    }

    /**
     * Called when View Books button is clicked
     */
    @FXML
    public void onViewBooksClicked() {
        if (app != null) {
            app.showViewBooks();
        }
    }

    /**
     * Called when Issue Book button is clicked
     */
    @FXML
    public void onIssueBookClicked() {
        if (app != null) {
            app.showIssueReturn();
        }
    }

    /**
     * Called when Return Book button is clicked
     */
    @FXML
    public void onReturnBookClicked() {
        if (app != null) {
            app.showIssueReturn();
        }
    }

    /**
     * Called when Logout button is clicked
     */
    @FXML
    public void onLogoutClicked() {
        sessionManager.logout();
        if (app != null) {
            app.showLogin();
        }
    }

    /**
     * Getter for BookDAO - used by other controllers
     */
    public BookDAO getBookDAO() {
        return bookDAO;
    }
    
    /**
     * Set the App reference for navigation
     */
    public void setApp(App app) {
        this.app = app;
    }
}
