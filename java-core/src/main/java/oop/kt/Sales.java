package oop.kt;

import java.util.Date;
import java.util.List;

public class Sales extends UserBase{
    private List<String> products;

    public Sales(){ super();}

    public Sales(String fullname, String gender, String address, String phoneNo, Date dob, List<String> products){
        super(fullname, gender, address, phoneNo, dob);
        this.products = products;
    }
}
