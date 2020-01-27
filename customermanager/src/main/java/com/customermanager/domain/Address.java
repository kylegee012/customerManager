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
@Table(name = "address")
public class Address {

    @GeneratedValue(strategy= GenerationType.AUTO)
    @Id
    long addressId;

    @Column(name = "street")
    @NotNull
    private String street;

    @Column(name = "secondaryNumber")
    private String secondaryNumber;

    @Column(name = "city")
    @NotNull
    private String city;

    @Column(name = "state")
    @NotNull
    private String state;

    @Column(name = "zipCode")
    @NotNull
    private String zipCode;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id")
    private Customer customer;
    
}
