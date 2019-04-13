package com.company;

public class Student {

    private String id;
    private String firstName;
    private String lastName;
    private String yearBirth;

    public Student(String id, String firstName, String lastName, String yearBirth) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBirth = yearBirth;
    }

    public Student(String firstName, String lastName, String yearBirth) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.yearBirth = yearBirth;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getYearBirth() {
        return yearBirth;
    }

    public void setYearBirth(String yearBirth) {
        this.yearBirth = yearBirth;
    }

    @Override
    public String toString() {
        return String.format("{\"id\":\"%s\", \"firstName\":\"%s\", \"lastName\":\"%s\", \"yearBirth\":\"%s\"}", id, firstName, lastName, yearBirth);
    }
}
