package utils;
import enums.Valid;

public class CheckValid {
    public static boolean checkName(String name) {
        return name.length() < Valid.MAX_NAME_LENGTH.getValue();
    }

    public static boolean checkAddress(String address) {
        return address.length() < Valid.MAX_ADDRESS_LENGTH.getValue();
    }

    public static boolean checkHeight(Double height) {
        return height < Valid.MIN_HEIGHT.getValue() || height > Valid.MAX_HEIGHT.getValue();
    }

    public static boolean checkWeight(Double weight) {
        return weight < Valid.MIN_WEIGHT.getValue() || weight > Valid.MAX_WEIGHT.getValue();
    }

    public static boolean checkStudentId(String studentId) {
        return studentId.length() == Valid.STUDENT_ID_LENGTH.getValue();
    }

    public static boolean checkUniversity(String university) {
        return university.length() < Valid.MAX_SCHOOL_NAME_LENGTH.getValue();
    }

    public static boolean checkYearOfEntry(int yearOfEntry) {
        return yearOfEntry >= Valid.START_YEAR.getValue();
    }

    public static boolean checkGpa(Double gpa) {
        return gpa >= Valid.MIN_GPA.getValue() && gpa <= Valid.MAX_GPA.getValue();
    }
}
