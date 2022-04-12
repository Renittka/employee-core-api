package kz.dar.academy.backend.service.deprecated;

import kz.dar.academy.backend.model.EmployeeModel;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

@Service
public class EmployeeServiceImplOld implements EmployeeServiceOld {
    private static final HashMap<String, EmployeeModel> employeeMap = new HashMap<>();

    static {
        EmployeeModel employeeModel1 = new EmployeeModel(UUID.randomUUID().toString(), "Ivan", "Petrov",
                "DAR", "Engineer", "example1@gmail.com", 300000);
        EmployeeModel employeeModel2 = new EmployeeModel(UUID.randomUUID().toString(), "Maria", "Petrova",
                "DAR", "Engineer", "example2@gmail.com", 200000);
        EmployeeModel employeeModel3 = new EmployeeModel(UUID.randomUUID().toString(), "Ivan", "Smith",
                "DAR", "Engineer", "example3@gmail.com", 100000);
        employeeMap.put(employeeModel1.getEmployeeId(), employeeModel1);
        employeeMap.put(employeeModel2.getEmployeeId(), employeeModel2);
        employeeMap.put(employeeModel3.getEmployeeId(), employeeModel3);

    }

    @Override
    public void createEmployee(EmployeeModel employeeModel) {
        employeeModel.setEmployeeId(UUID.randomUUID().toString());
        employeeMap.put(employeeModel.getEmployeeId(), employeeModel);
    }

    @Override
    public List<EmployeeModel> getAllEmployees() {
        return new ArrayList<>(employeeMap.values());
    }

    @Override
    public EmployeeModel getEmployeeById(String employeeId) {
        return employeeMap.get(employeeId);
    }

    @Override
    public void updateEmployeeById(String employeeId, EmployeeModel employeeModel) {
        employeeModel.setEmployeeId(employeeId);
        employeeMap.put(employeeId, employeeModel);
    }

    @Override
    public void deleteEmployeeById(String employeeId) {
        employeeMap.remove(employeeId);
    }
}
