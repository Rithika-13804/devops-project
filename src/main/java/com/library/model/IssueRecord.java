package com.library.model;

import java.time.LocalDate;

/**
 * IssueRecord Model Class
 * Represents a book issuance record
 */
public class IssueRecord {
    private int recordId;
    private int bookId;
    private int studentId;
    private LocalDate issueDate;
    private LocalDate dueDate;
    private LocalDate returnDate;
    private String status; // "ISSUED", "RETURNED", "OVERDUE"

    // Default Constructor
    public IssueRecord() {
        this.status = "ISSUED";
    }

    // Parameterized Constructor
    public IssueRecord(int recordId, int bookId, int studentId, 
                      LocalDate issueDate, LocalDate dueDate, 
                      LocalDate returnDate, String status) {
        this.recordId = recordId;
        this.bookId = bookId;
        this.studentId = studentId;
        this.issueDate = issueDate;
        this.dueDate = dueDate;
        this.returnDate = returnDate;
        this.status = status;
    }

    // Getters and Setters
    public int getRecordId() {
        return recordId;
    }

    public void setRecordId(int recordId) {
        this.recordId = recordId;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public LocalDate getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(LocalDate issueDate) {
        this.issueDate = issueDate;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public LocalDate getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(LocalDate returnDate) {
        this.returnDate = returnDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "IssueRecord{" +
                "recordId=" + recordId +
                ", bookId=" + bookId +
                ", studentId=" + studentId +
                ", issueDate=" + issueDate +
                ", dueDate=" + dueDate +
                ", returnDate=" + returnDate +
                ", status='" + status + '\'' +
                '}';
    }
}
