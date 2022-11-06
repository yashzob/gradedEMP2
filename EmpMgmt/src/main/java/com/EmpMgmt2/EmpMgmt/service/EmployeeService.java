package com.EmpMgmt2.EmpMgmt.service;

import java.util.HashSet;
import java.util.Set;

import org.springframework.stereotype.Service;

import com.EmpMgmt2.EmpMgmt.model.Employee;
import com.EmpMgmt2.EmpMgmt.repository.EmployeeRepository;



@Service
public class EmployeeService {
	// this is a variable Data store
	// private Set<Employee> employee = new HashSet<>();

	private final EmployeeRepository employeeRepository;

	public EmployeeService(EmployeeRepository employeeRepository) {
		this.employeeRepository=employeeRepository;
	}
 
	public Employee addEmployee(Employee employee) {
		System.out.println("Saving a Employee....");
		System.out.println(employee);
		Employee savedEmployee=this.employeeRepository.save(employee);
		return savedEmployee;
	}

	public Set<Employee> fetchAllEmployee() {
		return new HashSet<>(this.employeeRepository.findAll());

	}

	public Employee fetchEmployeeById(long employeeId) {
		return this.employeeRepository
				.findById(employeeId)
				.orElseThrow(
				() -> new IllegalArgumentException("Invalid EmployeeId Is passed, Please enter the right one"));
	}

	public void deleteEmployeeById(long employeeId) {
		this.employeeRepository.deleteById(employeeId);
	}
	
	public Employee updateEmployee(long employeeId,Employee updatedEmployee) {
		Employee employeeFromRepository= this.fetchEmployeeById(employeeId);
		employeeFromRepository.setEmail(updatedEmployee.getEmail());
		employeeFromRepository.setFirstName(updatedEmployee.getFirstName());
		employeeFromRepository.setLastName(updatedEmployee.getLastName());
		//i am getting the output of this as expected
		
		//Employee savedEmployee=this.employeeRepository.save(updatedEmployee);
		//System.out.println(savedEmployee);
		//return savedEmployee;
		this.employeeRepository.save(employeeFromRepository);
		return (employeeFromRepository);
		
	}
}
