package com.agro.Final.Year.Project.Repositories;

import com.agro.Final.Year.Project.Models.Dto.ContractRecord;
import com.agro.Final.Year.Project.Models.Dto.LoginUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ContractRecordRepository extends JpaRepository<ContractRecord, Integer> {

    @Query(value = "SELECT * FROM contract_record r WHERE r.name = :name",
            nativeQuery = true)
    List<ContractRecord> findByName(@Param("name") String name);

    @Query(value = "SELECT * FROM contract_record r WHERE r.farmer_name = :name",
            nativeQuery = true)
    List<ContractRecord> findByFarmerName(@Param("name") String name);
}
