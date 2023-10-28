package CURD.API.com.example.CurdApi.Service;

import CURD.API.com.example.CurdApi.Model.Employee;
import org.springframework.stereotype.Service;
import java.util.*;
@Service
public interface EmployeeService {
    public Employee create(Employee employee);
    public List<Employee> getAllEmployee();

    Employee getEmployee(int id);

    List<Employee> createEntity(List<Employee> employees);

    void deleteEntity(int id);

    Employee update(int id);

    Employee updateEntity(int id, Employee employee);
}

