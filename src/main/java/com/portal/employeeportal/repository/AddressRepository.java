package com.portal.employeeportal.repository;

import com.portal.employeeportal.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

public interface AddressRepository extends JpaRepository<Address, Long> {


    List<Address> findByEmployeeIdAndIsActive(Long employeeId, Boolean isActive);

    @Modifying
    @Transactional
    @Query(value = "UPDATE Address SET isActive =:status WHERE id in (:addressIds)")
    int updateAddressByIds(@RequestParam("addressIds") List<Long> addressIds,@RequestParam("status") Boolean status);
}
