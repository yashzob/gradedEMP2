package com.EmpMgmt2.EmpMgmt.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.EmpMgmt2.EmpMgmt.model.Employee;



@Repository
public interface EmployeeRepository extends JpaRepository<Employee, Long >{

}
