package com.example.hr1.model.employees.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.hr1.model.employees.entity.EmployeesEntity;

@Repository
public interface EmpolyeesRepository extends JpaRepository<EmployeesEntity, Integer> {
    // 리포지터리 커스텀이 따로 필요할떄 이런식으로
    Optional<EmployeesEntity> findByEmployeeId(Integer employeeId);
}
