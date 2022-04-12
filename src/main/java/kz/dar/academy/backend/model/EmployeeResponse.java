package kz.dar.academy.backend.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class EmployeeResponse {
    private String employeeId;
    private String name;
    private String surname;
    private String company;
    private String position;
    private String email;
    private double salary;
}
