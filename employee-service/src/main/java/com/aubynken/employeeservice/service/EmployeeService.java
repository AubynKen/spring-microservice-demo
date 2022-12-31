package com.aubynken.employeeservice.service;

import com.aubynken.employeeservice.dto.APIResponseDto;
import com.aubynken.employeeservice.dto.DepartmentDto;
import com.aubynken.employeeservice.dto.EmployeeDto;
import com.aubynken.employeeservice.entity.Employee;
import com.aubynken.employeeservice.exception.ResourceNotFoundException;
import com.aubynken.employeeservice.repository.EmployeeRepository;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
@AllArgsConstructor
public class EmployeeService {

    private EmployeeRepository employeeRepository;
    private ModelMapper modelMapper;
    private APIClient apiClient;

    public EmployeeDto saveEmployee(EmployeeDto employeeDto) {
        Employee employee = modelMapper.map(employeeDto, Employee.class);
        Employee savedEmployee = employeeRepository.save(employee);
        return modelMapper.map(savedEmployee, EmployeeDto.class);
    }

    public APIResponseDto getEmployeeById(Long employeeId) {
        Employee employee = employeeRepository.findById(employeeId).orElseThrow(
                () -> new ResourceNotFoundException("Employee", "id", employeeId)
        );

        EmployeeDto employeeDto = modelMapper.map(employee, EmployeeDto.class);
        DepartmentDto departmentDto = apiClient.getDepartmentByDepartmentCode(employee.getDepartmentCode());

        return new APIResponseDto(
                employeeDto,
                departmentDto
        );
    }
}
