package com.portal.employeeportal.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "address_details")
public class Address {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String houseName;

    private String laneOne;

    private String laneTwo;

    private String landMark;

    private String zipCode;

    @ManyToOne
    @JoinColumn(name = "employee_id")
    private Employee employee;

}
