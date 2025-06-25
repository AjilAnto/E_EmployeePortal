package com.portal.employeeportal.repository;

import com.portal.employeeportal.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {


    List<Address> findByEmployeeId(Long employeeId);
}
