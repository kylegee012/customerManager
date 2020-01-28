package com.customermanager.service;

import com.customermanager.domain.Address;
import com.customermanager.domain.Contact;
import com.customermanager.domain.Customer;
import com.customermanager.domain.License;
import com.customermanager.repository.CustomerRepository;
import com.customermanager.repository.LicenseRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {

    @Autowired
    CustomerRepository customerRepository;

    @Autowired
    LicenseRepository licenseRepository;

    @Override
    public Customer addCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    @Override
    public Address addAddress(String addressInfo, String customerName) {
        Gson g = new GsonBuilder().setDateFormat("MM-dd-yyyy").create();
        Address address = g.fromJson(addressInfo, Address.class);

        Customer customer = customerRepository.findByCustomerNameIgnoreCase(customerName);
        address.setCustomerId(customer.getCustomerId());
        customer.getAddressList().add(address);
        customerRepository.save(customer);

        return address;
    }

    @Override
    public Contact addContact(String contactInfo, String customerName) {
        Gson g = new GsonBuilder().setDateFormat("MM-dd-yyyy").create();
        Contact contact = g.fromJson(contactInfo, Contact.class);

        Customer customer = customerRepository.findByCustomerNameIgnoreCase(customerName);
        contact.setCustomerId(customer.getCustomerId());
        customer.getContactList().add(contact);
        customerRepository.save(customer);

        return contact;
    }

    @Override
    public List<Customer> getPurchasedLicensesBetween(Date dateOne, Date dateTwo) {
        List<License> licenseList = licenseRepository.findByPurchaseDateBetween(dateOne, dateTwo);
        List<Long> customerIdList = new ArrayList<>();
        licenseList.forEach(l->customerIdList.add(l.getCustomerId()));
        return customerRepository.findByCustomerIdIn(customerIdList);
    }

    @Override
    public List<Customer> getExpiringLicensesBetween(Date dateOne, Date dateTwo) {
        List<License> licenseList = licenseRepository.findByEndDateBetween(dateOne, dateTwo);
        List<Long> customerIdList = new ArrayList<>();
        licenseList.forEach(l->customerIdList.add(l.getCustomerId()));
        return customerRepository.findByCustomerIdIn(customerIdList);
    }

    @Override
    public List<Customer> getUnlicensedFrom(Date date) {
        List<License> licensedList = licenseRepository.findByEndDateAfter(date);
        List<License> unlicensedList = licenseRepository.findByEndDateBefore(date);

        List<Long> licensedCustomerIdList = new ArrayList<>();
        List<Long> unlicensedCustomerIdList = new ArrayList<>();

        licensedList.forEach(l->licensedCustomerIdList.add(l.getCustomerId()));
        unlicensedList.forEach(l->unlicensedCustomerIdList.add(l.getCustomerId()));

        unlicensedCustomerIdList.removeAll(licensedList);

        return customerRepository.findByCustomerIdIn(unlicensedCustomerIdList);
    }


}
