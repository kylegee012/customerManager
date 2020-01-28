package com.customermanager.controller;

import com.customermanager.domain.Customer;
import com.customermanager.domain.License;
import org.springframework.http.ResponseEntity;

import java.util.Date;
import java.util.List;

public interface CustomerController {

    public ResponseEntity<String> createCustomer(String customerInfo);

    public ResponseEntity<String> addContact(String customerInfo, String customerName);

    public ResponseEntity<String> addAddress(String customerInfo, String customerName);

    public ResponseEntity<Customer> getCustomerByName(String name);

    public ResponseEntity<List<Customer>> getAllCustomers();

    public ResponseEntity<List<Customer>> purchasedLicensesBetween(Date start, Date end);

    public ResponseEntity<List<Customer>> expiringLicensesBetween(Date start, Date end);

    public ResponseEntity<List<Customer>> getUnlicensedFrom(Date date);


}
