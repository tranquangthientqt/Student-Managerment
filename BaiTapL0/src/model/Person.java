package model;

import java.time.LocalDate;

import utils.Validator;


public class Person {
    private static int count = 1;
    protected final int id;
    protected String name;
    protected LocalDate dob;
    protected String address;
    protected Double height;
    protected Double weight;

    public Person() {
        this.id = count++;
    }

    public Person(String name, LocalDate dob, String address, Double height, Double weight) {
        this.id = count++;
        setName(name);
        setDob(dob);
        setAddress(address);
        setHeight(height);
        setWeight(weight);
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDob(LocalDate dob) {
        this.dob = dob;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setHeight(Double height) {
        this.height = height;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
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
        return String.format(Validator.format(), 
        id, name, dob, address, height, weight);
    }
}
