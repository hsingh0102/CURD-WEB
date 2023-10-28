package CURD.API.com.example.CurdApi.Repository;

import CURD.API.com.example.CurdApi.Model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee,Integer> {
}
