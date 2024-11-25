package pe.com.proempresa.microservicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import pe.com.proempresa.microservicio.dto.Employee;
import pe.com.proempresa.microservicio.service.EmployeeService;

import java.util.Arrays;

@SpringBootApplication
public class MicroservicioApplication implements CommandLineRunner {

	@Autowired
	private EmployeeService service;

	public static void main(String[] args) {
		SpringApplication.run(MicroservicioApplication.class, args);
	}

	@Override
	public void run(String... args) {
		service.saveEmployees(Arrays.asList(
				new Employee("Juan Pérez", "Analista"),
				new Employee("María Gómez", "Desarrollador"),
				new Employee("Pedro Ruiz", "Gerente"),
				new Employee("Ana López", "Tester"),
				new Employee("Luis Castillo", "Scrum Master"),
				new Employee("Sofía Torres", "Arquitecto"),
				new Employee("Carlos Vega", "DevOps"),
				new Employee("Clara Ramos", "Product Owner"),
				new Employee("Ricardo Cruz", "Diseñador UX"),
				new Employee("Elena Ortiz", "Consultor")
		));
	}
}
