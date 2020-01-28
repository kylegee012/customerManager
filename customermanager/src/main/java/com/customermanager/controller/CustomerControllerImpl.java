package com.customermanager.controller;

import com.customermanager.domain.Address;
import com.customermanager.domain.Contact;
import com.customermanager.domain.Customer;
import com.customermanager.repository.CustomerRepository;
import com.customermanager.service.CustomerService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@RestController
@RequestMapping(value="/customer")
public class CustomerControllerImpl implements CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody String customerInfo ) {
        Gson g = new GsonBuilder().setDateFormat("MM-dd-yyyy").create();
        Customer newCustomer = g.fromJson(customerInfo, Customer.class);
        newCustomer = customerRepository.save(newCustomer);
        return new ResponseEntity<>("Created: " + newCustomer.toString(), HttpStatus.OK);
    }

    @PostMapping("/addAddress/{customerName}")
    public ResponseEntity<String> addAddress(@RequestBody String addressInfo, String customerName ) {
        Address address = customerService.addAddress(addressInfo, customerName);
        return new ResponseEntity<>("Added addressList: " + address.toString() + " for " + customerName, HttpStatus.OK);
    }

    @PostMapping("/addContact/{customerName}")
    public ResponseEntity<String> addContact(@RequestBody String contactInfo, String customerName ) {
        Contact contact = customerService.addContact(contactInfo, customerName);
        return new ResponseEntity<>("Added contact: " + contact.toString() + " for " + customerName, HttpStatus.OK);
    }

    @GetMapping("/viewCustomer/{customerName}")
    public ResponseEntity<Customer> getCustomerByName(String customerName) {
        return new ResponseEntity<>(customerRepository.findByCustomerNameIgnoreCase(customerName), HttpStatus.OK);
    }

    @GetMapping("/viewAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = StreamSupport.stream(customerRepository.findAll().spliterator(), false)
                .collect(Collectors.toList());
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/purchasedLicensesFrom/{dateOne}/to{dateTwo}")
    public ResponseEntity<List<Customer>> purchasedLicensesBetween(
            @DateTimeFormat(pattern = "MM-dd-yyyy") Date start,
            @DateTimeFormat(pattern = "MM-dd-yyyy") Date end){

        List<Customer> customerList = customerService.getPurchasedLicensesBetween(start, end);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/expiredLicenseFrom/{dateOne}/to{dateTwo}")
    public ResponseEntity<List<Customer>> expiringLicensesBetween(
            @DateTimeFormat(pattern = "MM-dd-yyyy") Date start,
            @DateTimeFormat(pattern = "MM-dd-yyyy") Date end){

        List<Customer> customerList = customerService.getExpiringLicensesBetween(start, end);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/getUnlicensedFrom/{dateOne}")
    public ResponseEntity<List<Customer>> getUnlicensedFrom(
            @DateTimeFormat(pattern = "MM-dd-yyyy") Date date){

        List<Customer> customerList = customerService.getUnlicensedFrom(date);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}