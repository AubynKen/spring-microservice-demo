package com.aubynken.employeeservice.entity;


import lombok.*;

import javax.persistence.*;

@Getter
@Setter
@ToString //TODO: remove
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "employees")
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String firstName, lastName;
    @Column(unique = true, nullable = false)
    private String email;
    private String departmentCode;
}
