package kz.dar.academy.backend.service.employee;

import kz.dar.academy.backend.model.EmployeeRequest;
import kz.dar.academy.backend.model.EmployeeResponse;

import java.util.List;

public interface EmployeeService {
    EmployeeResponse createEmployee(EmployeeRequest employeeRequest);

    EmployeeResponse updateEmployee(EmployeeRequest employeeRequest);

    List<EmployeeResponse> getAllEmployees();

    EmployeeResponse getEmployeeById(String employeeId);

    void deleteEmployeeById(String employeeId);
}
