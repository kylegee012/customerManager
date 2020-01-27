package com.customermanager.controller;

import com.customermanager.domain.Customer;
import com.customermanager.domain.License;
import com.customermanager.repository.CustomerRepository;
import com.customermanager.repository.LicenseRepository;
import com.customermanager.service.CustomerService;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@RequestMapping(value="/customer")
public class CustomerControllerImpl implements CustomerController {

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    private CustomerService customerService;

    @PostMapping("/createCustomer")
    public ResponseEntity<String> createCustomer(@RequestBody String payload ) {
        Gson g = new GsonBuilder().setDateFormat("MM-dd-yyyy").create();
        Customer newCustomer = g.fromJson(payload, Customer.class);
        newCustomer = customerRepository.save(newCustomer);
        return new ResponseEntity<>("Created: " + newCustomer.toString(), HttpStatus.OK);
    }

    @PostMapping("/addLicense/{name}")
    public ResponseEntity<String> createLicense(@RequestBody License license, @RequestParam("name") String customerName) {

        License newLicense = licenseRepository.save(license);
        return new ResponseEntity<>("Added " + newLicense.toString() + " to " + customerName, HttpStatus.OK);
    }

    @GetMapping("/CustomerName/{name}")
    public ResponseEntity<Customer> getCustomerByName(@RequestParam("name") String customerName) {

//        Customer customerList = customerRepository.findByCustomerNameIgnoreCase(customerName);
//        List<Customer> customerList = new ArrayList<>();
//        customerRepository.findAll().forEach(customerList::add);
        return null;

//        return new ResponseEntity<Customer>(customerList, HttpStatus.OK);
    }

    @GetMapping("/ViewAllCustomers")
    public ResponseEntity<List<Customer>> getAllCustomers() {
        List<Customer> customerList = new ArrayList<>();
        customerRepository.findAll().forEach(customerList::add);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/purchasedLicensesFrom/{dateOne}/{dateTwo}")
    public ResponseEntity<List<Customer>> purchasedLicensesBetween(
            @RequestParam("dateOne") @DateTimeFormat(pattern = "MM-dd-yyyy") Date start,
            @RequestParam("dateTwo") @DateTimeFormat(pattern = "MM-dd-yyyy") Date end){

        List<Customer> customerList = customerService.getPurchasedLicensesBetween(start, end);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/expiredLicenseFrom/{dateOne}")
    public ResponseEntity<List<Customer>> expiringLicensesBetween(
            @RequestParam("dateOne") @DateTimeFormat(pattern = "MM-dd-yyyy") Date start,
            @RequestParam("dateTwo") @DateTimeFormat(pattern = "MM-dd-yyyy") Date end){

        List<Customer> customerList = customerService.getExpiringLicensesBetween(start, end);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }

    @GetMapping("/getUnlicensedFrom/{dateOne}/{dateTwo}")
    public ResponseEntity<List<Customer>> unlicensedFrom(
            @RequestParam("dateOne") @DateTimeFormat(pattern = "MM-dd-yyyy") Date date){

        List<Customer> customerList = customerService.getUnlicensedFrom(date);
        return new ResponseEntity<>(customerList, HttpStatus.OK);
    }
}