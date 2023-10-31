package CURD.API.com.example.CurdApi.Controller;

import CURD.API.com.example.CurdApi.Model.Employee;
import CURD.API.com.example.CurdApi.Service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@CrossOrigin(origins ="http://localhost:3000")
@RestController
@RequestMapping("/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @GetMapping("")
    public  List<Employee> getEmployee(){
        return employeeService.getAllEmployee();
        //return employeeRepository.findAll();
    }
    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id){
        Employee employee=employeeService.getEmployee(id);
        //Employee employee = employeeRepository.findById(id).get();
        return employee;
    }
    @PostMapping("/store")
    public Employee saveEmployee(@RequestBody Employee employee){
        return employeeService.create(employee);
        //return employeeService.create(employee);
    }
    @PostMapping("/mutlipleUser")
    public List<Employee> createUsers(@RequestBody List<Employee> employees) {
        return employeeService.createEntity(employees);
    }

    @PutMapping("/update/{id}")
    public Employee updateEmployee(@PathVariable int id){
        return employeeService.update(id);
//        Employee employee = employeeRepository.findById(id).get();
//        employee.setActive(false);
//        employeeRepository.save(employee);
//        return employee;
    }
    @PutMapping("/updateEntity/{id}")
    public Employee updateEmployee(@PathVariable int id, @RequestBody Employee employee) {
        return employeeService.updateEntity(id,employee);
//        Employee employee = employeeRepository.findById(id).orElse(null);
//
//        if (employee != null) {
//            employee.setName(employee.getName());
//            employee.setAddress(employee.getAddress());
//            employee.setDegination(employee.getDegination());
//            employee.setActive(employee.isActive());
//
//            employeeRepository.save(employee);
//            return employee;
//        } else {
//            return null;
//        }
    }

    @DeleteMapping("/delete/{id}")
    public void deleteEmployee(@PathVariable int id){
        employeeService.deleteEntity(id);
        //Employee employee = employeeRepository.findById(id).get();
        //employeeRepository.delete(employee);

    }
}

