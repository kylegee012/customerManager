package com.customermanager.repository;

import com.customermanager.domain.License;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface LicenseRepository extends CrudRepository<License, Long> {

    List<License> findByPurchaseDateBetween(Date start, Date end);

    List<License> findByEndDateBetween(Date start, Date end);

    List<License> findByEndDateAfter(Date date);

}
