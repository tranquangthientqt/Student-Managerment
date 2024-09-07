package manager;

import java.util.ArrayList;
import java.util.List;


import enums.Valid;
import menu.Menu;

import java.time.LocalDate;
import model.Student;
import utils.Validator;

public class StudentManager {
    private final List<Student> students = new ArrayList<>();
    private final Menu menu = new Menu("Update Student");

    //khởi tạo sub menu dùng để cập nhật thông tin sinh viên
    public void initializeMenu(){
        menu.addOption("1 - Update name");
        menu.addOption("2 - Update dob");
        menu.addOption("3 - Update address");
        menu.addOption("4 - Update height");
        menu.addOption("5 - Update weight");
    }
    // add new student
    /*
     * pos dùng để lưu vị trí của student trong list
     * yêu cầu nhập id student phải đúng định dạng ^student\d{3}$
     * nếu tìm thấy trong list đã tồn tại id student thì yêu cầu nhập lại
     * nếu chưa tồn tại thì tiếp tục nhập thông tin sinh viên
     * sau đó thêm student vào list
     * hiển thị thông tin sinh viên vừa thêm
     */
    public void addStudent() {
        int pos;
        String studentId;
        try {
            do {
                studentId = Validator.getStudentId("Enter student ID (10 characters): ", "Student ID must be 10 characters", Valid.STUDENT_ID_LENGTH.getValue(), "^student\\d{3}$");
                pos = searchStudentById(studentId);
                if (pos != -1) {
                    System.out.println("Student ID already exists.");
                }
            } while (pos != -1);
            String university = Validator.getString("Enter university name: ", "University name must be less than 200 characters", 0, Valid.MAX_SCHOOL_NAME_LENGTH.getValue());
            int yearOfEntry = Validator.getNumber("Enter year of entry: ", "Year of entry must be between 1900 and " + LocalDate.now().getYear(), Valid.START_YEAR.getValue(), LocalDate.now().getYear());
            double gpa = Validator.getNumber("Enter student GPA: ", "GPA must be between 0.0 and 10.0", Valid.MIN_GPA.getValue(), Valid.MAX_GPA.getValue());
            String name = Validator.getString("Enter student name: ", "Student name must be less than 100 characters", 0, Valid.MAX_NAME_LENGTH.getValue());
            LocalDate dob = Validator.getDate("Enter student date of birth: ", "Invalid date. Please enter a valid date.");
            String address = Validator.getString("Enter student address: ", "Student address must be less than 300 characters", 0, Valid.MAX_ADDRESS_LENGTH.getValue());
            double height = Validator.getNumber("Enter student height: ", "Height must be between 50.0 and 300.0", Valid.MIN_HEIGHT.getValue(), Valid.MAX_HEIGHT.getValue());
            double weight = Validator.getNumber("Enter student weight: ", "Weight must be between 5.0 and 1000.0", Valid.MIN_WEIGHT.getValue(), Valid.MAX_WEIGHT.getValue());

            Student student = new Student(name, dob, address, height, weight, studentId, university, yearOfEntry, gpa);
            students.add(student);
            System.out.println("Student added successfully. Here is the student information:");
            System.out.println(Validator.header());
            student.showInfo();
        } catch (Exception e) {
            System.out.println("An unexpected error occurred. Please try again.");
        }
    }

    public void addStudent(Student student) {
        students.add(student);
    }

    public void updateStudent() {
        Student x;
        do {
            String studentId = Validator.getStudentId("Enter student ID to update: ", "Student ID must be 10 characters", Valid.STUDENT_ID_LENGTH.getValue(), "^student\\d{3}$");
            x = searchStudentObjectById(studentId);
            if (x == null) {
                System.out.println("Not found student with id " + studentId + " in the list. Please try again.");
            } 
            else {
                initializeMenu();
                menu.showMenu();
                int choice = menu.getChoice();
                UpdateStudent updateStudent = new UpdateStudent(x);
                switch (choice) {
                    case 1:
                        updateStudent.updateName();
                        break;
                    case 2:
                        updateStudent.updateDob();
                        break;
                    case 3:
                        updateStudent.updateAddress();
                        break;
                    case 4:
                        updateStudent.updateHeight();
                        break;
                    case 5:
                        updateStudent.updateWeight();
                        break;
                }
                System.out.println("Student updated successfully. Here is the student information after update:");
                System.out.println(Validator.header());
                x.showInfo();
            }
        } while (x == null);
    }
    /*
     * student id nhận vào phải đúng định dạng ^student\d{3}$
     * nếu không tìm thấy, pos nhận giá trị -1 => yêu cầu nhập lại 
     * nếu tìm thấy trong list tồn tại student id vừa nhận vào thì hiển thị thông tin sinh viên vừa tìm thấy
     * hỏi có muốn xóa không, nếu muốn xóa thì xóa khỏi list
     * nếu không muốn xóa thì thoát khỏi hàm
     */
    public void removeStudent() {
        int pos;
        do {
            String studentId = Validator.getStudentId("Enter student ID to delete: ", "Student ID must be 10 characters", Valid.STUDENT_ID_LENGTH.getValue(), "^student\\d{3}$");
            pos = searchStudentById(studentId);
            if (pos == -1) {
                System.out.println("Not found student with id " + studentId + " in the list. Please try again.");
            } else {
                Student x;
                x = students.get(pos);
                x.showInfo();
                String confirm = Validator.getString("Are you sure you want to delete this student? (Y/N): ", "Invalid input. Please enter Y or N.");
                if (confirm.equalsIgnoreCase("Y")) {
                    students.remove(pos);
                    System.out.println("Student deleted successfully.");
                } else {
                    return;
                }
            }
        } while (pos == -1);
    }

    /*
     * yêu cầu nhập student id phải đúng định dạng ^student\d{3}$
     * hàm searchStudentObjectById dùng để tìm kiếm student trong list theo student id, trả về 1 student object
     * nếu không tìm thấy, trả về null => không tìm thấy student với student id vừa nhập
     * nếu tìm thấy, hiển thị thông tin sinh viên vừa tìm thấy
     */
    public void searchStudentById() {
        String studentId = Validator.getStudentId("Enter student ID to search: ", "Student ID must be 10 characters", Valid.STUDENT_ID_LENGTH.getValue(), "^student\\d{3}$");
        Student x = searchStudentObjectById(studentId);
        if (x != null) {
            System.out.println("Here is the Student "
                    + "that you want to search");
            System.out.println(Validator.header());
            x.showInfo();
        } else {
            System.out.println("Student not found.");
        }
    }

    public Student searchStudentObjectById(String studentId) {
        for (Student student : students) {
            if (student.getStudentId().equalsIgnoreCase(studentId)) {
                return student;
            }
        }
        return null;
    }
    
    private int searchStudentById(String studentId) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getStudentId().equalsIgnoreCase(studentId)) {
                return i;
            }
        }
        return -1;
    }

    public void showStudents() {
        if (students.isEmpty()) {
            System.out.println("No students in the list.");
            return;
        }
        System.out.println(Validator.header());
        for (Student student : students) {
            student.showInfo();
        }
    }

    public void sortStudentsByGpa() {
        students.sort((s1, s2) -> Double.compare(s2.getGpa(), s1.getGpa()));
        System.out.println("Students sorted by GPA.");
        showStudents();
    }
}
