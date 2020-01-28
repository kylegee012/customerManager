package com.customermanager.service;

import com.customermanager.domain.Customer;
import com.customermanager.domain.License;

import java.util.Date;
import java.util.List;

public interface LicenseService {

    public License addLicense(String licenseInfo, String customerName);

}
