package utils;
import java.util.Scanner;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Validator {
    private static Scanner sc = new Scanner(System.in);

    public static <T extends Number> int getNumber(String inputMsg, String errorMsg, T lowerBound, T upperBound) {
        double lower = lowerBound.doubleValue();
        double upper = upperBound.doubleValue();
        double n;

        // nếu đầu vào lower > upper thì đổi chỗ
        if (lower > upper) {
            double tmp = lower;
            lower = upper;
            upper = tmp;
        }

        while (true) {
            try {
                System.out.print(inputMsg);
                n = Double.parseDouble(sc.nextLine());
                if (n < lower || n > upper) {
                    throw new Exception();
                }
                return (int) n;
            } catch (NumberFormatException e) {
                System.out.println("Invalid input. Please enter a valid integer.");
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }

    public static String getStudentId(String inputMsg, String errorMsg, double length, String regex) {
        String studentId;
        while (true) {
            System.out.print(inputMsg);
            studentId = sc.nextLine();
            if (studentId.length() != length) {
                System.out.println(errorMsg);
            } else if (!studentId.matches(regex)) {
                System.out.println("Student ID only contain letters and numbers");
            } else {
                return studentId;
            }
        }
    }

    public static String getString(String inputMsg, String errorMsg, double minLength, double maxLength) {
        String str;
        while (true) {
            System.out.print(inputMsg);
            str = sc.nextLine();
            if (str.length() < minLength || str.length() > maxLength) {
                System.out.println(errorMsg);
            } else {
                return str;
            }
        }
    }

    public static LocalDate getDate(String inputMsg, String errorMsg) {
        LocalDate localDate;
        while (true) {
            System.out.print(inputMsg);
            String date = sc.nextLine();
            try {
                localDate = LocalDate.parse(date, DateTimeFormatter.ofPattern("dd/MM/yyyy"));
                if (localDate.getYear() < 1900 || localDate.getYear() > LocalDate.now().getYear()) {
                    throw new Exception();
                }
                return localDate;
            } catch (Exception e) {
                System.out.println(errorMsg);
            }
        }
    }
    public static void main(String[] args) {
        // System.out.println(getNumber("Enter student year of entry (1900-2024): ", "Year of entry must be between 1900 and 2024", 1900, 2024));
        // System.out.println(getNumber("Enter a number (1.5-5.5): ", "Number must be between 1.5 and 5.5", 1.5, 5.5));

        //System.out.println(getStudentId("Enter student ID (10 characters): ", "Student ID must be 10 characters", 10, "^[a-zA-Z0-9]+$"));
        System.out.println(getDate("Enter date (dd/MM/yyyy): ", "Invalid date. Please enter a valid date."));
    }
}
