package com.customermanager.service;

import com.customermanager.domain.Address;
import com.customermanager.domain.Contact;
import com.customermanager.domain.Customer;

import java.util.Date;
import java.util.List;

public interface CustomerService {

    public Customer addCustomer(Customer customer);

    public Address addAddress(String addressInfo, String customerName);

    public Contact addContact(String contactInfo, String customerName);

    public List<Customer> getPurchasedLicensesBetween(Date dateOne, Date dateTwo);

    public List<Customer> getUnlicensedFrom(Date date);

    public List<Customer> getExpiringLicensesBetween(Date dateOne, Date dateTwo);
}
