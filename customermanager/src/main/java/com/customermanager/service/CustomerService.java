package com.customermanager.service;

import com.customermanager.domain.Customer;

import java.util.Date;
import java.util.List;

public interface CustomerService {

    public List<Customer> getPurchasedLicensesBetween(Date dateOne, Date dateTwo);

    public List<Customer> getUnlicensedFrom(Date date);

    public List<Customer> getExpiringLicensesBetween(Date dateOne, Date dateTwo);
}
