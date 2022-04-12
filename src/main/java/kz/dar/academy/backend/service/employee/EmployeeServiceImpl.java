package kz.dar.academy.backend.service.employee;

import kz.dar.academy.backend.model.EmployeeRequest;
import kz.dar.academy.backend.model.EmployeeResponse;
import kz.dar.academy.backend.repository.EmployeeEntity;
import kz.dar.academy.backend.repository.EmployeeRepository;
import org.modelmapper.ModelMapper;
import org.modelmapper.convention.MatchingStrategies;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    @Autowired
    private EmployeeRepository employeeRepository;

    @Override
    public EmployeeResponse createEmployee(EmployeeRequest employeeRequest) {
        employeeRequest.setEmployeeId(UUID.randomUUID().toString());

        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        EmployeeEntity employeeEntity = modelMapper.map(employeeRequest, EmployeeEntity.class);

        employeeEntity = employeeRepository.save(employeeEntity);
        return modelMapper.map(employeeEntity, EmployeeResponse.class);
    }

    @Override
    public EmployeeResponse updateEmployee(EmployeeRequest employeeRequest) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);
        EmployeeEntity employeeEntity = modelMapper.map(employeeRequest, EmployeeEntity.class);

        EmployeeEntity dbEntity = employeeRepository.getEmployeeEntityByEmployeeId(employeeRequest.getEmployeeId());

        employeeEntity.setId(dbEntity.getId());

        employeeEntity = employeeRepository.save(employeeEntity);

        return modelMapper.map(employeeEntity, EmployeeResponse.class);
    }

    @Override
    public List<EmployeeResponse> getAllEmployees() {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        return employeeRepository.getEmployeeEntitiesBy().stream()
                .map(employee -> modelMapper.map(employee, EmployeeResponse.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeResponse getEmployeeById(String employeeId) {
        ModelMapper modelMapper = new ModelMapper();
        modelMapper.getConfiguration().setMatchingStrategy(MatchingStrategies.STRICT);

        EmployeeEntity employeeEntity = employeeRepository.getEmployeeEntityByEmployeeId(employeeId);
        return modelMapper.map(employeeEntity, EmployeeResponse.class);
    }

    @Override
    public void deleteEmployeeById(String employeeId) {
        employeeRepository.deleteEmployeeEntityByEmployeeId(employeeId);
    }
}
