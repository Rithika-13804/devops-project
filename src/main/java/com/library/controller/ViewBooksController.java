package com.library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.control.Label;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import com.library.model.Book;
import com.library.dao.BookDAO;
import com.library.App;

/**
 * ViewBooksController
 * Handles displaying all books in a table
 */
public class ViewBooksController {

    @FXML
    private TableView<Book> booksTable;

    @FXML
    private TableColumn<Book, Integer> bookIdCol;

    @FXML
    private TableColumn<Book, String> titleCol;

    @FXML
    private TableColumn<Book, String> authorCol;

    @FXML
    private TableColumn<Book, String> isbnCol;

    @FXML
    private TableColumn<Book, String> categoryCol;

    @FXML
    private TableColumn<Book, String> statusCol;

    @FXML
    private Label totalLabel;

    @FXML
    private Label availableLabel;

    @FXML
    private Label issuedLabel;

    private BookDAO bookDAO;
    private App app;

    /**
     * Initialize controller
     */
    @FXML
    public void initialize() {
        this.bookDAO = new BookDAO();
        setupTableColumns();
        loadBooks();
    }

    /**
     * Setup table column mappings to Book properties
     */
    private void setupTableColumns() {
        bookIdCol.setCellValueFactory(new PropertyValueFactory<>("bookId"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        isbnCol.setCellValueFactory(new PropertyValueFactory<>("isbn"));
        categoryCol.setCellValueFactory(new PropertyValueFactory<>("category"));

        // Custom status column - shows "Available" or "Issued"
        statusCol.setCellValueFactory(cellData -> {
            String status = cellData.getValue().isAvailable() ? "Available" : "Issued";
            return new javafx.beans.property.SimpleStringProperty(status);
        });
    }

    /**
     * Load books from DAO and display in table
     */
    private void loadBooks() {
        ObservableList<Book> books = FXCollections.observableArrayList(
                bookDAO.getAllBooks()
        );
        booksTable.setItems(books);
        updateStatistics();
    }

    /**
     * Update summary statistics
     */
    private void updateStatistics() {
        int total = bookDAO.getTotalBooks();
        int available = bookDAO.getAvailableCount();
        int issued = total - available;

        totalLabel.setText(String.valueOf(total));
        availableLabel.setText(String.valueOf(available));
        issuedLabel.setText(String.valueOf(issued));
    }

    /**
     * Handle Refresh button click
     */
    @FXML
    public void onRefresh() {
        loadBooks();
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
     * Setter for BookDAO
     */
    public void setBookDAO(BookDAO bookDAO) {
        this.bookDAO = bookDAO;
        loadBooks();
    }
    
    /**
     * Setter for App reference
     */
    public void setApp(App app) {
        this.app = app;
    }
}

