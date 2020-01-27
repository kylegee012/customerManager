package com.customermanager.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "license")
public class License {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    long licenseId;

    @Column(name = "startDate")
    @NotNull
    private Date startDate;

    @Column(name = "endDate")
    @NotNull
    private Date endDate;

    @Column(name = "seats")
    @NotNull
    private Integer seats;

    @Column(name = "edition")
    private String edition;

    @Column(name = "purchaseDate")
    @NotNull
    private Date purchaseDate;

    @ManyToOne(fetch = FetchType.LAZY)
    private Customer customer;
}
