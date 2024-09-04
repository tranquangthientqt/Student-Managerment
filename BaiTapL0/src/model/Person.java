package model;

import java.time.LocalDate;

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

    private void setName(String name) {
        this.name = name;
    }

    private void setDob(LocalDate dob) {
        this.dob = dob;
    }

    private void setAddress(String address) {
        this.address = address;
    }

    private void setHeight(Double height) {
        this.height = height;
    }

    private void setWeight(Double weight) {
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
