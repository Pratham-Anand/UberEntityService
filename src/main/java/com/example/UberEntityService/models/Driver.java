package com.example.UberEntityService.models;


//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import jakarta.validation.constraints.DecimalMax;
import jakarta.validation.constraints.DecimalMin;
import lombok.*;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;

import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler" , "bookings"})
public class Driver extends com.example.UberEntityService.models.BaseModel {

    private String name;

    private String address;

    private String aadharCard;

    @Column(nullable = false,unique = true)
    private String licenseNumber;

    @OneToOne(mappedBy = "driver",cascade=CascadeType.ALL)
    private Car car;

    @Enumerated(value=EnumType.STRING)
    private DriverApprovalStatus driverApplicationStatus;

    @OneToOne
    private ExactLocation exactLocation;

    @OneToOne
    private ExactLocation home;

    private String activeCity;
    @DecimalMin(value="0.00",message="Rating must be greater than or equal to 0.00")
    @DecimalMax(value="5.00",message="Rating must be less than or equal to 5.00")
    private double rating;


    @OneToMany(mappedBy = "driver",fetch = FetchType.LAZY)
    @Fetch(FetchMode.SUBSELECT)
    private List<Booking> bookings =new ArrayList<>();



}
