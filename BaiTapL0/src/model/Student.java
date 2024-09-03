package model;

import utils.CheckValid;

public class Student extends Person {
    private String studentId;
    private String university;
    private int yearOfEntry;
    private Double gpa;
    
    public Student() {
        super();
    }

    public Student(String name, String dob, String address, Double height, Double weight, String studentId, String university, int yearOfEntry, Double gpa) {
        super(name, dob, address, height, weight);
        setStudentId(studentId);
        setUniversity(university);
        setYearOfEntry(yearOfEntry);
        setGpa(gpa);
    }


    private void setStudentId(String studentId) {
        if (CheckValid.checkStudentId(studentId)) {
            this.studentId = studentId;
        } else {
            throw new IllegalArgumentException("Student ID is invalid");
        }
    }

    private void setUniversity(String university) {
        if (CheckValid.checkUniversity(university)) {
            this.university = university;
        } else {
            throw new IllegalArgumentException("University is invalid");
        }
    }

    private void setYearOfEntry(int yearOfEntry) {
        if (CheckValid.checkYearOfEntry(yearOfEntry)) {
            this.yearOfEntry = yearOfEntry;
        } else {
            throw new IllegalArgumentException("Year of entry is invalid");
        }
    }

    private void setGpa(Double gpa) {
        if (CheckValid.checkGpa(gpa)) {
            this.gpa = gpa; 
        } else {
            throw new IllegalArgumentException("GPA is invalid");
        }
    }

    public String getStudentId() {
        return studentId;
    }

    public String getUniversity() {
        return university;
    }

    public int getYearOfEntry() {
        return yearOfEntry;
    }

    public Double getGpa() {
        return gpa;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", university='" + university + '\'' +
                ", yearOfEntry=" + yearOfEntry +
                ", gpa=" + gpa +
                super.toString() +
                '}';
    }

    public void showInfo() {
        System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", 
        id, name, dob, address, height, weight, studentId, university, yearOfEntry, gpa);
    }
}
