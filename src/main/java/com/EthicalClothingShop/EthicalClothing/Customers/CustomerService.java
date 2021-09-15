package com.EthicalClothingShop.EthicalClothing.Customers;

import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerService {
    private CustomerDataAccessServicePsql database_access_customer;
    private Customer customerAccountInfo;

    // constructor
    public CustomerService(CustomerDataAccessServicePsql customerDataAccessServicePsql) {
        this. database_access_customer = customerDataAccessServicePsql;
    }

    public List<Customer> getAllCustomers() {
        return customerDataAccessService.getAllCustomers();
    }

    public Customer getCustomer(int Id) {
        List<Customer> customers = customerDataAccessService.getAllCustomers();
        return customers.stream().filter(c -> c.getId() == Id).findFirst().orElseThrow(() -> new IllegalStateException("Sorry this" + Id + "does not exist"));
    }

    public Customer getCustomer(String email, String password) {
        return database_access_customer.getCustomerAccountInfo(email, password);
    }


    private boolean doesCustomerExist(String customerEmail) {
        List<Customer> customers = customerDataAccessService.getAllCustomers();
        return customers.stream().anyMatch(c -> c.getEmail().equals(customerEmail));
    }

//    public void addCustomer(Customer customer) {
//        if (!doesCustomerExist(customer.getEmail())) {
//            customerDataAccessService.addNewCustomer(customer);
//        }
    }

    public void removeCustomer(Customer customer) {
        if (doesCustomerExist(customer.getEmail())) {
            customerDataAccessService.deleteCustomer(customer);
        } else {
            throw new IllegalStateException("this customer does not exist in our database!");
        }
    }

    public void updateAccountDetails(Customer customer) {
        List<Customer> customers = customerDataAccessService.getAllCustomers();
        boolean foundCustomer = false;
        for (Customer customer1 : customers) {
            if (doesCustomerExist(customer1.getEmail())) {
                customer1.setEmail(customer.getEmail());
                customer1.setMobileNumber(customer.getMobileNumber());
                customer1.setFirstLineAddress(customer.getFirstLineAddress());
                customer1.setCity(customer.getCity());
                customer1.setPostcode(customer.getPostcode());
                customer1.setFirstName(customer.getFirstName());
                customer1.setLastName(customer.getLastName());
                foundCustomer=true;
            }

        }if(!foundCustomer){
            throw new IllegalStateException("sorry this customer is not registered with us.");
        }

    }

    //Address Methods
    public void addCustomerAddress(int customerID, int addressID, String firstLineAddress, String secondLineAddress, String city, String postcode) {
        database_access_customer.addCustomerAddressToDatabase(customerID,addressID,firstLineAddress, secondLineAddress, city,postcode);
    }


    public void updateCustomerAddress(int customerID, int addressID, String firstLineAddress, String secondLineAddress, String city, String postcode) {
    }


    public Customer removeAddress(int addressID) {
    }


    public Customer getAddress(int customerID, int addressID, String firstLineAddress, String secondLineAddress, String city, String postcode) {
        return database_access_customer.getCustomerAddressInfo(customerID, addressID, firstLineAddress, secondLineAddress, city, postcode);
    }

    public void addDeliveryAddress(int customerID, int addressID) {
    }


    public void addBillingAddress(int customerID, int addressID) {
    }

    public void addAddressToAddressBook(int customerID, int addressID) {
    }

    public void addCustomer(String firstName, String lastName, String email, int mobile,
                               String password, String firstLineAddress, String secondLineAddress,
                               String city, String postcode) {
        // call a method from psql_customer class and pass it firstName, lastName, email, mobile, password
        int newCustomerId = database_access_customer.addNewCustomerIntoDataBase(firstName, lastName, email, password, mobile);
        // add new address to addresses table
        int addressId = addNewAddress(firstLineAddress, secondLineAddress, city, postcode);
        //addDefaultDeliveryAddress(addressId, this.customerAccountInfo.getCustomerID());
        //addDefaultBillingAddress(addressId, this.customerAccountInfo.getCustomerID());
    }

    public int addNewAddress(String firstLineAddress, String secondLineAddress,
                              String city_town, String postcode) {
        //call method in customerDataAccessServicePsql
        int addressId = database_access_customer.addNewCustomerIntoDataBase(firstLineAddress, secondLineAddress, city_town, postcode, this.customerAccountInfo.getCustomerID());

        return addressId;
    }

    public void addDefaultDeliveryAddress(int addressId, int customerId) {

    }

    public void addDefaultBillingAddress(int addressId, int customerId) {

    }





}