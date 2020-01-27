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
@Table(name = "contact")
public class Contact {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long contactId;

    @Column(name = "firstName")
    @NotNull
    private String firstName;

    @Column(name = "lastName")
    @NotNull
    private String lastName;

    @Column(name = "phoneNumber")
    @NotNull
    private String phoneNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}
