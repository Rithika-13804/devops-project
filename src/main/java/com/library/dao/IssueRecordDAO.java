package com.library.dao;

import com.library.model.IssueRecord;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * IssueRecordDAO - Data Access Object for Issue Record operations
 * Handles all issue and return operations using ArrayList
 */
public class IssueRecordDAO {
    private List<IssueRecord> records;
    private int nextRecordId;

    // Constructor
    public IssueRecordDAO() {
        this.records = new ArrayList<>();
        this.nextRecordId = 1;
    }

    /**
     * Create a new issue record
     */
    public boolean issueBook(int bookId, int studentId, int borrowDays) {
        LocalDate issueDate = LocalDate.now();
        LocalDate dueDate = issueDate.plusDays(borrowDays);

        IssueRecord record = new IssueRecord(nextRecordId++, bookId, studentId,
                issueDate, dueDate, null, "ISSUED");
        return records.add(record);
    }

    /**
     * Return a book and close the issue record
     */
    public boolean returnBook(int bookId, int studentId) {
        for (IssueRecord record : records) {
            if (record.getBookId() == bookId &&
                record.getStudentId() == studentId &&
                "ISSUED".equals(record.getStatus())) {

                record.setReturnDate(LocalDate.now());
                record.setStatus("RETURNED");
                return true;
            }
        }
        return false;
    }

    /**
     * Get all issue records
     */
    public List<IssueRecord> getAllRecords() {
        return new ArrayList<>(records);
    }

    /**
     * Get active issue records (currently issued books)
     */
    public List<IssueRecord> getActiveRecords() {
        List<IssueRecord> active = new ArrayList<>();
        for (IssueRecord record : records) {
            if ("ISSUED".equals(record.getStatus())) {
                active.add(record);
            }
        }
        return active;
    }

    /**
     * Get issue records for a specific student
     */
    public List<IssueRecord> getRecordsByStudent(int studentId) {
        List<IssueRecord> result = new ArrayList<>();
        for (IssueRecord record : records) {
            if (record.getStudentId() == studentId) {
                result.add(record);
            }
        }
        return result;
    }

    /**
     * Get issue records for a specific book
     */
    public List<IssueRecord> getRecordsByBook(int bookId) {
        List<IssueRecord> result = new ArrayList<>();
        for (IssueRecord record : records) {
            if (record.getBookId() == bookId) {
                result.add(record);
            }
        }
        return result;
    }

    /**
     * Check if a book is currently issued by a student
     */
    public boolean isBookIssuedToStudent(int bookId, int studentId) {
        for (IssueRecord record : records) {
            if (record.getBookId() == bookId &&
                record.getStudentId() == studentId &&
                "ISSUED".equals(record.getStatus())) {
                return true;
            }
        }
        return false;
    }

    /**
     * Get overdue records
     */
    public List<IssueRecord> getOverdueRecords() {
        List<IssueRecord> overdue = new ArrayList<>();
        LocalDate today = LocalDate.now();

        for (IssueRecord record : records) {
            if ("ISSUED".equals(record.getStatus()) && today.isAfter(record.getDueDate())) {
                record.setStatus("OVERDUE");
                overdue.add(record);
            }
        }
        return overdue;
    }

    /**
     * Delete a record
     */
    public boolean deleteRecord(int recordId) {
        return records.removeIf(record -> record.getRecordId() == recordId);
    }
}
