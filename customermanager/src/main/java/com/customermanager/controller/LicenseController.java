package com.customermanager.controller;

import com.customermanager.domain.License;
import org.springframework.http.ResponseEntity;

public interface LicenseController {

    public ResponseEntity<String> addLicense(License license, String customerName);

    public ResponseEntity<String> viewAllLicenses();
}
