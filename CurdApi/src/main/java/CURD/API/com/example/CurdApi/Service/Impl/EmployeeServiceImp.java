package CURD.API.com.example.CurdApi.Service.Impl;

import CURD.API.com.example.CurdApi.Model.Employee;
import CURD.API.com.example.CurdApi.Repository.EmployeeRepository;
import CURD.API.com.example.CurdApi.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.*;

@Service
public class EmployeeServiceImp implements EmployeeService {
    @Autowired
    EmployeeRepository employeeRepository;
    @Override
    public Employee create(Employee employee) {
        return employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public Employee getEmployee(int id) {
        Employee employee=employeeRepository.findById(id).get();
        return employee;
    }

    @Override
    public List<Employee> createEntity(List<Employee> employees) {
        return employeeRepository.saveAll(employees);
    }

    @Override
    public void deleteEntity(int id) {
        Employee employee=employeeRepository.findById(id).get();
        employeeRepository.delete(employee);
    }

    @Override
    public Employee update(int id) {
        Employee employee=employeeRepository.findById(id).get();
        employee.setActive(false);
        employeeRepository.save(employee);
        return employee;
    }

    @Override
    public Employee updateEntity(int id, Employee employee) {
        Employee employee1 = employeeRepository.findById(id).orElse(null);

        if (employee != null) {
            employee1.setName(employee.getName());
            employee1.setAddress(employee.getAddress());
            employee1.setDegination(employee.getDegination());
            employee1.setActive(employee.isActive());

            employeeRepository.save(employee1);
            return employee1;
        } else {
            return null;
        }
    }
}

