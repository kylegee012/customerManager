package com.customermanager.service;

import com.customermanager.domain.Customer;
import com.customermanager.domain.License;
import com.customermanager.repository.CustomerRepository;
import com.customermanager.repository.LicenseRepository;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LicenseServiceImpl implements LicenseService {

    @Autowired
    CustomerRepository customerRepository;

    @Override
    public License addLicense(String licenseInfo, String customerName) {
        Gson g = new GsonBuilder().setDateFormat("MM-dd-yyyy").create();
        License license = g.fromJson(licenseInfo, License.class);

        Customer customer = customerRepository.findByCustomerNameIgnoreCase(customerName);
        license.setCustomerId(customer.getCustomerId());
        customer.getLicenseList().add(license);
        customerRepository.save(customer);

        return license;
    }
}
