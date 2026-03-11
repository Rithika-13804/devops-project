package com.library.util;

/**
 * SessionManager - Manages user session and authentication
 * Ensures only one user is logged in at a time
 */
public class SessionManager {
    private static SessionManager instance;
    private String currentUser;
    private boolean isLoggedIn;

    private SessionManager() {
        this.currentUser = null;
        this.isLoggedIn = false;
    }

    /**
     * Get singleton instance of SessionManager
     */
    public static SessionManager getInstance() {
        if (instance == null) {
            instance = new SessionManager();
        }
        return instance;
    }

    /**
     * Login user
     */
    public void login(String username) {
        this.currentUser = username;
        this.isLoggedIn = true;
        System.out.println("User logged in: " + username);
    }

    /**
     * Logout current user
     */
    public void logout() {
        System.out.println("User logged out: " + currentUser);
        this.currentUser = null;
        this.isLoggedIn = false;
    }

    /**
     * Get current logged-in user
     */
    public String getCurrentUser() {
        return currentUser;
    }

    /**
     * Check if user is logged in
     */
    public boolean isLoggedIn() {
        return isLoggedIn;
    }

    /**
     * Get welcome message
     */
    public String getWelcomeMessage() {
        if (isLoggedIn && currentUser != null) {
            return "Welcome, " + currentUser + "!";
        }
        return "Welcome to Library Management System";
    }
}
