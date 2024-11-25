package pe.com.proempresa.microservicio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pe.com.proempresa.microservicio.dto.Employee;
import pe.com.proempresa.microservicio.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    private EmployeeRepository repository;

    public List<Employee> getAllEmployees() {
        return repository.findAll();
    }

    public void saveEmployees(List<Employee> employees) {
        repository.saveAll(employees);
    }
}
