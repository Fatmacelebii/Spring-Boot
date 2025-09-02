package com.fatma.demo.repository;


import com.fatma.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {

    // İsme göre arama (içeren)
    List<Employee> findByNameContaining(String name);

    // Departmana göre arama (tam eşleşen)
    List<Employee> findByDepartment(String department);
}