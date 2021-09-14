package com.EthicalClothingShop.EthicalClothing.Customers;

import java.math.BigInteger;
import java.util.Objects;

public class Customer {
    private String firstName;
    private String lastName;
    private String firstLineAddress;
    private String secondLineAddress;
    private String city;
    private String postcode;
    private String email;
    private BigInteger mobileNumber;
    private String password;
    private int customerID;
    private int addressID;

    public Customer(String firstName, String lastName, String firstLineAddress, String secondLineAddress,
                    String city, String postcode, String email,
                    BigInteger mobileNumber, String password, int customerID, int addressID) {

        this.firstName = firstName;
        this.lastName = lastName;
        this.firstLineAddress = firstLineAddress;
        this.city = city;
        this.postcode = postcode;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.password = password;
        this.customerID = customerID;
    }

    public Customer(String firstName, String lastName, String email, BigInteger mobileNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
        this.mobileNumber = mobileNumber;
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

    public String getFirstLineAddress() {
        return firstLineAddress;
    }

    public void setFirstLineAddress(String firstLineAddress) {
        this.firstLineAddress = firstLineAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public BigInteger getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(BigInteger mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public int getCustomerID() {
        return customerID;
    }

    public void setCustomerID(int customerID) {
        this.customerID = customerID;
    }

    public int getAddressID() {
        return addressID;
    }

    public void setAddressID(int addressID) {
        this.addressID = addressID;
    }

    public String getSecondLineAddress() {
        return secondLineAddress;
    }

    public void setSecondLineAddress(String secondLineAddress) {
        this.secondLineAddress = secondLineAddress;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", firstLineAddress='" + firstLineAddress + '\'' +
                ", secondLineAddress='" + secondLineAddress + '\'' +
                ", city='" + city + '\'' +
                ", postcode='" + postcode + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber=" + mobileNumber +
                ", password='" + password + '\'' +
                ", customerID=" + customerID +
                ", addressID=" + addressID +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Customer customer = (Customer) o;
        return customerID == customer.customerID && addressID == customer.addressID && Objects.equals(firstName, customer.firstName) && Objects.equals(lastName, customer.lastName) && Objects.equals(firstLineAddress, customer.firstLineAddress) && Objects.equals(secondLineAddress, customer.secondLineAddress) && Objects.equals(city, customer.city) && Objects.equals(postcode, customer.postcode) && Objects.equals(email, customer.email) && Objects.equals(mobileNumber, customer.mobileNumber) && Objects.equals(password, customer.password);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, firstLineAddress, secondLineAddress, city, postcode, email, mobileNumber, password, customerID, addressID);
    }
}


