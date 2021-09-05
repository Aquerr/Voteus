package pl.bartlomiejstepien.voteus.converter;

import org.springframework.stereotype.Service;
import pl.bartlomiejstepien.voteus.dto.DepartmentDto;
import pl.bartlomiejstepien.voteus.repository.entity.Department;

@Service
public class DepartmentConverter
{
    public DepartmentDto convertToDto(Department department)
    {
        if (department == null)
            return null;

        DepartmentDto departmentDto = new DepartmentDto();
        departmentDto.setId(department.getId());
        departmentDto.setName(department.getName());
        return departmentDto;
    }

    public Department convertToEntity(DepartmentDto departmentDto)
    {
        if(departmentDto == null)
            return null;

        Department department = new Department();
        department.setId(departmentDto.getId());
        department.setName(departmentDto.getName());
        return department;
    }
}
