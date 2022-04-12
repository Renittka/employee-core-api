package kz.dar.academy.backend.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.List;

@Repository
public interface EmployeeRepository extends CrudRepository<EmployeeEntity, Long> {
    EmployeeEntity getEmployeeEntityByEmployeeId(String employeeId);

    List<EmployeeEntity> getEmployeeEntitiesBy();

    @Transactional
    void deleteEmployeeEntityByEmployeeId(String employeeId);
}
