package pe.com.proempresa.microservicio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pe.com.proempresa.microservicio.dto.Employee;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long> {
}
