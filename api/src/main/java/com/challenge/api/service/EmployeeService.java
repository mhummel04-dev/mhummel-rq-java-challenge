package com.challenge.api.service;

import com.challenge.api.model.Employee;
import com.challenge.api.model.EmployeeImpl;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Service
public class EmployeeService {

    List<Employee> employees = new ArrayList<>();

    public EmployeeService() {
        Employee employee;
        employee = new EmployeeImpl();
        employee.setUuid(UUID.randomUUID());
        employee.setFirstName("John");
        employee.setLastName("Doe");
        employee.setFullName("John Doe");
        employee.setEmail("johndoe@email.com");
        employee.setJobTitle("Java Developer");
        employee.setAge(21);
        employee.setSalary(80000);
        employee.setContractHireDate(LocalDate.of(2026, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());
        employee.setContractTerminationDate(LocalDate.of(2028, 1, 1).atStartOfDay(ZoneId.systemDefault()).toInstant());

        employees.add(employee);

        employee = new EmployeeImpl();
        employee.setUuid(UUID.randomUUID());
        employee.setFirstName("Jane");
        employee.setLastName("Doe");
        employee.setFullName("Jane Doe");
        employee.setEmail("janedoe@email.com");
        employee.setJobTitle("C++ Developer");
        employees.add(employee);
    }

    public List<Employee> getAllEmployees() {
        return employees;
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer. Generate mock Employee model as necessary.
     * @param uuid Employee UUID
     * @return Requested Employee if exists
     */

    public Employee getEmployeeByUuid(UUID uuid) {
        return getAllEmployees()
                .stream()
                .filter(e -> uuid.equals(e.getUuid()))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find employee"));
    }

    /**
     * @implNote Need not be concerned with an actual persistence layer.
     * @param requestBody hint!
     * @return Newly created Employee
     */

    public Employee createEmployee(Object requestBody) {
        Map<String, Object> map = (Map<String, Object>) requestBody;

        Employee employee = new EmployeeImpl();
        employee.setUuid(UUID.randomUUID());
        employee.setFirstName((String) map.get("firstName"));
        employee.setLastName((String) map.get("lastName"));
        employee.setFullName((String) map.get("fullName"));
        employee.setEmail((String) map.get("email"));
        employee.setJobTitle((String) map.get("jobTitle"));
        employee.setAge((Integer) map.get("age"));
        employee.setSalary((Integer) map.get("salary"));
        String contractHireDate = (String) map.get("contractHireDate");
        employee.setContractHireDate(Instant.parse(contractHireDate));
        String contractTerminationDate = (String) map.get("contractTerminationDate");
        employee.setContractTerminationDate(Instant.parse(contractTerminationDate));

        employees.add(employee);
        return employee;
    }
}
