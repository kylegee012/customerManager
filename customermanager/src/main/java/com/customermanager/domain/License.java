package com.customermanager.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.Date;

@Getter
@Setter
@ToString
@Entity
@Table(name = "license")
public class License {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private long licenseId;

    @JoinColumn(name = "customerId")
    private long customerId;

    @Column(name = "startDate")
    private Date startDate;

    @Column(name = "endDate")
    private Date endDate;

    @Column(name = "seats")
    private Integer seats;

    @Column(name = "edition")
    private String edition;

    @Column(name = "purchaseDate")
    private Date purchaseDate;

    public License(Date startDate, Date endDate, Integer seats, String edition, Date purchaseDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.seats = seats;
        this.edition = edition;
        this.purchaseDate = purchaseDate;
    }
}
