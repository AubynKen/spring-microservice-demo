package com.aubynken.departmentservice.controller;

import com.aubynken.departmentservice.dto.DepartmentDto;
import com.aubynken.departmentservice.service.DepartmentService;
import lombok.AllArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
@AllArgsConstructor
public class DepartmentController {

    private DepartmentService departmentService;
    private ModelMapper modelMapper;

    @PostMapping
    public ResponseEntity<DepartmentDto> createDepartment(@RequestBody DepartmentDto departmentDto) {
        DepartmentDto createdDepartmentDto = departmentService.createDepartment(departmentDto);
        return new ResponseEntity<>(createdDepartmentDto, HttpStatus.CREATED);
    }

    @GetMapping("/{department-code}")
    public ResponseEntity<DepartmentDto> getDepartmentByDepartmentCode(
            @PathVariable("department-code") String departmentCode) {
        DepartmentDto departmentDto = departmentService.getDepartmentByDepartmentCode(departmentCode);
        return ResponseEntity.ok().body(departmentDto);
    }
}
