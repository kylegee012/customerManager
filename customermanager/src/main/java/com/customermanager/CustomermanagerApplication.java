package com.customermanager;

import com.customermanager.domain.Address;
import com.customermanager.domain.Contact;
import com.customermanager.domain.Customer;
import com.customermanager.domain.License;
import com.customermanager.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import javax.persistence.EntityManager;
import java.util.Date;



@SpringBootApplication
@EnableAutoConfiguration
public class CustomermanagerApplication {

//	@Autowired
//	private static CustomerRepository customerRepository;

	public static void main(String[] args) {
		SpringApplication.run(CustomermanagerApplication.class, args);
//		setup();

	}

//	void init(CustomerRepository repository) {
//		Customer customer = new Customer("customerName");
//		customer.setAddressList(new Address("street", "", "Minneapolis", "MN", "55903"));
//		customer.getContactList().add(
//				new Contact("first", "last", "123-456-9675")
//		);
//		customer.getLicenseList().add(
//				new License(new Date(02 - 25 - 2019), new Date(02 - 25 - 2020), 50, "standard", new Date(01 - 25 - 2019))
//		);
//		repository.save(customer);
//	}
}

