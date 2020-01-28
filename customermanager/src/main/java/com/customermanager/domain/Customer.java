package com.customermanager.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long customerId;

    @Column(name = "name")
    private String customerName;

    @OneToMany(mappedBy = "customerId",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Address> addressList;

    @OneToMany(mappedBy = "customerId",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<Contact> contactList = new ArrayList<>();

    @OneToMany(mappedBy = "customerId",
            cascade = CascadeType.ALL,
            orphanRemoval = true)
    private List<License> licenseList = new ArrayList<>();
}
