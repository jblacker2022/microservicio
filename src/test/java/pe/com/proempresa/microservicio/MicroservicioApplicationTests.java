package pe.com.proempresa.microservicio;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.beans.factory.annotation.Autowired;
import pe.com.proempresa.microservicio.service.EmployeeService;

import static org.junit.jupiter.api.Assertions.assertNotNull;


@SpringBootTest
class MicroservicioApplicationTests {

	// Inyectamos el servicio que queremos probar
	@Autowired
	private EmployeeService employeeService;

	@Test
	void contextLoads() {
		// Verificamos que el contexto de Spring cargue correctamente
		assertNotNull(employeeService, "El servicio de empleados debe estar cargado.");
	}

	@Test
	void testGetEmployeeList() {
		// Prueba que la lista de empleados no esté vacía
		assertNotNull(employeeService.getAllEmployees(), "La lista de empleados no debe ser nula.");
	}
}
