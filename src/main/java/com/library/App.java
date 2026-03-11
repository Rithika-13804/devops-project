package com.library;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.Parent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import com.library.controller.DashboardController;
import com.library.controller.AddBookController;
import com.library.controller.ViewBooksController;
import com.library.controller.IssueReturnController;
import com.library.controller.LoginController;
import com.library.dao.BookDAO;
import com.library.dao.IssueRecordDAO;

/**
 * App - Main JavaFX Application
 * Entry point for the Library Management System
 */
public class App extends Application {

    private Stage primaryStage;
    private BookDAO bookDAO;
    private IssueRecordDAO issueRecordDAO;

    // Controllers
    private LoginController loginController;
    private DashboardController dashboardController;
    private AddBookController addBookController;
    private ViewBooksController viewBooksController;
    private IssueReturnController issueReturnController;

    // Scenes
    private Scene loginScene;
    private Scene dashboardScene;
    private Scene addBookScene;
    private Scene viewBooksScene;
    private Scene issueReturnScene;

    @Override
    public void start(Stage stage) throws Exception {
        this.primaryStage = stage;

        // Initialize DAOs (shared across controllers)
        this.bookDAO = new BookDAO();
        this.issueRecordDAO = new IssueRecordDAO();

        // Load all FXML files and create scenes
        loadScenes();

        // Set primary stage properties
        primaryStage.setTitle("Library Management System");
        primaryStage.setWidth(900);
        primaryStage.setHeight(650);
        primaryStage.setScene(loginScene);

        // Show the primary stage
        primaryStage.show();

        System.out.println("Library Management System Started");
    }

    /**
     * Load all FXML scenes and initialize controllers
     */
    private void loadScenes() throws Exception {
        // Load Login
        FXMLLoader loginLoader = new FXMLLoader(
                getClass().getResource("/fxml/Login.fxml")
        );
        Parent loginRoot = loginLoader.load();
        loginController = loginLoader.getController();
        loginScene = new Scene(loginRoot);

        // Load Dashboard
        FXMLLoader dashboardLoader = new FXMLLoader(
                getClass().getResource("/fxml/Dashboard.fxml")
        );
        Parent dashboardRoot = dashboardLoader.load();
        dashboardController = dashboardLoader.getController();
        dashboardScene = new Scene(dashboardRoot);

        // Load Add Book
        FXMLLoader addBookLoader = new FXMLLoader(
                getClass().getResource("/fxml/AddBook.fxml")
        );
        Parent addBookRoot = addBookLoader.load();
        addBookController = addBookLoader.getController();
        addBookController.setBookDAO(bookDAO);
        addBookScene = new Scene(addBookRoot);

        // Load View Books
        FXMLLoader viewBooksLoader = new FXMLLoader(
                getClass().getResource("/fxml/ViewBooks.fxml")
        );
        Parent viewBooksRoot = viewBooksLoader.load();
        viewBooksController = viewBooksLoader.getController();
        viewBooksController.setBookDAO(bookDAO);
        viewBooksScene = new Scene(viewBooksRoot);

        // Load Issue/Return Books
        FXMLLoader issueReturnLoader = new FXMLLoader(
                getClass().getResource("/fxml/IssueReturn.fxml")
        );
        Parent issueReturnRoot = issueReturnLoader.load();
        issueReturnController = issueReturnLoader.getController();
        issueReturnController.setBookDAO(bookDAO);
        issueReturnController.setIssueRecordDAO(issueRecordDAO);
        issueReturnScene = new Scene(issueReturnRoot);

        // Set up controller references and data
        setupControllers();
    }

    /**
     * Setup controllers with App reference and shared data
     */
    private void setupControllers() {
        // Set App reference for all controllers
        loginController.setApp(this);
        dashboardController.setApp(this);
        addBookController.setApp(this);
        viewBooksController.setApp(this);
        issueReturnController.setApp(this);
    }

    /**
     * Navigate to Dashboard scene
     */
    public void showDashboard() {
        primaryStage.setScene(dashboardScene);
        primaryStage.setTitle("Library Management - Dashboard");
    }

    /**
     * Navigate to Login scene
     */
    public void showLogin() {
        primaryStage.setScene(loginScene);
        primaryStage.setTitle("Library Management System - Login");
    }

    /**
     * Navigate to Add Book scene
     */
    public void showAddBook() {
        primaryStage.setScene(addBookScene);
        primaryStage.setTitle("Library Management - Add Book");
    }

    /**
     * Navigate to View Books scene
     */
    public void showViewBooks() {
        viewBooksController.setBookDAO(bookDAO);
        primaryStage.setScene(viewBooksScene);
        primaryStage.setTitle("Library Management - View Books");
    }

    /**
     * Navigate to Issue/Return scene
     */
    public void showIssueReturn() {
        issueReturnController.setBookDAO(bookDAO);
        primaryStage.setScene(issueReturnScene);
        primaryStage.setTitle("Library Management - Issue/Return Books");
    }

    /**
     * Main method - entry point for Java application
     */
    public static void main(String[] args) {
        launch(args);
    }
}
