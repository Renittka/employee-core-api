package kz.dar.academy.backend.service.deprecated;

import kz.dar.academy.backend.model.EmployeeModel;

import java.util.List;

public interface EmployeeServiceOld {
    void createEmployee(EmployeeModel employeeModel);

    List<EmployeeModel> getAllEmployees();

    EmployeeModel getEmployeeById(String employeeId);

    void updateEmployeeById(String employeeId, EmployeeModel employeeModel);

    void deleteEmployeeById(String employeeId);
}
