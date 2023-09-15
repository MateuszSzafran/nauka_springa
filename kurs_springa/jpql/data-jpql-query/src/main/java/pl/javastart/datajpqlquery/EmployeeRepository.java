package pl.javastart.datajpqlquery;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

interface EmployeeRepository extends CrudRepository<Employee, Long> {


    @Query("SELECT e FROM Employee e WHERE e.lastName = :lastName AND e.salary > :salary")
    List<Employee> getByLastNameAndMinSalary(String lastName, double salary);

    @Query("UPDATE Employee e SET e.salary = e.salary + 100")
    @Modifying
    @Transactional
    void giveRiseToAll();
}

