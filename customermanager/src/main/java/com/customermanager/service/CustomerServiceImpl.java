package com.customermanager.service;

import com.customermanager.domain.Customer;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<Customer> getPurchasedLicensesBetween(Date dateOne, Date dateTwo) {
        return null;
    }

    @Override
    public List<Customer> getUnlicensedFrom(Date date) {
        return null;
    }

    @Override
    public List<Customer> getExpiringLicensesBetween(Date dateOne, Date dateTwo) {
        return null;
    }
}
