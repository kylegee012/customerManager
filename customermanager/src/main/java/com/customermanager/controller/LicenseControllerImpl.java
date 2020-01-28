package com.customermanager.controller;

import com.customermanager.domain.License;
import com.customermanager.repository.LicenseRepository;
import com.customermanager.service.LicenseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/license")
public class LicenseControllerImpl {

    @Autowired
    private LicenseRepository licenseRepository;

    @Autowired
    private LicenseService licenseService;

    @PostMapping("/addLicense")
    public ResponseEntity<String> addLicense(@RequestBody String licenseInfo, @RequestParam("customerName") String customerName ) {
        License license = licenseService.addLicense(licenseInfo, customerName);
        return new ResponseEntity<>("Created: " + license.toString() + " for " + customerName, HttpStatus.OK);
    }

    @GetMapping("/viewAllLicenses")
    public ResponseEntity<String> viewAllLicenses() {
        return new ResponseEntity<>(licenseRepository.findAll().toString(), HttpStatus.OK);
    }
}
