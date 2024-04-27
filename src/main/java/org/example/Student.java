package org.example;

public class Student {

    private String name;
    private String phoneNumber;
    private String dob;
    private String address;
    private String classCode;

    public Student(String name , String phoneNumber, String dob, String address, String classCode )
    {
        this.name=name;
        this.phoneNumber=phoneNumber;
        this.dob=dob;
        this.address=address;
        this.classCode=classCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
    public String getdob() {
        return dob;
    }
    public void setdob(String dob) {
        this.dob=dob;
    }
    public String getClassCode() {
        return classCode;
    }

    public void setClassCode(String classCode) {
        this.classCode = classCode;
    }



}
