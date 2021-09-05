package pl.bartlomiejstepien.voteus.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import pl.bartlomiejstepien.voteus.repository.entity.Department;

public interface DepartmentRepository extends JpaRepository<Department, Long>
{

}
