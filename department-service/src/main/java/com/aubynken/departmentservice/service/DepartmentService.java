package com.aubynken.departmentservice.service;

import com.aubynken.departmentservice.dto.DepartmentDto;
import com.aubynken.departmentservice.entity.Department;
import com.aubynken.departmentservice.repository.DepartmentRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@AllArgsConstructor
public class DepartmentService {

    private ModelMapper modelmapper;
    private DepartmentRepository departmentRepository;

    public DepartmentDto createDepartment(DepartmentDto departmentDto) {
        Department department = modelmapper.map(departmentDto, Department.class);
        Department savedDepartment = departmentRepository.save(department);
        return modelmapper.map(savedDepartment, DepartmentDto.class);
    }

    public DepartmentDto getDepartmentByDepartmentCode(String departmentCode) {
        Department department = departmentRepository.findByDepartmentCode(departmentCode);
        return modelmapper.map(department, DepartmentDto.class);
    }

}
