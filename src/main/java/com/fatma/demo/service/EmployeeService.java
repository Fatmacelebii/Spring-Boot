package com.fatma.demo.service;

import com.fatma.demo.model.Employee;
import com.fatma.demo.repository.EmployeeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class EmployeeService {

    private final EmployeeRepository employeeRepository;

    public List<Employee> getAllEmployees() {
        return employeeRepository.findAll();
    }

    public Employee createEmployee(Employee employee) {
        return employeeRepository.save(employee);
    }

    public Employee updateEmployee(Long id, Employee updatedEmployee) {
        // Çalışanı veritabanından al
        Employee employee = employeeRepository.findById(id).orElse(null);

        if (employee != null) { // Eğer çalışan varsa güncelle
            employee.setName(updatedEmployee.getName());
            employee.setEmail(updatedEmployee.getEmail());
            employee.setDepartment(updatedEmployee.getDepartment());

            return employeeRepository.save(employee);
        }

        return null;
    }

    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    public List<Employee> searchByName(String name) {
        return employeeRepository.findByNameContaining(name);
    }

    public List<Employee> getByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    public List<Employee> getEmployeesWithSalaryGreaterThan(Double amount) {
        return employeeRepository.findEmployeesWithSalaryGreaterThan(amount);
    }

    public List<Employee> getEmployeesByDepartmentNative(String dept) {
        return employeeRepository.findEmployeesByDepartmentNative(dept);
    }
}
