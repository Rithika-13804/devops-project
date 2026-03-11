package com.library.controller;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.control.PasswordField;
import javafx.scene.control.Label;
import com.library.App;
import com.library.util.SessionManager;

/**
 * LoginController
 * Handles user authentication and login
 */
public class LoginController {

    @FXML
    private TextField usernameField;

    @FXML
    private PasswordField passwordField;

    @FXML
    private Label errorLabel;

    private App app;
    private SessionManager sessionManager;

    /**
     * Initialize controller
     */
    @FXML
    public void initialize() {
        this.sessionManager = SessionManager.getInstance();
    }

    /**
     * Handle Login button click
     */
    @FXML
    public void onLogin() {
        String username = usernameField.getText().trim();
        String password = passwordField.getText().trim();

        // Check if user is already logged in
        if (sessionManager.isLoggedIn()) {
            errorLabel.setText("Another user is already logged in! Please logout first.");
            errorLabel.setStyle("-fx-text-fill: #e74c3c;");
            return;
        }

        // Simple hardcoded credentials for demo
        if (username.isEmpty() || password.isEmpty()) {
            errorLabel.setText("Please enter username and password!");
            errorLabel.setStyle("-fx-text-fill: #e74c3c;");
            return;
        }

        // Demo credentials - multiple users supported
        if ((username.equals("admin") && password.equals("admin123")) ||
            (username.equals("librarian") && password.equals("lib123")) ||
            (username.equals("user") && password.equals("user123"))) {
            
            errorLabel.setText("Login successful! Welcome " + username);
            errorLabel.setStyle("-fx-text-fill: #27ae60;");
            
            // Store user session
            sessionManager.login(username);
            
            // Navigate to dashboard after 800ms
            new Thread(() -> {
                try {
                    Thread.sleep(800);
                    if (app != null) {
                        javafx.application.Platform.runLater(() -> app.showDashboard());
                    }
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
        } else {
            errorLabel.setText("Invalid username or password!");
            errorLabel.setStyle("-fx-text-fill: #e74c3c;");
            passwordField.clear();
        }
    }

    /**
     * Setter for App reference
     */
    public void setApp(App app) {
        this.app = app;
    }
}
