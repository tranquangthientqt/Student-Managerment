package enums;

public enum Valid {
    MAX_NAME_LENGTH(100),
    DOB_YEAR(1900),
    MAX_ADDRESS_LENGTH(300),
    MIN_HEIGHT(50),
    MAX_HEIGHT(300),
    MIN_WEIGHT(5),
    MAX_WEIGHT(1000),
    STUDENT_ID_LENGTH(10), 
    MAX_SCHOOL_NAME_LENGTH(200), 
    START_YEAR(1900), 
    MIN_GPA(0.0), 
    MAX_GPA(10.0);
    
    private final double value;

    Valid(double value) {
        this.value = value;
    }

    public double getValue() {
        return value;
    }
}
