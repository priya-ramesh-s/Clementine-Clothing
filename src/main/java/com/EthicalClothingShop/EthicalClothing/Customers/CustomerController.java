package com.EthicalClothingShop.EthicalClothing.Customers;

import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping(path="api/customers")
public class CustomerController {
    private CustomerService customerService;

    public CustomerController(CustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping
    public List<Customer> getAllCustomers (){
        return customerService.getAllCustomers();
    }

    @GetMapping("{customerID}")
    public Customer getCustomerById(@PathVariable("customerID") int customerID) {
        return customerService.getCustomer(customerID);
    }

    @GetMapping()
    public Customer getCustomerAccountInfoWhenLoggingIn(@RequestParam String email,
                                           @RequestParam String password) {
        return customerService.getCustomer(email, password);
    }


    @PutMapping
    public void updateAccountDetails(@RequestBody Customer customer){
        customerService.updateAccountDetails(customer);
    }
    @DeleteMapping("{customerName}")
    public void deleteCustomer(@PathVariable("customerName") Customer customerName){
        customerService.removeCustomer(customerName);


    }

    @PostMapping
    public void addNewCustomer(@RequestParam String firstName,
                               @RequestParam String lastName,
                               @RequestParam String email,
                               @RequestParam int mobile,
                               @RequestParam String password,
                               @RequestParam String firstLineAddress,
                               @RequestParam(required = false) String secondLineAddress,
                               @RequestParam String city,
                               @RequestParam String postcode) {
        customerService.addCustomer(firstName,lastName, email, mobile, password,firstLineAddress, secondLineAddress, city,postcode);
    }
}

    //Address Methods
//    @PostMapping
//    public void addCustomerAddressInformation(@RequestParam int customerID,
//                                              @RequestParam int addressID,
//                                              @RequestParam String firstLineAddress,
//                                              @RequestParam(required = false) String secondLineAddress,
//                                              @RequestParam String city,
//                                              @RequestParam String postcode) {
//        customerService.addCustomerAddress(customerID, addressID, firstLineAddress, secondLineAddress, city, postcode);
//    }

//    @PutMapping
//    public void updateCustomerAddressInformation(@RequestParam int customerID,
//                                                 @RequestParam int addressID,
//                                                 @RequestParam String firstLineAddress,
//                                                 @RequestParam(required = false) String secondLineAddress,
//                                                 @RequestParam String city,
//                                                 @RequestParam String postcode) {
//        customerService.updateCustomerAddress(customerID, addressID, firstLineAddress, secondLineAddress, city, postcode);
//    }
//
//    @DeleteMapping("{addressID}")
//    public Customer deleteCustomerAddressByAddressId(@PathVariable("addressID") int addressID) {
//        return customerService.removeAddress(addressID);
//    }
//
//    @GetMapping({"{addressID}"})
//    public Customer getCustomerAddressByAddressID(@PathVariable("{addressID}") int addressID) {
//        return customerService.getAddress(addressID);
//    }
//
//
//    @PostMapping
//    public void addCustomerAddressToAddressBook(@RequestParam int customerID,
//                                                @RequestParam int addressID) {
//        customerService.addAddressToAddressBook(customerID, addressID);
//    }
//   @PostMapping
//    public void addDefaultCustomerDeliveryAddress(@RequestParam int customerID,
//                                                  @RequestParam int addressID) {
//        customerService.addDeliveryAddress(customerID, addressID);
//   }
//
//    @PostMapping
//    public void addDefaultCustomerBillingAddress(@RequestParam int customerID,
//                                                 @RequestParam int addressID) {
//        customerService.addBillingAddress(customerID, addressID);
//    }
//}