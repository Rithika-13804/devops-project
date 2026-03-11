package com.library.util;

import com.library.model.Student;
import java.util.ArrayList;
import java.util.List;

/**
 * StudentManager Utility Class
 * Manages student data for the library system
 */
public class StudentManager {
    private List<Student> students;
    private int nextStudentId;

    // Constructor
    public StudentManager() {
        this.students = new ArrayList<>();
        this.nextStudentId = 1;
        initializeSampleStudents();
    }

    /**
     * Initialize sample students for demonstration
     */
    private void initializeSampleStudents() {
        students.add(new Student(nextStudentId++, "Rithika Gupta", "rithika@university.edu",
                "9876543210", "Computer Science", true));
        students.add(new Student(nextStudentId++, "Priya Singh", "priya@university.edu",
                "9876543211", "Electronics", true));
        students.add(new Student(nextStudentId++, "Amit Kumar", "amit@university.edu",
                "9876543212", "Mechanical", true));
        students.add(new Student(nextStudentId++, "Sarah Johnson", "sarah@university.edu",
                "9876543213", "Civil", true));
    }

    /**
     * Get all active students
     */
    public List<Student> getAllStudents() {
        List<Student> activeStudents = new ArrayList<>();
        for (Student student : students) {
            if (student.isActive()) {
                activeStudents.add(student);
            }
        }
        return activeStudents;
    }

    /**
     * Get student by ID
     */
    public Student getStudentById(int studentId) {
        for (Student student : students) {
            if (student.getStudentId() == studentId) {
                return student;
            }
        }
        return null;
    }

    /**
     * Add new student
     */
    public boolean addStudent(String name, String email, String phone, String department) {
        Student student = new Student(nextStudentId++, name, email, phone, department, true);
        return students.add(student);
    }

    /**
     * Delete student
     */
    public boolean deleteStudent(int studentId) {
        return students.removeIf(student -> student.getStudentId() == studentId);
    }

    /**
     * Update student information
     */
    public boolean updateStudent(int studentId, String name, String email, String phone) {
        Student student = getStudentById(studentId);
        if (student != null) {
            student.setName(name);
            student.setEmail(email);
            student.setPhone(phone);
            return true;
        }
        return false;
    }

    /**
     * Get total student count
     */
    public int getTotalStudents() {
        return students.size();
    }
}
