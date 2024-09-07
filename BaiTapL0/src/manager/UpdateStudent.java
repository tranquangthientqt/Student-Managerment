package manager;

import java.time.LocalDate;

import enums.Valid;
import model.Student;
import utils.Validator;

public class UpdateStudent {
    private Student student;

    public UpdateStudent(Student student) {
        this.student = student;
    }

    public void updateName() {
        String name = Validator.getString("Enter new name: ", "Student name must be less than 50 characters", 0, Valid.MAX_NAME_LENGTH.getValue());
        student.setName(name);
    }

    public void updateDob() {
        LocalDate dob = Validator.getDate("Enter new date of birth: ", "Invalid date. Please enter a valid date.");
        student.setDob(dob);
    }

    public void updateAddress() {
        String address = Validator.getString("Enter new address: ", "Student address must be less than 300 characters", 0, Valid.MAX_ADDRESS_LENGTH.getValue());
        student.setAddress(address);
    }

    public void updateHeight() {
        double height = Validator.getNumber("Enter new height: ", "Height must be a number", 0, Double.MAX_VALUE);
        student.setHeight(height);
    }

    public void updateWeight() {
        double weight = Validator.getNumber("Enter student weight: ", "Weight must be between 5.0 and 1000.0", Valid.MIN_WEIGHT.getValue(), Valid.MAX_WEIGHT.getValue());
        student.setWeight(weight);
    }
}
