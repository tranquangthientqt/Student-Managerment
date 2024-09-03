package model;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import enums.Valid;
import utils.CheckValid;

public class Person {
    private static int count = 1;
    protected final int id;
    protected String name;
    protected LocalDate dob;
    protected String address;
    protected Double height;
    protected Double weight;

    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    public Person() {
        this.id = count++;
    }

    public Person(String name, String dob, String address, Double height, Double weight) {
        this.id = count++;
        setName(name);
        setDob(dob);
        setAddress(address);
        setHeight(height);
        setWeight(weight);
    }

    private void setName(String name) {
        try {
            if (CheckValid.checkName(name)) {
                this.name = name;
            } else {
                throw new Exception("Name is too long");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setDob(String dob) {
        try {
            LocalDate date = LocalDate.parse(dob, formatter);
            if (date.getYear() <= Valid.DOB_YEAR.getValue()) {
                throw new Exception("Year of birth is invalid");
            } else {
                this.dob = date;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setAddress(String address) {
        try {
            if (CheckValid.checkAddress(address)) {
                this.address = address;
            } else {
                throw new Exception("Address is too long");
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setHeight(Double height) {
        try {
            if (CheckValid.checkHeight(height)) {
                throw new Exception("Height is invalid");
            } else {
                this.height = height;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    private void setWeight(Double weight) {
        try {
            if (CheckValid.checkWeight(weight)) {
                throw new Exception("Weight is invalid");
            } else {
                this.weight = weight;
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public LocalDate getDob() {
        return dob;
    }

    public String getAddress() {
        return address;
    }

    public Double getHeight() {
        return height;
    }

    public Double getWeight() {
        return weight;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dob=" + dob +
                ", address='" + address + '\'' +
                ", height=" + height +
                ", weight=" + weight +
                '}';
    }
}
