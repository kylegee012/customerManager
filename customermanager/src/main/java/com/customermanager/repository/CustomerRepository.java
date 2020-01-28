package com.customermanager.repository;

import com.customermanager.domain.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {

    Customer findByCustomerNameIgnoreCase(String customerName);

    List<Customer> findByCustomerIdIn(List<Long> customerIdList);

}
