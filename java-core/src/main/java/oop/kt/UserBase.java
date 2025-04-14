package oop.kt;

import java.util.Date;

public class UserBase {
    protected String fullname;
    protected String gender;
    protected String address;
    protected String phoneNo;
    protected Date dob;

    UserBase(){}

    UserBase(String fullname, String gender, String address, String phoneNo, Date dob){
        this.fullname = fullname;
        this.gender = gender;
        this.address = address;
        this.phoneNo = phoneNo;
        this.dob = dob;
    }
}
