package com.example.tidy.database;

public class houseOwner {

    private String FullName;
    private String NIC;
    private String Address;
    private String Mobile;
    private String Email;
    private String Password;
    private String Confirm_Password;

    public houseOwner(String fullName, String NIC, String address, String mobile, String email, String password, String confirm_Password) {
        FullName = fullName;
        this.NIC = NIC;
        Address = address;
        Mobile = mobile;
        Email = email;
        Password = password;
        Confirm_Password = confirm_Password;
    }

    public houseOwner() {

        FullName = "";
        this.NIC = "";
        Address = "";
        Mobile = "";
        Email = "";
        Password = "";
        Confirm_Password = "";

    }

    public String getFullName() {
        return FullName;
    }

    public void setFullName(String fullName) {
        FullName = fullName;
    }

    public String getNIC() {
        return NIC;
    }

    public void setNIC(String NIC) {
        this.NIC = NIC;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getMobile() {
        return Mobile;
    }

    public void setMobile(String mobile) {
        Mobile = mobile;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }

    public String getConfirm_Password() {
        return Confirm_Password;
    }

    public void setConfirm_Password(String confirm_Password) {
        Confirm_Password = confirm_Password;
    }
}
