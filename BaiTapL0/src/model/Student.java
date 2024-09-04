package model;

import java.time.LocalDate;
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


    private void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    private void setUniversity(String university) {
        this.university = university;
    }

    private void setYearOfEntry(int yearOfEntry) {
        this.yearOfEntry = yearOfEntry;
    }

    private void setGpa(Double gpa) {
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
        System.out.printf("%-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s %-12s\n", 
        id, name, dob, address, height, weight, studentId, university, yearOfEntry, gpa);
    }
}
