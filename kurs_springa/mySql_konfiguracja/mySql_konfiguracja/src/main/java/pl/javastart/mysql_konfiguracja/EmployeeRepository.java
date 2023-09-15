package pl.javastart.mysql_konfiguracja;

import org.springframework.data.repository.CrudRepository;

interface EmployeeRepository extends CrudRepository<Employee, Long> {
}
