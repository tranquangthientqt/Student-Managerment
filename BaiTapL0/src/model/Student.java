package model;

import java.time.LocalDate;

import utils.Validator;
public class Student extends Person {
    private String studentId;
    private String university;
    private int yearOfEntry;
    private Double gpa;
    
    public Student() {
        super();
    }

    public Student(String name, LocalDate dob, String address, Double height, Double weight, String studentId, String university, int yearOfEntry, Double gpa) {
        super(name, dob, address, height, weight);
        setStudentId(studentId);
        setUniversity(university);
        setYearOfEntry(yearOfEntry);
        setGpa(gpa);
    }


    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public void setYearOfEntry(int yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }

    public void setGpa(Double gpa) {
        this.gpa = gpa; 
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
        System.out.printf(Validator.format(), 
        id, name, dob, address, height, weight, studentId, university, yearOfEntry, gpa);
    }
}
