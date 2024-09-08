package model;

import java.time.LocalDate;

import enums.AcademicPerformance;
import utils.Validator;
public class Student extends Person {
    private String studentId;
    private String university;
    private int yearOfEntry;
    private Double gpa;
    private AcademicPerformance academicPerformance;
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


    private void updateAcademicPerformance() {
        if (gpa < 3) {
            academicPerformance = AcademicPerformance.POOR;
        } else if (gpa < 5) {
            academicPerformance = AcademicPerformance.WEAK;
        } else if (gpa < 6.5) {
            academicPerformance = AcademicPerformance.AVERAGE;
        } else if (gpa < 7.5) {
            academicPerformance = AcademicPerformance.FAIR;
        } else if (gpa < 9) {
            academicPerformance = AcademicPerformance.GOOD;
        } else {
            academicPerformance = AcademicPerformance.EXCELLENT;
        }
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
        updateAcademicPerformance();
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

    public AcademicPerformance getAcademicPerformance() {
        return academicPerformance;
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", university='" + university + '\'' +
                ", yearOfEntry=" + yearOfEntry +
                ", gpa=" + gpa +
                ", academicPerformance=" + academicPerformance +
                super.toString() +
                '}';
    }

    public void showInfo() {
        System.out.printf(Validator.format(), 
        id, name, dob, address, String.format("%.2f", height), String.format("%.2f", weight), studentId, university, yearOfEntry, String.format("%.2f", gpa), academicPerformance);
    }
}
