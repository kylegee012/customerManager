package com.customermanager.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Entity
@Table(name = "addressList")
public class Address {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    long addressId;

    @JoinColumn(name = "customerId")
    private long customerId;

    @Column(name = "street")
    private String street;

    @Column(name = "secondaryNumber")
    private String secondaryNumber;

    @Column(name = "city")
    private String city;

    @Column(name = "state")
    private String state;

    @Column(name = "zipCode")
    private String zipCode;

    public Address( String street, String secondaryNumber, String city,  String state,  String zipCode) {
        this.street = street;
        this.secondaryNumber = secondaryNumber;
        this.city = city;
        this.state = state;
        this.zipCode = zipCode;
    }
}
